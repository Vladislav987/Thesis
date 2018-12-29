package iO;

import java.io.*;

public class ObjectBinIO  {
    public static <T> void writeIntoBinFile(String filename,T object){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static <T> T readFromBinFile(String file){
        T object = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
            object = (T) inputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
