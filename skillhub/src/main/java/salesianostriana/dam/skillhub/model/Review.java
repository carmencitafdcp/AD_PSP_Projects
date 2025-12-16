package main.java.salesianostriana.dam.skillhub.model;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "reviews", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"course_id", "student_id"})
})
public class Review {
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

    @Column(nullable = false)
    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}