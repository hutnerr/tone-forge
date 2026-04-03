package com.example.toneforge.strategy;

import com.example.toneforge.util.Clogger;

public enum LingoRegistry 
{
    PIRATE(PirateStrategy.INSTANCE),
    MEDIEVAL(MedievalStrategy.INSTANCE),
    SHAKESPEARE(ShakespeareStrategy.INSTANCE),
    TODDLER(ToddlerStrategy.INSTANCE);

    private final LingoInterface strategy;

    LingoRegistry(LingoInterface strategy) 
    {
        this.strategy = strategy;
    }

    public LingoInterface getStrategy() { return strategy; }

    public static void listAll() 
    {
        for (LingoRegistry entry : values())
        {
            Clogger.info(entry.getStrategy().getName() + " - " + entry.getStrategy().getDescription());
        }
    }

    public static LingoRegistry fromName(String name) 
    {
        for (LingoRegistry entry : values())
        {
            if (entry.getStrategy().getName().equalsIgnoreCase(name))
            {
                return entry;
            }
        }
        throw new IllegalArgumentException("No strategy found with name: " + name);
    }
}