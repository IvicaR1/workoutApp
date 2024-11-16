package mk.ukim.finki.workoutapp.repositories;

import mk.ukim.finki.workoutapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByCategory(String category);
}
