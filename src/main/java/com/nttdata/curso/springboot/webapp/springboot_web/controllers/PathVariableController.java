package com.nttdata.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nttdata.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.nttdata.curso.springboot.webapp.springboot_web.models.dto.User;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    /* El path variable es mas comun en las APIs REST ya que 
     * permite identificar recursos de manera unica y consistente.
     * ademas que es mas amigable para los motores de busqueda y para la navegacion de los usuarios. 
    */
    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;


    @GetMapping("/baz/{message}/{code}")
    public ParamDto baz(@PathVariable String message, @PathVariable Integer code) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        paramDto.setCode(code);
        return paramDto;    
    }

    @GetMapping("/mix/{product}/{id}/{direccion}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id, @PathVariable String direccion) {
        Map<String, Object> json = new HashMap<>();

        json.put("id", id);
        json.put("product", product);
        json.put("direccion", direccion);

        return json;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        // Hacer algo con el usuario por ejemplo un save en la bdd
        user.setName(user.getName().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        user.setAge(user.getAge().toString().length() > 0 ? user.getAge() : 0);
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("code", code);
        return json;
    }
    
    
}
