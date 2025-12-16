package com.salesianostriana.dam.tarea0412Pasteleria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Builder
@ToString
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto p) {
        productos.add(p);
        p.setCategoria(this);
    }

    public void removeProducto(Producto p) {
        productos.remove(p);
        p.setCategoria(null);
    }
}
