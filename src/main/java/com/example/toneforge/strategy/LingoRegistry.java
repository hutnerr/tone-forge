package com.example.toneforge.strategy;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LingoRegistry 
{
    PIRATE(PirateStrategy.INSTANCE),
    MEDIEVAL(MedievalStrategy.INSTANCE),
    SHAKESPEARE(ShakespeareStrategy.INSTANCE),
    TODDLER(ToddlerStrategy.INSTANCE);

    private static final Map<String, LingoRegistry> NAME_MAP =
        Stream.of(values())
              .collect(Collectors.toMap(
                  e -> e.getStrategy().getName().toLowerCase(),
                  e -> e
              ));

    private final LingoInterface strategy;

    LingoRegistry(LingoInterface strategy) { this.strategy = strategy; }
    public LingoInterface getStrategy() { return strategy; }
    public static LingoInterface fromName(String name) 
    { 
        LingoRegistry registry = NAME_MAP.get(name.toLowerCase());
        return registry != null ? registry.getStrategy() : null;
    }
}