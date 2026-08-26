package com.nttdata.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.nttdata.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/multi-param")
public class RequestParamController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false) String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    }
    

    // Esta ruta permite inyectar los parametros directamente desde la request usando HttpServletRequest
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {

        Integer code  = 0;

        try {
            code =Integer.parseInt(request.getParameter("code"));
        }catch(NumberFormatException e){
        }
        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setCode(code);
        paramMixDto.setMessage(request.getParameter("message"));
        return paramMixDto;
    }
    
    

}
