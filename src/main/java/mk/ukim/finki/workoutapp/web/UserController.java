    package mk.ukim.finki.workoutapp.web;

    import mk.ukim.finki.workoutapp.model.Exercise;
    import mk.ukim.finki.workoutapp.model.User;
    import mk.ukim.finki.workoutapp.repositories.ExerciseRepository;
    import mk.ukim.finki.workoutapp.repositories.UserRepository;
    import mk.ukim.finki.workoutapp.service.UserService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;

    @Controller
    public class UserController {

        private final UserRepository userRepository;
        private final UserService userService;
        private final ExerciseRepository exerciseRepository;
        private final BCryptPasswordEncoder passwordEncoder;

        public UserController(UserRepository userRepository, UserService userService, ExerciseRepository exerciseRepository, BCryptPasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.userService = userService;
            this.exerciseRepository = exerciseRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @GetMapping({"/", "/home"})
        public String showHomePage(Model model) {
            return "homepage.html";
        }

        @GetMapping({"/about"})
        public String showAboutPage(Model model) {
            return "aboutpage.html";
        }

        @GetMapping({"/register"})
        public String showRegisterForm(Model model) {
            model.addAttribute("registerRequest", new User());
            return "registerpage.html";
        }

        @PostMapping("/register")
        public String processRegistrationForm(@ModelAttribute User user, BindingResult result) {
            if (result.hasErrors()) {
                return "registerpage.html";
            }
            System.out.println("Register request: " + user);
            if (user.getUsername() != null && user.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                User registeredUser = userService.registerUser(
                        user.getUsername(),
                        user.getPassword(),
                        user.getHeight(),
                        user.getWeight(),
                        user.getWorkoutFrequency()
                );
                return registeredUser == null ? "error_page" : "redirect:/home";
            }
            return "error_page";
        }

        @GetMapping({"/login"})
        public String showLoginForm(Model model) {
            model.addAttribute("loginRequest", new User());
            return "loginpage.html";
        }

        @PostMapping("/login")
        public String processLoginForm(@ModelAttribute User user) {
            System.out.println("Login request: " + user);
            User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
            return authenticatedUser == null ? "error_page" : "redirect:/exercises";
        }

        @GetMapping({"/exercises"})
        public String showExercisesPage(Model model) {
            return "exercises.html";
        }

        @GetMapping("/bmicalculator")
        public String showBmiCalculatorForm(Model model) {
            model.addAttribute("bmi", "");
            model.addAttribute("weightCategory", "");
            return "bmicalculator.html";
        }

        @PostMapping("/bmicalculator")
        public String calculateBmi(@RequestParam Integer height,
                                   @RequestParam Integer weight,
                                   Model model) {
            double bmi = userService.calculateBmi(height, weight);
            String weightCategory = userService.getWeightCategory(bmi);
            model.addAttribute("bmi", String.format("%.2f", bmi));
            model.addAttribute("weightCategory", weightCategory);
            return "bmicalculator.html";
        }

        @GetMapping("/exercises/category")
        public String showExercisesByCategory(@RequestParam String category, Model model) {
            List<Exercise> exercises = exerciseRepository.findByCategory(category);
            model.addAttribute("exercises", exercises);
            return "exercises_by_category.html";
        }
    }
