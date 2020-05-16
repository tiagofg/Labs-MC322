package br.unicamp.ic.mc322.lab08.tweets.image;

import br.unicamp.ic.mc322.lab08.tweets.Tweet;

import java.time.LocalDate;

public class ImageTweet extends Tweet {

    private static final Integer PIXEL_SIZE = 1;

    private Integer resolution;
    private Integer size;
    private String description;
    private ImageExtensionEnum extension;

    public ImageTweet(String title, LocalDate publicationDate, Integer resolution,
                      String description, ImageExtensionEnum extension) {
        super(title, publicationDate);
        this.resolution = resolution;
        this.size = resolution * PIXEL_SIZE;
        this.description = description;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return printHeader() +
                "Resolução: " + resolution + "p \n" +
                "Tamanho: " + size + " MB \n" +
                "Descrição: " + description + "\n" +
                "Extensão: " + extension.getExtension() + "\n" +
                printInfo();
    }
}
