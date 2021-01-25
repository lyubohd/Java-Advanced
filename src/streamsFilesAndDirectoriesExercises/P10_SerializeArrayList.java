package streamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.List;

public class P10_SerializeArrayList {
    private static final String PATH = "src/streamsFilesAndDirectoriesExercises/resources/list.ser";

    public static void main(String[] args) {
        List<Double> list = List.of(4.5, 3.7, 1.0, 8.8);
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)) {
            List<Double> deserializedList = (List<Double>) oos.readObject();
            deserializedList.forEach(e -> System.out.println(e));
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
