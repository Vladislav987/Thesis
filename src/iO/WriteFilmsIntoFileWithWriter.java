package iO;

import content.FreeContent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFilmsIntoFileWithWriter {
    public static void writePlayListIntoFile(String fileName, List<FreeContent> playList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write(String.valueOf(playList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // обычное чтение без инициализации

    public static List<String> readPlaylistOutText(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string;

            while ((string = reader.readLine()) != null) {
                list.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

