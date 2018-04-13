package Cut;


import java.util.regex.*;

public class CommandLineParser {
    private String input = "", output = "";
    private int nRange = -1, kRange = -1;
    private boolean chars = false, words = false;

    public CommandLineParser(String[] args) {
        StringBuilder check = new StringBuilder(args[0]);
        for (int i = 1; i < args.length; i++) {
            check.append(' ').append(args[i]);
        }
        if (!check.toString().matches("cut (-c|-w) (-o \\w+\\.txt )?(\\w+\\.txt )?(\\d+-\\d*|\\d*-\\d+)"))
            throw new IllegalArgumentException("Wrong command line");

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case ("-c"):
                    chars = true;
                case ("-w"):
                    words = true;
                case ("-o"): {
                    output = args[i + 1];
                    String s = args[i + 2];
                    if (s.matches("\\w+\\.txt")) input = s;
                }
                default:
            }
        }

        String[] range = args[args.length-1].split("-");
        if (!range[0].equals("")) nRange = Integer.parseInt(range[0]);
        if (!range[1].equals("")) kRange = Integer.parseInt(range[1]);
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public int getnRange() {
        return nRange;
    }

    public int getkRange() {
        return kRange;
    }

    public boolean isChars() {
        return chars;
    }

    public boolean isWords() {
        return words;
    }
}
