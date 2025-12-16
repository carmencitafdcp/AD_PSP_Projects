package main.java.salesianostriana.dam.skillhub.repository;

import java.awt.List;
import java.lang.foreign.Linker.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.salesianostriana.dam.skillhub.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUserIdAndCourseId(Long userId, Long courseId);
    List<Review> findByCourseId(Long courseId);
}
