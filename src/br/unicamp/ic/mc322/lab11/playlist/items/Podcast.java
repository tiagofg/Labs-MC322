package br.unicamp.ic.mc322.lab11.playlist.items;

import br.unicamp.ic.mc322.lab11.playlist.Item;

public class Podcast extends Item {

    private Integer numberOfEpisodes;

    public Podcast(String name, Integer time, String author, Integer numberOfEpisodes) {
        super(name, time, author);
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public Integer getStorageSize() {
        return getTime() * 3 * numberOfEpisodes;
    }
}
