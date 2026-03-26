import java.io.IOException;

import com.google.genai.Client;

import models.ConversionRequest;
import models.ConversionResult;
import strategies.LingoRegistry;
import utils.Clogger;
import utils.EnvReader;

public class Main {
    public static void main(String[] args) 
    {
        String testInput;
        // testInput = "Hey, can you help me find a good restaurant nearby?";
        // testInput = "Hello, how are you?";
        testInput = "What is the weather like today?";

        try (Client client = Client.builder()
            .apiKey(EnvReader.getEnv("GEMINI_API_KEY"))
            .build())
        {
            LingoRegistry.listAll();

            ConversionRequest request = new ConversionRequest(testInput);
            ConversionResult result = LingoRegistry.PIRATE.getStrategy().convert(request, client);

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
        catch (IOException e)
        {
            Clogger.error("Failed to close client: " + e.getMessage());
        }
    }
}