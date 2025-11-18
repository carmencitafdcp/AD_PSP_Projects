package com.openwebinars.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductoRepository productoRepository;

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("message", "Hola mundo!");
        return "index";
    }

    @GetMapping("/producto/{id}")
    public String ejemploPathVariable(@PathVariable("id") Long id, Model model){
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo");
        }
        model.addAttribute("id", id);
        return "producto";
    }

    @GetMapping("/saludo")
    public String ejemploQueryParam(@RequestParam(name = "nombre", required = false, defaultValue = "user") String nombre, Model model){
        String msg = "Hola, " + nombre;
        model.addAttribute("message", msg);
        return "index";
    }

    @GetMapping("multimap")
    public ResponseEntity<String> ejemploMultiValueMap(@RequestParam MultiValueMap<String, String> params){
        return ResponseEntity.ok(params.toString());
    }

    @ModelAttribute("otroSaludo")
    public String otroSaludo() {
        return "Espero aprender mucho en este curso de spring boot!";
    }

    @GetMapping("/other1")
    @ResponseBody
    public String responseString() {
        return "Hola Mundo!!!";
    }

    @GetMapping("/other2")
    public ResponseEntity<String> responseEntity(){

        return ResponseEntity.ok("Hola Mundo!!!");
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/";
    }

    @GetMapping("/tips")
    public String tipsThymeleaf(Model model) {
//        Producto producto = Producto.builder().id(7L).nombre("Iphone 16 pro").precio(1219.99).build();
//        model.addAttribute("producto", producto);
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("fecha", LocalDateTime.of(2025,1, 1, 10, 25));
          return "tips";
    }
}













