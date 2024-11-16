package mk.ukim.finki.workoutapp.service.impl;

import mk.ukim.finki.workoutapp.model.User;
import mk.ukim.finki.workoutapp.model.WorkoutFrequency;
import mk.ukim.finki.workoutapp.model.exceptions.InvalidUserIdExeption;
import mk.ukim.finki.workoutapp.repositories.UserRepository;
import mk.ukim.finki.workoutapp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(String username, String password, Integer height, Integer weight, WorkoutFrequency workoutFrequency) {
        if(username != null && password != null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setHeight(height);
            user.setWeight(weight);
            user.setWorkoutFrequency(workoutFrequency);
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    public User authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(InvalidUserIdExeption::new);
    }

    @Override
    public User updateUserProfile(Long id ,String username, String password, Integer height, Integer weight) {
        User user = getUserById(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setHeight(height);
        user.setWeight(weight);
        return  userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public double calculateBmi(Integer height, Integer weight) {
        double heightInMeters = height / 100.00;
        return weight / (heightInMeters * heightInMeters);
    }

    @Override
    public String getWeightCategory(double bmi) {
        if(bmi <= 18.5) {
            return "Underweight";
        } else if(bmi >= 18.6 && bmi <= 24.9) {
            return "Healthy weight";
        } else if(bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
