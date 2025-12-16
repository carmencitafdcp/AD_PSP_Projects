package main.java.salesianostriana.dam.skillhub.service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    //Matricular usuario en curso
    @Transactional
    public Enrollment enrollUserInCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se ha podido encontrar el usuario."));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("No se ha podido encontrar el curso."));

        enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .ifPresent(e -> {
                    throw new RuntimeException("El usuario ya está matriculado en este curso!");
                });

        Enrollment enrollment = Enrollment.builder()
                .user(user)
                .course(course)
                .status(EnrollmentStatus.ENROLLED)
                .progressPercent(0)
                .build();

        return enrollmentRepository.save(enrollment);
    }

    //Actualizar matrícula
    @Transactional
    public Enrollment updateEnrollmentStatus(Long enrollmentId, Integer newProgress) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("No se ha podido encontrar la matrícula."));

        if (newProgress < 0 || newProgress > 100) {
            throw new RuntimeException("El progreso debe ir de 0 a 100.");
        }

        enrollment.setProgressPercent(newProgress);
        if (newProgress == 100) {
            enrollment.setStatus(EnrollmentStatus.COMPLETED);
        }
        return enrollmentRepository.save(enrollment);
    }
}
