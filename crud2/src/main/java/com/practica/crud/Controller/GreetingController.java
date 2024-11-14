package com.practica.crud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Andy") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting"; // Thymeleaf buscará greeting.html en la carpeta templates
    }

}
