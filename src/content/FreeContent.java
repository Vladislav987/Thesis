package content;

public interface FreeContent {
    void run();

    void addLike();

    void addDislike();

    void addComment(Comment comment);

    ContentMetaData getContentMetaData();

    ContentStatistics getContentStatistics();



}
