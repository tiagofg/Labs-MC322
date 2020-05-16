package br.unicamp.ic.mc322.lab08.tweets.video;

import br.unicamp.ic.mc322.lab08.tweets.Tweet;

import java.time.LocalDate;

public class VideoTweet extends Tweet {

    private static final Integer MINUTE_SIZE = 3;

    private Integer time;
    private Integer size;
    private VideoExtensionEnum extension;

    public VideoTweet(String title, LocalDate publicationDate, Integer time,
                      VideoExtensionEnum extension) {
        super(title, publicationDate);
        this.time = time;
        this.size = time * MINUTE_SIZE;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return printHeader() +
                "Tempo: " + time + "\n" +
                "Tamanho: " + size + " MB \n" +
                "Extensão: " + extension.getExtension() + "\n" +
                printInfo();
    }
}
