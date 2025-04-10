package util;

import entity.HumanWrapper;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {

private static final Logger LOGGER =Logger.getLogger(File.class.getName());

    public static void writeObjectToFile(Object object,String fileName) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            System.out.println("Corrupt file");
            LOGGER.log(Level.SEVERE,"file not be written", e);

        }
    }

    public static Object readObjectFromFile(String fileName) {

        File file = new File(fileName);
        if(file.exists()){
            return null;
        }
        try (InputStream inputStream = new FileInputStream( fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){

            return objectInputStream.readObject();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"file not be read", e);
            return new HumanWrapper();
        }
    }

}
