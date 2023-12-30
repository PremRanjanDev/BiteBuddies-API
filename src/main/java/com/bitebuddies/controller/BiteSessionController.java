package com.bitebuddies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class BiteSessionController {
    @GetMapping
    public String hello(){
        return "Hello";
    }
}
