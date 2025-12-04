package com.salesianostriana.dam.tarea0412Pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.tarea0412Pasteleria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
