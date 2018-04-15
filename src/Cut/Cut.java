package Cut;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cut {
    public static void main(String[] args) {
        cut(args);
    }

    private static void cut(String[] args) {
        CommandLineParser commandLine = new CommandLineParser(args);
        String[] inputText = read(commandLine.getInput());
        String[] outputText = new String[inputText.length];
        int begin = commandLine.getnRange(), end = commandLine.getkRange();
        if (commandLine.isWords())
            for (int i = 0; i < inputText.length; i++) {
                String[] inputString = inputText[i].split(" ");
                String[] outputString;
                if (begin > inputString.length) outputText[i] = "";
                else {
                    if (end < inputString.length && end > 0)
                        outputString = Arrays.copyOfRange(inputString, begin - 1, end - 1);
                    else
                        outputString = Arrays.copyOfRange(inputString, begin - 1, inputString.length - 1);

                    StringBuilder newString = new StringBuilder(outputString[0]);
                    for (int j = 1; j < outputString.length; j++) {
                        newString.append(' ').append(outputString[j]);
                    }
                    outputText[i] = newString.toString();
                }
            }
        else for (int i = 0; i < inputText.length; i++) {

        }
    }

    private static String[] read(String fileName) {
        List<String> inputList = new ArrayList<>();
        try {
            String readString;
            if (fileName.equals("")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while ((readString = reader.readLine()) != null) {
                    inputList.add(readString);
                }
                reader.close();
            } else {
                File file = new File(fileName);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((readString = reader.readLine()) != null) {
                    inputList.add(readString);
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] result = new String[inputList.size()];
        result = inputList.toArray(result);
        return result;
    }
}
