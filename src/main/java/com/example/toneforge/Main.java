package com.example.toneforge;
import com.example.toneforge.model.ConversionRequest;
import com.example.toneforge.model.ConversionResult;
import com.example.toneforge.strategy.LingoInterface;
import com.example.toneforge.strategy.LingoRegistry;
import com.example.toneforge.util.Clogger;
import com.example.toneforge.util.EnvReader;
import com.google.genai.Client;

public class Main {
    public static void main(String[] args) 
    {
        Clogger.debugEnabled = false;

        String testInput;
        testInput = "Hey, can you help me find a good restaurant nearby?";
        // testInput = "Hello, how are you?";
        // testInput = "What is the weather like today?";

        try (Client client = Client.builder()
            .apiKey(EnvReader.getEnv("GEMINI_API_KEY"))
            .build())
        {
            // LingoRegistry.listAll();

            ConversionRequest request = new ConversionRequest(testInput);

            LingoInterface strategy;
            // strategy = LingoRegistry.PIRATE.getStrategy();
            // strategy = LingoRegistry.MEDIEVAL.getStrategy();
            // strategy = LingoRegistry.SHAKESPEARE.getStrategy();
            strategy = LingoRegistry.TODDLER.getStrategy();

            ConversionResult result = strategy.convert(request, client);

            if (result.hasError())
            {
                Clogger.error(result.getError());
            }
            else
            {
                Clogger.info("Original:  " + result.getOriginal());
                Clogger.info("Converted: " + result.getConverted());
            }
        }
        catch (Exception e)
        {
            Clogger.error("Failed to close client: " + e.getMessage());
        }
    }
}