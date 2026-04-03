package com.example.toneforge.model;

public class ConversionRequest 
{
    private String text;
    private String strategy;

    public ConversionRequest() {} // default constructor for deserialization
    public ConversionRequest(String text, String strategy) 
    {
        this.text = text;
        this.strategy = strategy;
    }

    public String getText() { return text; }
    public String getStrategy() { return strategy; }

    public void setText(String text) { this.text = text; }
    public void setStrategy(String strategy) { this.strategy = strategy; }
}