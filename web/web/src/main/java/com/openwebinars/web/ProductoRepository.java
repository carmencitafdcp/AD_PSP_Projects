package com.openwebinars.web;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {
    public List<Producto> findAll() {
        return List.of(
                new Producto(1L, "Producto 1", 10.0, true),
                new Producto(2L, "Producto 2", 20.0, false),
                new Producto(3L, "Producto 3", 30.0, true),
                new Producto(4L, "Producto 3", 30.0, true),
                new Producto(5L, "Producto 3", 30.0, false),
                new Producto(6L, "Producto 3", 30.0, false)
        );
    }
}
