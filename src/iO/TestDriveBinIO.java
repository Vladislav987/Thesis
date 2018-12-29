package iO;



import content.*;

import java.io.Serializable;
import java.time.Duration;

public class TestDriveBinIO implements Serializable {
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

        // BinIo class Playlist

        ObjectBinIO.writeIntoBinFile("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\playList.tsv",playList);
        PlayList a = ObjectBinIO.readFromBinFile("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\playList.tsv");
        System.out.println(a);
        System.out.println("--------------------------------");

        //BinIO class Music

        ObjectBinIO.writeIntoBinFile("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\music.tsv",m);
        Music b = ObjectBinIO.readFromBinFile("D:\\IdeaProjects\\Lessons\\Proff\\Thesis\\src\\iO\\music.tsv");
        System.out.println(b);
    }
}

//PlayList{name='Чей - то', contents=[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S},
// contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[4, 0, 9, 3]},
// comments=[Comment {User: Denis  = 'Вот это да'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S},
// contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]},
// comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//]}
//--------------------------------
//Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S},
// contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]},
// comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
