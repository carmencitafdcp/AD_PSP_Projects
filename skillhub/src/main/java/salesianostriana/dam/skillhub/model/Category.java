package main.java.salesianostriana.dam.skillhub.model;

import java.lang.annotation.Inherited;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)    
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private Set<Course> courses = new HashSet<>();
}
