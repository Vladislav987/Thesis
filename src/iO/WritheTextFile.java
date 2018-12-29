package iO;


import content.Film;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritheTextFile {

    public static void writeFilmWithoutCommentsAndBinContent(String fileName, Film film) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(film.toOutputString(";"));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

