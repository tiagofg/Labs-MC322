package br.unicamp.ic.mc322.lab08.tweets.website;

import br.unicamp.ic.mc322.lab08.tweets.Tweet;

import java.time.LocalDate;

public class WebsiteTweet extends Tweet {

    private String url;
    private LocalDate visitDate;

    public WebsiteTweet(String title, LocalDate publicationDate,
                        String url, LocalDate visitDate) {
        super(title, publicationDate);
        this.url = url;
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return printHeader() +
                "Url: " + url + "\n" +
                "Data da visita: " + visitDate + "\n" +
                printInfo();
    }
}
