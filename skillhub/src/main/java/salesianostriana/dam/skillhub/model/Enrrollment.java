package main.java.salesianostriana.dam.skillhub.model;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "enrollments", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "course_id"})
})
public class Enrrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @ToString.Exclude
    private Course course;

    private LocalDateTime enrolledAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private EnrollmentStatus status = EnrollmentStatus.ENROLLED;

    @Column(nullable = false)
    @Builder.Default
    private Double progress = 0.0;

    @PrePersist
    protected void onEnroll() {
        enrolledAt = LocalDateTime.now();
    }
}