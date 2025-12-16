package main.java.salesianostriana.dam.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.java.salesianostriana.dam.skillhub.model.Category;
import main.java.salesianostriana.dam.skillhub.model.Course;
import main.java.salesianostriana.dam.skillhub.model.Lesson;
import main.java.salesianostriana.dam.skillhub.model.User;
import main.java.salesianostriana.dam.skillhub.model.UserRole;
import main.java.salesianostriana.dam.skillhub.repository.CategoryRepository;
import main.java.salesianostriana.dam.skillhub.repository.CourseRepository;
import main.java.salesianostriana.dam.skillhub.repository.LessonRepository;
import main.java.salesianostriana.dam.skillhub.repository.UserRepository;
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final LessonRepository lessonRepository;

    //Crear Curso con lecciones
    @Transactional
    public Course createCourseWithLessons(
            Long instructorId,
            String title,
            String description,
            Double price,
            Set<Long> categoryIds,
            List<LessonData> initialLessons
    ) {
        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Ups! El instructor no ha sido encontrado."));

        if (instructor.getRole() != UserRole.INSTRUCTOR) {
            throw new RuntimeException("El usuario debe ser un instructor.");    
        }

        Course course = Course.builder()
                .title(title)
                .description(description)
                .price(price)
                .instructor(instructor)
                .build();

        for (Long categoryId : categoryIds) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + categoryId));
            course.getCategories().add(category);
        }

        int order = 1;
        for (LessonData lessonData : initialLessons) {
            Lesson lesson = Lesson.builder()
                    .title(lessonData.getTitle())
                    .content(lessonData.getContent())
                    .durationMinutes(lessonData.getDurationMinutes())
                    .orderIndex(order++)
                    .build();
            course.addLesson(lesson);
        }

        return courseRepository.save(course);
    }

    //Ordenar cursos por categoría
    public List<Course> getCoursesByCategory(Long categoryId) {
        return courseRepository.findByCategoryId(categoryId);
    }

    //Para pasar datos de lección
    @lombok.Data
    @lombok.AllArgsConstructor
    @lombok.NoArgsConstructor
    public static class LessonData {
        private String title;
        private String content;
        private Integer durationMinutes;
    }
}
