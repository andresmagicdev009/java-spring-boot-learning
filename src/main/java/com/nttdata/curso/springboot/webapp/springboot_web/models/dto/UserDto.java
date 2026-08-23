package com.nttdata.curso.springboot.webapp.springboot_web.models.dto;

import com.nttdata.curso.springboot.webapp.springboot_web.models.User;

public class UserDto {
    private String degree;
    private User user;
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
