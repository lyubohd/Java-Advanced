package javaAdvanced.streamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P05_LineNumbers {
    private static final String INPUT_PATH = "src/javaAdvanced.streamsFilesAndDirectoriesExercises/resources/inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src/javaAdvanced.streamsFilesAndDirectoriesExercises/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            int number = 1;
            String line = reader.readLine();
            while (line != null) {
                String output = String.format("%d. %s", number, line);
                writer.println(output);
                number++;
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
