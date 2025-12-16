package main.java.salesianostriana.dam.skillhub.model;

import java.beans.BeanProperty;

import javax.annotation.processing.Generated;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Course> coursesTeaching = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Enrollment> enrollments = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Review> reviews = new HashSet<>();
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
}
