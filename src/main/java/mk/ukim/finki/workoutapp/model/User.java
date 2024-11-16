package mk.ukim.finki.workoutapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 30)
    private Integer height;

    @Column(nullable = false, length = 30)
    private Integer weight;

    @Enumerated(EnumType.STRING)
    private WorkoutFrequency workoutFrequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public WorkoutFrequency getWorkoutFrequency() {
        return workoutFrequency;
    }

    public void setWorkoutFrequency(WorkoutFrequency workoutFrequency) {
        this.workoutFrequency = workoutFrequency;
    }
}
