package Cut;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cut {

    private String[] outputText;

    public static void main(String[] args) {
        Cut cut = new Cut();
        CommandLineParser commandLine = new CommandLineParser(args);
        String[] inputText = read(commandLine.getInput());
        cut.cut(commandLine, inputText);
        cut.write(commandLine.getOutput());
    }

    private void cut(CommandLineParser commandLine, String[] inputText) {
        outputText = new String[inputText.length];
        int begin = commandLine.getnRange(), end = commandLine.getkRange();
        if (commandLine.isWords())
            for (int i = 0; i < inputText.length; i++) {
                String[] inputString = inputText[i].split(" ");
                String[] outputString;
                if (begin > inputString.length) outputText[i] = "";
                else {
                    if (end < inputString.length && end > 0)
                        outputString = Arrays.copyOfRange(inputString, begin - 1, end);
                    else
                        outputString = Arrays.copyOfRange(inputString, begin - 1, inputString.length);

                    StringBuilder newString = new StringBuilder(outputString[0]);
                    for (int j = 1; j < outputString.length; j++) {
                        newString.append(' ').append(outputString[j]);
                    }
                    outputText[i] = newString.toString();
                }
            }
        else
            for (int i = 0; i < inputText.length; i++) {
                String inputString = inputText[i];
                String outputString;
                if (begin > inputString.length()) outputText[i] = "";
                else {
                    if (end < inputString.length() && end > 0)
                        outputString = inputString.substring(begin - 1, end);
                    else
                        outputString = inputString.substring(begin - 1);
                    outputText[i] = outputString;
                }
            }
    }

    private static String[] read(String fileName) {
        List<String> inputList = new ArrayList<>();
        try {
            String readString;
            if (fileName.equals("")) {
                Scanner reader = new Scanner(System.in);
                while (reader.hasNextLine()) {   //Прерывание ввода осущесвтляется нажатием Ctrl+D
                    inputList.add(reader.nextLine());
                }
            } else {
                File file = new File(fileName);
                BufferedReader reader =
                        new BufferedReader(new FileReader(file));
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

    private void write(String fileName) {
        StringBuilder output = new StringBuilder(outputText[0]);
        for (int i = 1; i < outputText.length; i++) {
            output.append("\n").append(outputText[i]);
        }
        if (!fileName.equals("")) {
            try {
                FileWriter out = new FileWriter(fileName);
                out.write(output.toString());
                out.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else System.out.println(output.toString());
    }
}