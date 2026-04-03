package com.example.toneforge.strategy;

import com.google.genai.types.Content;
import com.google.genai.types.Part;

public abstract class AbstractLingo implements LingoInterface 
{
    /**
     * Builds the Content object from the instructions string provided by the subclass.
     * @return A Content object containing the instructions for the LLM.
     */
    public Content getInstructions()
    {
        return Content.fromParts(Part.fromText(getInstructionsString()));
    }

    /**
     * Returns the raw instructions string for this lingo strategy.
     * Implemented by each concrete strategy to define its transformation behavior.
     * @return A string containing the instructions for the LLM.
     */
    protected abstract String getInstructionsString();
}