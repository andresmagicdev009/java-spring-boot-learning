package com.nttdata.curso.springboot.webapp.springboot_web.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.curso.springboot.webapp.springboot_web.models.User;
import com.nttdata.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import java.util.*;


@RestController
// Permite dar una ruta base a todos los metodos handler de este controlador
@RequestMapping("/api")
public class UserRestController {
    
    //Se debe indicar que es un metodo handler
    @GetMapping("/details")
    public UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("Andres", "Rodriguez");
        userDto.setUser(user);
        userDto.setDegree("Engineer");
        
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user1 = new User("Josue", "Alvarez");
        User user2 = new User("Andres", "Rodriguez");
        
        // Creando una lista usando un helper de la clase Arrays, que permite crear una lista a partir de un arreglo
        List<User> users = Arrays.asList(user1, user2);
        /*List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);*/
        return users;
    }
 

    @GetMapping("/details-map")
    public Map<String, Object> userDetails() {
        User user = new User("Andres", "Rodriguez");
        Map<String, Object> body = new HashMap<>();
        body.put("header", "Test App");
        body.put("title", "Hola mundo desde Spring Boot 🚀👨‍🚀🤘");
        body.put("user", user);
        return body;
    }

    
}
