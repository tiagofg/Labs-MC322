package br.unicamp.ic.mc322.lab08.tweets;

import java.time.LocalDate;

public class Comment {

    private String user;
    private String text;
    private LocalDate publicationDate;

    public Comment(String user, String text, LocalDate publicationDate) {
        this.user = user;
        this.text = text;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return user + " " + text + ", " + publicationDate + "\n";
    }
}
