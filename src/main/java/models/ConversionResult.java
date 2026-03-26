package models;

public class ConversionResult 
{
    private final String original;
    private final String converted;
    private final String lingo;
    private final String error;

    public ConversionResult(String original, String converted, String lingo) 
    {
        this.original  = original;
        this.converted = converted;
        this.lingo     = lingo;
        this.error     = null;
    }

    public ConversionResult(String error)
    {
        this.original  = null;
        this.converted = null;
        this.lingo     = null;
        this.error     = error;
    }

    public String getOriginal()  { return original; }
    public String getConverted() { return converted; }
    public String getLingo()     { return lingo; }
    public String getError()     { return error; } // will be null if no error occurred, otherwise will contain error msg
    public boolean hasError() { return error != null; }
}