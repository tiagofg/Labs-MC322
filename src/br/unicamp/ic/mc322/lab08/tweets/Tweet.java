package br.unicamp.ic.mc322.lab08.tweets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tweet  implements Cloneable {

    private static final Integer MAX_COMMENT_SIZE = 100;

    private String title;
    private LocalDate publicationDate;
    private List<Comment> comments;
    private List<Like> likes;
    private Integer retweets;
    private LocalDate retweetDate;

    public Tweet(String title, LocalDate publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.retweets = 0;
    }

    public void setRetweetDate(LocalDate retweetDate) {
        this.retweetDate = retweetDate;
    }

    public void addLike() {
        Like like = new Like(LocalDate.now());

        likes.add(like);
    }

    public void addRetweet() {
        retweets++;
    }

    public void addComment(String user, String text) {
        if (text.length() > MAX_COMMENT_SIZE) {
            System.err.println("O comentário não pode possuir mais que 100 caracteres");
            return;
        }

        Comment comment = new Comment(user, text, LocalDate.now());

        comments.add(comment);
    }

    public void printComments() {
        if (!comments.isEmpty()) {
            System.out.println("Comentários: ");

            for (Comment comment : comments) {
                System.out.println(comment);
            }
        }
    }

    private String printRetweetDate() {
        if (retweetDate == null) {
            return "";
        }

        return ", Data do retweet: " + retweetDate;
    }

    public String printHeader() {
        return title + ", " + "Publicação: " + publicationDate + printRetweetDate() + "\n";
    }

    public String printInfo() {
        return likes.size() +" like(s), " + retweets + " retweet(s)";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
