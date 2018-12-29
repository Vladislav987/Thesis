package content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable {
    private final ContentMetaData contentMetaData;
    private ContentStatistics contentStatistics = new ContentStatistics();
    private final BinaryContent binaryContent;
    private final FilmGenre filmGenre;
    private List<Comment> comments = new ArrayList<>();
    private final long price;

    public Film(ContentMetaData contentMetaData, BinaryContent binaryContent, FilmGenre filmGenre, long price) {
        this.contentMetaData = contentMetaData;
        this.binaryContent = binaryContent;
        this.filmGenre = filmGenre;
        this.price = price;
    }

    public ContentMetaData getContentMetaData() {
        return contentMetaData;
    }

    public ContentStatistics getContentStatistics() {
        return contentStatistics;
    }

    public BinaryContent getBinaryContent() {
        return binaryContent;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public long getPrice() {
        return price;
    }

    public void run(User user) throws Video.NoMoneyException {
        if (user.getMoney() < price) {
            throw new Video.NoMoneyException("Недостаточно денег");
        } else {
            user.pay(price);
            contentStatistics.view();
        }
    }

    public void addLike() {
        contentStatistics.addLike();
    }

    public void addDislike() {
        contentStatistics.addDislike();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public String toOutputString(String delimetr){
        return  contentMetaData.getName()+delimetr + contentMetaData.getAuthor()+delimetr + contentMetaData.getDuration() +delimetr+
                /*contentStatistics.getLike() + delimetr + contentStatistics.getDislike() + delimetr +
                contentStatistics.getTotalViews() + delimetr + binaryContent.getContent().toString() +
                delimetr +*/  filmGenre +delimetr+ /*comments.toArray() + delimetr +*/ price+delimetr;
    }

    @Override
    public String toString() {
        return "Film{" +
                "contentMetaData=" + contentMetaData +
                ", contentStatistics=" + contentStatistics +
                ", binaryContent=" + binaryContent +
                ", filmGenre=" + filmGenre +
                ", comments=" + comments +
                ", price=" + price +
                '}';
    }
}
