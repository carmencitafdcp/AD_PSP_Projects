package main.java.salesianostriana.dam.skillhub.model;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private Integer orderInCourse;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @ToString.Exclude
    private Course course;
}
            