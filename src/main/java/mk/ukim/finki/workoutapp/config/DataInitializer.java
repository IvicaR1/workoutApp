package mk.ukim.finki.workoutapp.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.workoutapp.model.Exercise;
import mk.ukim.finki.workoutapp.repositories.ExerciseRepository;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {


    private final ExerciseRepository exerciseRepository;

    public DataInitializer(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @PostConstruct
    public void init() {
        if (exerciseRepository.count() == 0) {
            List<Exercise> exercises = Arrays.asList(

                    // Weight Loss Exercises
                    new Exercise("Running", "Burn calories and improve cardiovascular health with running!", "https://www.youtube.com/watch?v=_kGESn8ArrU", "weightloss", "running.jpg"),
                    new Exercise("Jump Rope", "An excellent full-body workout to burn calories and improve coordination!", "https://www.youtube.com/watch?v=u3zgHI8QnqE", "weightloss", "jumprope.jpg"),
                    new Exercise("Cycling", "A low-impact exercise that helps to burn calories and build endurance!", "https://www.youtube.com/watch?v=aL2RQPcd0-w", "weightloss", "cycling.jpg"),
                    new Exercise("Burpee", "The Ultimate Full-Body Fat-Burning Workout!", "https://www.youtube.com/watch?v=xQdyIrSSFnE", "weightloss", "burpees.jpg"),
                    new Exercise("Stair Climbing", "Step Up to a Stronger, Fitter You! ", "https://www.youtube.com/watch?v=Y1-uwSGuD5w", "weightloss", "stairsclimbing.jpg"),
                    new Exercise("Mountain Climbing", "Reach New Heights, Shed Extra Pounds!", "https://www.youtube.com/watch?v=bJgN9jGYEV0", "weightloss", "mountainclimbing.png"),
                    new Exercise("Kickboxing", "Punch Out Pounds; Kickboxing Your Way to a Fitter You!", "https://www.youtube.com/watch?v=ZcQsi6JYgUQ", "weightloss", "kickboxing.jpg"),
                    new Exercise("Yoga", "Yoga is the way to a Healthier You!", "https://www.youtube.com/watch?v=m756Gz8de4M", "weightloss", "yoga.png"),


                    // Muscle Gain Exercises
                    new Exercise("Bench Press", "Strengthen your chest and triceps with this classic exercise!", "https://www.youtube.com/watch?v=SCVCLChPQFY", "musclegain", "benchpress.jpg"),
                    new Exercise("Squats", "Build your leg muscles and improve core strength!", "https://www.youtube.com/watch?v=4KmY44Xsg2w", "musclegain", "squats.png"),
                    new Exercise("Deadlift", "Enhance your back and leg muscles with deadlifts!", "https://www.youtube.com/watch?v=7j-2w4-P14I", "musclegain", "deadlift.jpg"),
                    new Exercise("Pullup", "Pull Your Weight, gain Muscle, Reach New Heights with Pull-Ups!", "https://www.youtube.com/shorts/f4x3-BGRLFQ", "musclegain", "pullup.png"),
                    new Exercise("Donkey Kicks", "Kick Up Your Workout, Donkey Kicks for a Stronger, Fitter You!", "https://www.youtube.com/watch?v=VBFUJEGAN94&list=RDQMwegtPAkIW4U&start_radio=1", "musclegain", "donkeykicks.png"),
                    new Exercise("Knee Push-ups", "Build Strength from the Ground Up. Master Your Fitness with Knee Push-Ups!", "https://www.youtube.com/watch?v=bwWlK8f1-NM", "musclegain", "kneepushup.jpg"),
                    new Exercise("Dip", "Sculpt Your Strength!", "https://www.youtube.com/watch?v=iEsDnKNejt0", "musclegain", "dip.png"),
                    new Exercise("Push-ups", "Push Your Limits, Build Your Strength, Transform with Push-Ups!", "https://www.youtube.com/watch?v=9-DlYB4vO4U", "musclegain", "pushup.jpg"),


                    // Body Posture Exercises
                    new Exercise("Plank", "Improve core strength and stability with planks.", "https://www.youtube.com/watch?v=pvIjsG5Svck", "bodyposture", "plank.jpg"),
                    new Exercise("Bridge", "Strengthen your glutes and lower back with bridges.", "https://www.youtube.com/watch?v=_leI4qFfPVw", "bodyposture", "bridge.png"),
                    new Exercise("Cat-Cow Stretch", "Enhance spinal flexibility and posture with this stretch.", "https://www.youtube.com/watch?v=vuyUwtHl694", "bodyposture", "catcowstretch.jpg"),
                    new Exercise("Child Pose", "Relax, Restore, Renew: Embrace Wellness with Child's Pose!", "https://www.youtube.com/watch?v=kH12QrSGedM", "bodyposture", "childpose.jpg"),
                    new Exercise("Wall Angel", "Rise to New Heights: Strengthen Your Core with Wall Angels!", "https://www.youtube.com/watch?v=YO87HFVgsGo", "bodyposture", "wallangel.jpg"),
                    new Exercise("Bird-Dog exercise", "Balance and Strengthen: Soar to Fitness with Bird Dog!", "https://www.youtube.com/watch?v=QABW99qPiNM", "bodyposture", "birddog.jpg"),
                    new Exercise("Downward Dog", "Stretch, Strengthen, Align: Reach New Heights with Downward Dog", "https://www.youtube.com/watch?v=EC7RGJ975iM", "bodyposture", "downwarndogpose.jpg"),
                    new Exercise("Forward Fold", "Bend, Reach, Renew: Embrace Wellness with Forward Fold!", "https://www.youtube.com/watch?v=BNfbsx_nCRI", "bodyposture", "forwardfold.jpg"),


                    // Health Exercises
                    new Exercise("Yoga", "Maintain overall health and reduce stress with yoga.", "https://www.youtube.com/watch?v=m756Gz8de4M", "health", "yoga.jpg"),
                    new Exercise("Swimming", "A low-impact exercise that benefits cardiovascular and muscular health.", "https://www.youtube.com/shorts/PRW4lTGG7Pg", "health", "swimming.jpg"),
                    new Exercise("Walking", "A simple and effective way to maintain overall health.", "https://www.youtube.com/watch?v=XmJjdSsVyB0", "health", "walking.png"),
                    new Exercise("Bird Dog", "Balance and Strengthen: Soar to Fitness with Bird Dog!", "https://www.youtube.com/watch?v=QABW99qPiNM", "health", "birddog.jpg"),
                    new Exercise("Donkey Kicks", "Kick Up Your Workout: Donkey Kicks for a Stronger, Fitter You!", "https://www.youtube.com/watch?v=VBFUJEGAN94&list=RDQMwegtPAkIW4U&start_radio=1", "health", "donkeykicks.png"),
                    new Exercise("Child Pose", "Relax, Restore, Renew: Embrace Wellness with Child's Pose!", "https://www.youtube.com/watch?v=kH12QrSGedM", "health", "childpose.jpg"),
                    new Exercise("Cycling", "A low-impact exercise that helps to burn calories and build endurance.", "https://www.youtube.com/watch?v=aL2RQPcd0-w", "health", "cycling.jpg"),
                    new Exercise("Cat-Cow Stretch", "Enhance spinal flexibility and posture with this stretch.", "https://www.youtube.com/watch?v=vuyUwtHl694", "health", "catcowstretch.jpg")
            );

            exerciseRepository.saveAll(exercises);
        }
    }
}
