package com.nttdata.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.curso.springboot.webapp.springboot_web.models.dto.ParamDto;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {
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
    
}
