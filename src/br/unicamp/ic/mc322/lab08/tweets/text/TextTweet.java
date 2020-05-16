package br.unicamp.ic.mc322.lab08.tweets.text;

import br.unicamp.ic.mc322.lab08.tweets.Tweet;

import java.time.LocalDate;

public class TextTweet extends Tweet {

    private String text;
    private String language;

    public TextTweet(String title, LocalDate publicationDate, String text, String language) {
        super(title, publicationDate);
        this.text = text;
        this.language = language;
    }

    @Override
    public String toString() {
        return printHeader() +
                "Texto: " + text + "\n" +
                "Idioma: " + language + "\n" +
                printInfo();
    }
}
