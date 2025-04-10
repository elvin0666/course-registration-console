package util;

import entity.HumanWrapper;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {


    public static void writeObjectToFile(HumanWrapper humanWrapper) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("output.obj"))){
            objectOutputStream.writeObject(humanWrapper);
        } catch (Exception e) {
            System.out.println("Corrupt file");
        }
    }

    public static Object readObjectFromFile() {

        try (InputStream inputStream = new FileInputStream("Output.obj");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){

            return objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("File could not be found");
            return new HumanWrapper();
        }
    }

}
