package javaAdvanced.streamsFilesAndDirectoriesExercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09_CopyAPicture {
    private static final String PICTURE_PATH = "src/javaAdvanced.streamsFilesAndDirectoriesExercises/resources/picture.jpg";
    private static final String PICTURE_COPY_PATH = "src/javaAdvanced.streamsFilesAndDirectoriesExercises/resources/picture-copy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(PICTURE_PATH);
             FileOutputStream fos = new FileOutputStream(PICTURE_COPY_PATH)) {
            int oneByte = fis.read();
            while (oneByte != -1) {
                fos.write(oneByte);
                oneByte = fis.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
