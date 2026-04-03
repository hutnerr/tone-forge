package com.example.toneforge.strategy;

public interface LingoInterface
{
    /**
     * Returns the display name of this lingo strategy.
     * @return The name of the lingo (e.g. "Pirate")
     */
    public String getName();

    /**
     * Returns a brief description of what this lingo strategy does.
     * @return A short description of the lingo (e.g. "Converts text to pirate speak")
     */
    public String getDescription();
}