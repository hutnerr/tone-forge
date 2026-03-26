package strategies;

import com.google.genai.Client;

import models.ConversionRequest;
import models.ConversionResult;

public interface LingoInterface
{
    /**
     * Converts the input text according to the specific transformation defined by the implementing class.
     * @param request The conversion request containing the input text to be transformed.
     * @param client The GenAI client used to interact with the language model for performing the conversion.
     * @return A ConversionResult object containing the original text, the converted text, and metadata about the conversion.
     */
    public ConversionResult convert(ConversionRequest request, Client client);

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