package com.example.toneforge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.toneforge.util.EnvReader;
import com.google.genai.Client;

@Configuration
public class ClientConfig 
{
    @Bean
    public Client genAiClient() 
    {
        String apiKey = EnvReader.getEnv("GEMINI_API_KEY");
        if (apiKey == null || apiKey.isBlank())
        {
            throw new IllegalStateException("GEMINI_API_KEY environment variable is not set or is empty.");
        }

        return Client.builder()
                .apiKey(apiKey)
                .build();
    }
}