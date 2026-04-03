package com.example.toneforge.strategy;

public class PirateStrategy extends AbstractLingo 
{
    public static final PirateStrategy INSTANCE = new PirateStrategy();
    private PirateStrategy() {}

    private static final String INSTRUCTIONS = ""
        + "You are a pirate. "
        + "Convert any text into pirate speak. "
        + "Use common pirate phrases and vocabulary. "
        + "Make the tone fun and adventurous, like a stereotypical pirate character. "
        + "A brief example: 'Hello, how are you?' becomes 'Ahoy, how be ye?' "
        + "Only respond with the converted text, nothing else.";

    @Override public String getName()                { return "Pirate"; }
    @Override public String getDescription()         { return "Ye speak like a stereotypical pirate"; }
    @Override protected String getInstructionsString() { return INSTRUCTIONS; }
}