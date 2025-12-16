package main.java.salesianostriana.dam.skillhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.salesianostriana.dam.skillhub.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);
}
