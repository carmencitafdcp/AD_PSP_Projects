package main.java.salesianostriana.dam.skillhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.salesianostriana.dam.skillhub.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructorId(Long instructorId);

    @Query("SELECT course FROM Course course JOIN course.categories category WHERE category.id = :categoryId")
    List<Course> findByCategoryId(@Param("categoryId") Long categoryId);
}
