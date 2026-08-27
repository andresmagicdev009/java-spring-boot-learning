package com.nttdata.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Se debe indicar que es una clase de configuracion para que Spring la reconozca y pueda inyectar los valores de las propiedades
@Configuration
@PropertySources(
    @PropertySource("classpath:values.properties")
)
public class ValuesConfig {
    
}
