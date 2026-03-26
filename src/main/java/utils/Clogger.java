package utils;

public class Clogger
{
    public static boolean debugEnabled = true;
    public static boolean disabled = false;

    // ANSI color codes
    private static final String RESET  = "\u001B[0m";
    private static final String RED    = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN   = "\u001B[36m";
    private static final String GREEN  = "\u001B[32m";
    private static final String PURPLE = "\u001B[35m";
    private static final String WHITE  = "\u001B[37m";

    /**
     * Internal logging method. Used by all the other loggers.
     * EX. [DEBUG]    | The error msg here
     *
     * @param color ANSI color code for this log level
     * @param tag   What is in the brackets [DEBUG]
     * @param msg   The message to be shown
     * @param err   If true, prints to stderr instead of stdout
     */
    private static void _log(String color, String tag, String msg, boolean err)
    {
        if (!disabled)
        {
            String formattedMsg = color + String.format("%-9s| %s", tag + " ", msg) + RESET;
            if (err) System.err.println(formattedMsg);
            else     System.out.println(formattedMsg);
        }
    }

    /**
     * Allows the user to define a custom tag.
     *
     * @param tag The custom tag [CUSTOMTAG]
     * @param msg The message that goes along with this tag
     */
    public static void log(String tag, String msg)
    {
        String formattedTag = "[" + tag.toUpperCase() + "]";
        _log(WHITE, formattedTag, msg, false);
    }

    /**
     * Logging error messages. Prints in RED to stderr.
     * Useful for actual problems that cannot be ignored.
     *
     * @param msg The error message
     */
    public static void error(String msg)
    {
        _log(RED, "[ERROR]", msg, true);
    }

    /**
     * Logging debug messages. Only works if debugEnabled. Prints in CYAN.
     * Useful for temporary print debugging type output.
     *
     * @param msg The debug message
     */
    public static void debug(String msg)
    {
        if (debugEnabled) _log(CYAN, "[DEBUG]", msg, false);
    }

    /**
     * Log action message. Prints in PURPLE.
     * Useful for when the user performs some sort of input or action.
     *
     * @param msg The action message
     */
    public static void action(String msg)
    {
        _log(PURPLE, "[ACTION]", msg, false);
    }

    /**
     * Logs some information. Prints in GREEN.
     * Useful for information about the system or some general updates.
     *
     * @param msg The info message
     */
    public static void info(String msg)
    {
        _log(GREEN, "[INFO]", msg, false);
    }

    /**
     * Log warning message. Prints in YELLOW.
     * Useful for some sort of error that can likely be ignored.
     *
     * @param msg The warning message
     */
    public static void warn(String msg)
    {
        _log(YELLOW, "[WARN]", msg, false);
    }
}