package Cut;

public class CommandLineParser {
    private String input = "", output = "";
    private int nRange = 1, kRange = -1;
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
                    break;
                case ("-w"):
                    words = true;
                    break;
                case ("-o"): {
                    output = args[i + 1];
                    String s = args[i + 2];
                    if (s.matches("\\w+\\.txt")) input = s;
                }
                break;
            }
        }
        if (output.equals("") &&
                args[args.length - 2].matches("\\w+\\.txt"))
            input = args[args.length - 2];

        String range = args[args.length - 1];
        if (range.matches("\\d+-"))
            nRange = Integer.parseInt(range.substring(0, range.length() - 1));
        else if (range.matches("-\\d+"))
            kRange = Integer.parseInt(range.substring(1));
        else {
            String[] parsedRange = range.split("-");
            nRange = Integer.parseInt(parsedRange[0]);
            kRange = Integer.parseInt(parsedRange[1]);
        }
        if (kRange != -1 && kRange < nRange)
            throw new IllegalArgumentException("Wrong range");
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