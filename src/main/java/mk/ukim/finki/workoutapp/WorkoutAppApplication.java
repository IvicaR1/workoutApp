package mk.ukim.finki.workoutapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WorkoutAppApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WorkoutAppApplication.class, args);
    }

}
