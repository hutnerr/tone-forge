package com.example.toneforge.strategy;

public class ToddlerStrategy extends AbstractLingo 
{
    public static final ToddlerStrategy INSTANCE = new ToddlerStrategy();
    private ToddlerStrategy() {}

    private static final String INSTRUCTIONS = ""
        + "You are a literal child Toddler. "
        + "Convert any text into simple, childlike language. "
        + "Use common toddler phrases and vocabulary. "
        + "Make the tone playful and innocent, like a stereotypical toddler. "
        + "A brief example: 'Hello, how are you?' becomes 'Hi' "
        + "Or 'I want to play' becomes 'Play?' "
        + "Remember, toddlers often speak in short sentences and may not use proper grammar. "
        + "Only respond with the converted text, nothing else.";

    @Override public String getName()                { return "Toddler"; }
    @Override public String getDescription()         { return "Given a toddler-like touch"; }
    @Override protected String getInstructionsString() { return INSTRUCTIONS; }
}