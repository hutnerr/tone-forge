package strategies;

import java.io.IOException;

import org.apache.http.HttpException;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.Part;

import models.ConversionRequest;
import models.ConversionResult;

public abstract class AbstractLingo implements LingoInterface 
{
    private static final String MODEL_NAME = "models/gemini-2.5-flash";

    @Override
    public ConversionResult convert(ConversionRequest request, Client client)
    {
        var config = GenerateContentConfig.builder()
            .systemInstruction(getInstructions())
            .build();

        try 
        {
            var response = client.models.generateContent(
                MODEL_NAME,
                request.getText(),
                config
            );
            return new ConversionResult(request.getText(), response.text(), getName());
        } 
        catch (HttpException e) 
        {
            return new ConversionResult("HTTP error occurred while converting text: " + e.getMessage());
        } 
        catch (IOException e) 
        {
            return new ConversionResult("IO error occurred while converting text: " + e.getMessage());
        }
        catch (Exception e) 
        {
            return new ConversionResult("Unexpected error occurred while converting text: " + e.getMessage());
        }
    }

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