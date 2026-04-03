package com.example.toneforge.util;

import java.util.HashMap;

public class EnvReader {
    private static final HashMap<String, String> loaded = loadDotEnv();
    private static final String DOTENV_PATH = "src/main/resources/.env";

    public static String getEnv(String key) 
    {
        if (loaded.containsKey(key)) 
        {
            Clogger.debug("Found key in .env: " + key);
            return loaded.get(key);
        }
        Clogger.debug("Key not found in .env, checking system environment: " + key);
        return System.getenv(key);
    }

    public static String getEnv(String key, boolean useDotEnv)
    {
        if (useDotEnv) return getEnv(key);
        return System.getenv(key);
    }

    private static HashMap<String, String> loadDotEnv()
    {
        HashMap<String, String> loadedTemp = new HashMap<>();

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(DOTENV_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    loadedTemp.put(key, value);
                    Clogger.debug("Loaded from .env: " + key + "=" + value);
                }
            }
        } 
        catch (java.io.IOException e) 
        {
            Clogger.error("Error loading .env file: " + e.getMessage());
        }

        Clogger.debug("Finished loading .env file. Total keys loaded: " + loadedTemp.size());
        return loadedTemp;
    }
}