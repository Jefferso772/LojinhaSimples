package com.example.test.projetoT.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ControlleLogin {

    @GetMapping
    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}
