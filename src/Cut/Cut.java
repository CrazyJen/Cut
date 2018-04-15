package Cut;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cut {
    public static void main(String[] args) {
        cut(args);
    }

    private static void cut(String[] args) {
        CommandLineParser commandLine = new CommandLineParser(args);
        String[] inputText = read(commandLine.getInput());
        String[] result = new String[inputText.length];


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
