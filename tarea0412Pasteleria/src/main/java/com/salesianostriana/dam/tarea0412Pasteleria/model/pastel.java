package com.salesianostriana.dam.tarea0412Pasteleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class pastel {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
}
