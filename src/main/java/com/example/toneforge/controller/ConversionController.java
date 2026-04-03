package com.example.toneforge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toneforge.model.ConversionRequest;
import com.example.toneforge.model.ConversionResult;
import com.example.toneforge.service.ConversionService;
import com.example.toneforge.util.Clogger;

@RestController
@RequestMapping("/api")
public class ConversionController 
{
    private final ConversionService conversionService;

    public ConversionController(ConversionService conversionService) 
    {
        this.conversionService = conversionService;
    }

    @PostMapping("/convert")
    public ConversionResult convert(@RequestBody ConversionRequest request) 
    {
        Clogger.log("API", "POST: Received conversion request: " + request);
        return conversionService.convertText(request);
    }

    @GetMapping("/strategies")
    public List<String> strategies() 
    {
        Clogger.log("API", "GET: Getting available conversion strategies");
        return conversionService.getAvailableStrategies();
    }
}


