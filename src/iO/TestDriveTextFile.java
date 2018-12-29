package iO;


import content.*;

import java.time.Duration;

public class TestDriveTextFile {
    public static void main(String[] args) {
        Video v = new Video(new ContentMetaData("Сколько ты хочешь", "Самик", Duration.ofMinutes(33).plusMillis(45)),
                new BinaryContent(new byte[]{4, 0, 9, 3}));
        v.addLike();
        v.addDislike();
        v.run();
        v.addComment(new Comment("Вот это да", new User("Denis", 23)));
        Music m = new Music(new ContentMetaData("Фаина", "Руда", Duration.ofMinutes(3).plusMillis(22)), new BinaryContent(new byte[]{3, 3, 4, 5}));
        m.addLike();
        m.addDislike();
        m.run();
        m.addComment(new Comment("Мне не понравилось.", new User("Егор", 30)));
        PlayList playList = new PlayList("Чей - то");
        playList.addToPlayList(v);
        playList.addToPlayList(m);
        Film f = new Film(new ContentMetaData("Война миров", "Режисёр", Duration.ofHours(2).plusMinutes(12)),
                new BinaryContent(new byte[]{4, 4, 4, 4}), FilmGenre.COMEDY, 330);

        // Запись содержимого списка плэйлиста, а потом обычное чтение с файла.

        WriteFilmsIntoFileWithWriter.writePlayListIntoFile("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\playlist.txt", playList.getContents());
        System.out.println(WriteFilmsIntoFileWithWriter.readPlaylistOutText("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\playlist.txt"));
        System.out.println("---------------------------------------------------------------");

        // Запись Фильма в csv фаил, потом чтение и частичная инициализация объекта
        // с потерей бинарного контента и массива комментарий.

        WritheTextFile.writeFilmWithoutCommentsAndBinContent("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\film.csv", f);
        Film g = ReadTextFile.readFilmWithoutCommentsAndBinContent("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\film.csv");
        System.out.println(g.toString());

        //[[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S},
        // contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[4, 0, 9, 3]},
        // comments=[Comment {User: Denis  = 'Вот это да'}, ]}, , Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S},
        // contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]},
        // comments=[Comment {User: Егор  = 'Мне не понравилось.'}, ]}, ]]
        //---------------------------------------------------------------
        //Film{contentMetaData=ContentMetaData{name='Война миров', author='Режисёр', duration=PT2H12M},
        // contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=null},
        // filmGenre=COMEDY, comments=[], price=330}

    }
}
