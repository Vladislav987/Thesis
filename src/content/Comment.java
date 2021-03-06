package content;

import java.io.Serializable;

public class Comment implements Serializable {
    private String comment;
    private User userName;

    public Comment(String comment, User userName) {
        this.comment = comment;
        this.userName = userName;
    }


    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Comment {" + "User: " +
                userName.getName() +
                "  = '" + comment + '\'' + '}' + "\n";
    }
}
