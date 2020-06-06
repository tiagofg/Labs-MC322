package br.unicamp.ic.mc322.lab11.playlist.items;

import br.unicamp.ic.mc322.lab11.playlist.Item;

import java.util.ArrayList;
import java.util.List;

public class Album extends Item {

    private List<Song> songs;

    public Album() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getAuthor() {
        if (songs.isEmpty()) {
            return null;
        }

        String author = songs.get(0).getAuthor();

        for (Song song : songs) {
            if (!song.getAuthor().equals(author)) {
                return "Vários Autores";
            }
        }

        return author;
    }

    @Override
    public Integer getTime() {
        Integer time = 0;

        for (Song song : songs) {
            time += song.getTime();
        }

        return time;
    }

    @Override
    public Integer getStorageSize() {
        Integer storageSize = 0;

        for (Song song : songs) {
            storageSize += song.getStorageSize();
        }

        return storageSize;
    }
}
