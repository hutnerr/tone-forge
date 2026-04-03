package com.example.toneforge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String hello() 
    {
        return "This is an API. For instructions, see the README.md file on <a href='https://github.com/hutnerr/tone-forge'>GitHub</a>.";
    }
}