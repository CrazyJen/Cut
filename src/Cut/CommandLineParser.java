package Cut;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Pattern;

public class CommandLineParser {
    private String input = "", output = "";
    private int nRange, kRange;
    private boolean chars = false, words = false;

    public CommandLineParser(String[] args) {
        StringBuilder check = new StringBuilder(args[0]);
        for (int i = 1; i < args.length; i++) {
            check.append(' ' + args[i]);
        }

        if ()
            throw new IllegalArgumentException("Incorrect command line");
    }
}
