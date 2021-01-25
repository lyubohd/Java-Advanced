package streamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P07_MergeTwoFiles {
    private static final String FIRST_INPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/inputOne.txt";
    private static final String SECOND_INPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/inputTwo.txt";
    private static final String OUTPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/result.txt";

    public static void main(String[] args) {
        try (BufferedReader firstReader = new BufferedReader(new FileReader(FIRST_INPUT_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(SECOND_INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = firstReader.readLine();
            while (line != null) {
                writer.println(line);
                line = firstReader.readLine();
            }

            line = secondReader.readLine();
            while (line != null) {
                writer.println(line);
                line = secondReader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
