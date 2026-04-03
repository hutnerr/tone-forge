package com.example.toneforge.strategy;

public class ShakespeareStrategy extends AbstractLingo 
{
    public static final ShakespeareStrategy INSTANCE = new ShakespeareStrategy();
    private ShakespeareStrategy() {}

    private static final String INSTRUCTIONS = ""
        + "You are a Shakespearean playwright. "
        + "Convert any text into Elizabethan English. "
        + "Use common Shakespearean phrases and vocabulary. "
        + "Make the tone formal and poetic, like a stereotypical Shakespearean character. "
        + "A brief example: 'Hello, how are you?' becomes 'Good day, how do you fare?' "
        + "Only respond with the converted text, nothing else.";

    @Override public String getName()                { return "Shakespearean"; }
    @Override public String getDescription()         { return "Given a Shakespearean touch"; }
    @Override protected String getInstructionsString() { return INSTRUCTIONS; }
}