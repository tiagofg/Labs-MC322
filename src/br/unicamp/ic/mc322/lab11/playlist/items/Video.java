package br.unicamp.ic.mc322.lab11.playlist.items;

import br.unicamp.ic.mc322.lab11.playlist.Item;

public class Video extends Item {

    private Integer pixels;
    private Integer fps;

    private static final Integer TEN_TO_SIXTH = 1000000;

    public Video(String name, Integer time, String author, Integer pixels, Integer fps) {
        super(name, time, author);
        this.pixels = pixels;
        this.fps = fps;
    }

    @Override
    public Integer getStorageSize() {
        Integer audioSize = getTime() * 5;

        Integer videoSize = (pixels / TEN_TO_SIXTH) * fps * getTime();

        return audioSize + videoSize;
    }
}
