package com.salesianostriana.dam.tarea0412Pasteleria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Builder
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    @Column(nullable = false)
    private String email;
}
