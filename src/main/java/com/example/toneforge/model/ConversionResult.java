package com.example.toneforge.model;

public class ConversionResult 
{
    private String originalText;
    private String convertedText;
    private String lingoString;
    private String error;

    public ConversionResult() {} // default constructor for deserialization

    // success constructor
    public ConversionResult(String originalText, String convertedText, String lingoString) 
    {
        this.originalText  = originalText;
        this.convertedText = convertedText;
        this.lingoString     = lingoString;
        this.error     = null;
    }

    // error constructor
    public ConversionResult(String error)
    {
        this.originalText  = null;
        this.convertedText = null;
        this.lingoString     = null;
        this.error     = error;
    }

    // getters
    public String getOriginalText()  { return originalText; }
    public String getConvertedText() { return convertedText; }
    public String getLingoString()     { return lingoString; }
    public String getError()     { return error; } // will be null if no error occurred, otherwise will contain error msg

    // setters
    public void setOriginalText(String original) { this.originalText = original; }
    public void setConvertedText(String converted) { this.convertedText = converted; }
    public void setLingoString(String lingo) { this.lingoString = lingo; }
    public void setError(String error) { this.error = error; }

    // helpers
    public boolean hasError() { return error != null; }
}