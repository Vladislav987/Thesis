package content;

import java.time.Duration;

public class TestDrive {
    public static void main(String[] args) {
        Video v = new Video(new ContentMetaData("Сколько ты хочешь", "Самик", Duration.ofMinutes(33).plusMillis(45)),
                new BinaryContent(new byte[]{4, 0, 9, 3}));
        Video v1 = new Video(new ContentMetaData("А у реки", "Рудольф", Duration.ofMinutes(15)),
                new BinaryContent(new byte[]{1, 1, 7, 5}));
        Video v2 = new Video(new ContentMetaData("На рыбалке", "Зина", Duration.ofMinutes(7).plusSeconds(49)),
                new BinaryContent(new byte[]{3, 2, 7, 5}));
        System.out.println(v.toString());
        v.addLike();
        v.addDislike();
        v.run();
        v.addComment(new Comment("Вот это да", new User("Denis", 23)));
        System.out.println(v.toString());
        System.out.println("**************************************************");
        Music m = new Music(new ContentMetaData("Фаина", "Руда", Duration.ofMinutes(3).plusMillis(22)), new BinaryContent(new byte[]{3, 3, 4, 5}));
        Music m1 = new Music(new ContentMetaData("Небо", "Ляпис", Duration.ofMinutes(3).plusMillis(10)), new BinaryContent(new byte[]{2, 1, 4, 5}));
        System.out.println(m.toString());
        m.addLike();
        m.addDislike();
        m.run();
        m.addComment(new Comment("Мне не понравилось.", new User("Егор", 30)));
        System.out.println(m.toString());
        System.out.println("***************************************************");
        PlayList playList = new PlayList("Чей - то");
        playList.addToPlayList(v);
        playList.addToPlayList(v1);
        playList.addToPlayList(v2);
        playList.addToPlayList(m);
        playList.addToPlayList(m1);
        System.out.println(playList.toString());
        playList.getContent(0).run();
        playList.getContent(0).addComment(new Comment("Ух ты!", new User("Борис", 40)));
        playList.getContent(2).addLike();
        System.out.println(playList.toString());
        System.out.println("********************************************************");
        Film f = new Film(new ContentMetaData("Война миров", "Режисёр", Duration.ofHours(2).plusMinutes(12)),
                new BinaryContent(new byte[]{4, 4, 4, 4}), FilmGenre.ACTION, 330);
        User u = new User("Ира", 27);
        u.replenishAccount(1500);
        System.out.println(u.toString());
        f.run(u);
        System.out.println(u);
        System.out.println("---------------------------------------------");
        u.getMyPlayLists().addToPlayList(v);
        u.getMyPlayLists().addToPlayList(v1);
        u.getMyPlayLists().addToPlayList(m);
        System.out.println(u.toString());
        System.out.println("----------------------------------------------");
        System.out.println(playList.toString());
        System.out.println("---------------------------");
        playList.sort(FreeContentComparators.byName());
        System.out.println("---------------------------");
        System.out.println("Сортировка по name");
        System.out.println(playList.toString());
        System.out.println("---------------------------");
        playList.sort(FreeContentComparators.byTotalViews());
        System.out.println("Сортировка по просмотрам");
        System.out.println(playList.toString());
        System.out.println("----------------------------");
        System.out.println("Фильтрация по имени");
        System.out.println(playList.filter(FreeContentPredicates.byName("Фаи")));
        System.out.println("-----------------------------");
        System.out.println("Фильтрация по автору");
        System.out.println(playList.filter(FreeContentPredicates.byAuthor("Руд")));
        System.out.println("------------------------------");
    }
}
//Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[]}
//
//Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//]}
//
//**************************************************
//Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[]}
//
//Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//
//***************************************************
//PlayList{name='Чей - то', contents=[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//]}
//, Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='На рыбалке', author='Зина', duration=PT7M49S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[3, 2, 7, 5]}, comments=[]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Небо', author='Ляпис', duration=PT3M0.01S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[2, 1, 4, 5]}, comments=[]}
//]}
//PlayList{name='Чей - то', contents=[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=2}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//, Comment {User: Борис  = 'Ух ты!'}
//]}
//, Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='На рыбалке', author='Зина', duration=PT7M49S}, contentStatistics=ContentStatistics{like=1, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[3, 2, 7, 5]}, comments=[]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Небо', author='Ляпис', duration=PT3M0.01S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[2, 1, 4, 5]}, comments=[]}
//]}
//********************************************************
//User{name='Ира', age=27, money=1500, myPlayLists=PlayList{name='Мой лэйлист', contents=[]}}
//User{name='Ира', age=27, money=1170, myPlayLists=PlayList{name='Мой лэйлист', contents=[]}}
//---------------------------------------------
//User{name='Ира', age=27, money=1170, myPlayLists=PlayList{name='Мой лэйлист', contents=[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=2}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//, Comment {User: Борис  = 'Ух ты!'}
//]}
//, Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//]}}
//----------------------------------------------
//PlayList{name='Чей - то', contents=[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=2}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//, Comment {User: Борис  = 'Ух ты!'}
//]}
//, Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='На рыбалке', author='Зина', duration=PT7M49S}, contentStatistics=ContentStatistics{like=1, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[3, 2, 7, 5]}, comments=[]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Небо', author='Ляпис', duration=PT3M0.01S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[2, 1, 4, 5]}, comments=[]}
//]}
//---------------------------
//---------------------------
//Сортировка по name
//PlayList{name='Чей - то', contents=[Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='На рыбалке', author='Зина', duration=PT7M49S}, contentStatistics=ContentStatistics{like=1, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[3, 2, 7, 5]}, comments=[]}
//, Music{contentMetaData=ContentMetaData{name='Небо', author='Ляпис', duration=PT3M0.01S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[2, 1, 4, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=2}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//, Comment {User: Борис  = 'Ух ты!'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//]}
//---------------------------
//Сортировка по просмотрам
//PlayList{name='Чей - то', contents=[Video{contentMetaData=ContentMetaData{name='Сколько ты хочешь', author='Самик', duration=PT33M0.045S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=2}, binaryContent=BinaryContent{content=[4, 0, 9, 3]}, comments=[Comment {User: Denis  = 'Вот это да'}
//, Comment {User: Борис  = 'Ух ты!'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//, Music{contentMetaData=ContentMetaData{name='Небо', author='Ляпис', duration=PT3M0.01S}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[2, 1, 4, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='На рыбалке', author='Зина', duration=PT7M49S}, contentStatistics=ContentStatistics{like=1, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[3, 2, 7, 5]}, comments=[]}
//, Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//]}
//----------------------------
//Фильтрация по имени
//[Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//]
//-----------------------------
//Фильтрация по автору
//[Music{contentMetaData=ContentMetaData{name='Фаина', author='Руда', duration=PT3M0.022S}, contentStatistics=ContentStatistics{like=1, dislike=1, totalViews=1}, binaryContent=BinaryContent{content=[3, 3, 4, 5]}, comments=[Comment {User: Егор  = 'Мне не понравилось.'}
//]}
//, Video{contentMetaData=ContentMetaData{name='А у реки', author='Рудольф', duration=PT15M}, contentStatistics=ContentStatistics{like=0, dislike=0, totalViews=0}, binaryContent=BinaryContent{content=[1, 1, 7, 5]}, comments=[]}
//]
//------------------------------