package com.nttdata.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import com.nttdata.curso.springboot.webapp.springboot_web.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import java.util.*;

@Controller
public class UserController {

    @GetMapping("/details")
    public Model details(Model model) {
        User user = new User("Andres", "Rodriguez");
        model.addAttribute("user", user);
        model.addAttribute("header", "Bienvenido a Spring Boot 🚀");
        user.setEmail("andres@gmail.com");
        return model;
    }

    @GetMapping("/list")
    public String getMethodName(ModelMap model) {
        List<User> users = Arrays.asList(
            new User("Andres", "Rodriguez", "andres@gmail.com"),
            new User("Juan", "Perez"),
            new User("Maria", "Gonzalez"),
            new User("Pedro", "Martinez")
        );
        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }

}
