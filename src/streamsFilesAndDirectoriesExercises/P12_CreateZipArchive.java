package streamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12_CreateZipArchive {
    private static final String FIRST_FILE_PATH = "src/streamsFilesAndDirectoriesExercises/resources/input.txt";
    private static final String SECOND_FILE_PATH = "src/streamsFilesAndDirectoriesExercises/resources/inputOne.txt";
    private static final String THIRD_FILE_PATH = "src/streamsFilesAndDirectoriesExercises/resources/inputTwo.txt";
    private static final String ZIP_FILE_PATH = "src/streamsFilesAndDirectoriesExercises/resources/files.zip";

    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_FILE_PATH))) {
            addToZipFile(FIRST_FILE_PATH, zos);
            addToZipFile(SECOND_FILE_PATH, zos);
            addToZipFile(THIRD_FILE_PATH, zos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToZipFile(String path, ZipOutputStream zos) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        String[] tokens = path.split("/");
        String fileName = tokens[tokens.length - 1];

        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
        zos.closeEntry();
        fis.close();
    }
}
