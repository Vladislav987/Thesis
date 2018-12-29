package iO;

import content.BinaryContent;
import content.ContentMetaData;
import content.Film;
import content.FilmGenre;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class ReadTextFile {
    public static Film readFilmWithoutCommentsAndBinContent(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            return parseFilm(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Film parseFilm(String line) {
        String[] tokens = line.split(";");

        if (tokens.length < 5) {
            throw new RuntimeException("Missing values, should be (name;author;duration;genres;price): " + line);
        }

        String name = tokens[0].trim();
        String author = tokens[1].trim();
        Duration duration = Duration.parse(tokens[2].trim());
        String genre = tokens[3].trim();
        long price = Long.parseLong(tokens[4].trim());

        return new Film(new ContentMetaData(name, author, duration), new BinaryContent(null), FilmGenre.valueOf(genre), price);
    }

}
