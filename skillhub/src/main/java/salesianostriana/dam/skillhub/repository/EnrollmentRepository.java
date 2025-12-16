package main.java.salesianostriana.dam.skillhub.repository;

import java.util.List;
import java.lang.foreign.Linker.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.salesianostriana.dam.skillhub.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);

    List<Enrollment> findByUserId(Long userId);

    List<Enrollment> findByCourseId(Long courseId);
}
