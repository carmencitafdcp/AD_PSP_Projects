package main.java.salesianostriana.dam.skillhub.model;

import java.lang.annotation.Inherited;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale.Category;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Double price;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    @ToString.Exclude
    private User instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Lesson> lessons = new HashSet<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "course_category", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    @Builder.Default
    private Set<Category> categories = new HashSet<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Enrollment> enrollments = new HashSet<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Review> reviews = new HashSet<>();
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
        lesson.setCourse(this);
    }
    
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getCourses().add(this);
    }
}
