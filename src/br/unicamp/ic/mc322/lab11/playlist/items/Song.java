package br.unicamp.ic.mc322.lab11.playlist.items;

import br.unicamp.ic.mc322.lab11.playlist.Item;

public class Song extends Item {

    public Song(String name, Integer time, String author) {
        super(name, time, author);
    }

    @Override
    public Integer getStorageSize() {
        return getTime() * 5;
    }
}
