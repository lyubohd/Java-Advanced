package streamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class P04_CountCharacterTypes {
    private static final String INPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/input.txt";
    private static final String OUTPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            Set<Character> punctuationMarks = Set.of('!', ',', '.', '?');
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationMarksCount = 0;

            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuationMarks.contains(symbol)) {
                        punctuationMarksCount++;
                    } else if (symbol != ' ') {
                        consonantsCount++;
                    }
                }
                line = reader.readLine();
            }

            writer.println("Vowels: " + vowelsCount);
            writer.println("Consonants: " + consonantsCount);
            writer.println("Punctuation: " + punctuationMarksCount);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
