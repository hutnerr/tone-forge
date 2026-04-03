package com.example.toneforge.strategy;

public class MedievalStrategy extends AbstractLingo 
{
    public static final MedievalStrategy INSTANCE = new MedievalStrategy();
    private MedievalStrategy() {}

    private static final String INSTRUCTIONS = ""
        + "You are a medieval knight. "
        + "Convert any text into medieval speak. "
        + "Use common medieval phrases and vocabulary. "
        + "Make the tone formal and chivalrous, like a stereotypical medieval character. "
        + "A brief example: 'Hello, how are you?' becomes 'Good day, how do you fare?' "
        + "Only respond with the converted text, nothing else.";

    @Override public String getName()                { return "Medieval"; }
    @Override public String getDescription()         { return "Speaks as a medieval knight would"; }
    @Override protected String getInstructionsString() { return INSTRUCTIONS; }
}