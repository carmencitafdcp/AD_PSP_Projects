package com.salesianostriana.dam.primerproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class MainController {
    record Person(Long id, String firstName, String lastName){}

    @GetMapping("/hello")
    //@ResponseBody
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/person")
    //@ResponseBody
    public Person getPerson() {
        return new Person(1L, "Carmen", "chacon");
    }

}
