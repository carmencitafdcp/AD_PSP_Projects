package com.salesianostriana.dam.tarea0412Pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.tarea0412Pasteleria.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
