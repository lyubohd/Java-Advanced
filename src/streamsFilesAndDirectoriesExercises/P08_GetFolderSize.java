package streamsFilesAndDirectoriesExercises;

import java.io.*;

public class P08_GetFolderSize {
    private static final String DIR_PATH = "src/streamsFilesAndDirectoriesExercises/resources/Exercises Resources";
    private static final String OUTPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/result.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.println("Folder size: " + size);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
