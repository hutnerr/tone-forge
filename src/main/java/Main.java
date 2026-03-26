package main.java;

import main.java.utils.Clogger;
import main.java.utils.EnvReader;

class Main {
    public static void main(String[] args) 
    {
        Clogger.info("Hello, World");
        String apiKey = EnvReader.getEnv("GEMINI_API_KEY");
        Clogger.info("API Key: " + apiKey);
    }
}