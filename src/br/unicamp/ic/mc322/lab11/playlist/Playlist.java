package br.unicamp.ic.mc322.lab11.playlist;

import br.unicamp.ic.mc322.lab11.playlist.items.Podcast;
import br.unicamp.ic.mc322.lab11.playlist.items.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist {

    private String name;
    private List<Item> items;
    private Integer maximumStorage;
    private Integer currentItem;

    public Playlist(String name, Integer maximumStorage) {
        this.name = name;
        this.maximumStorage = maximumStorage;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public Integer getMaximumStorage() {
        return maximumStorage;
    }

    public Integer getCurrentItem() {
        return currentItem;
    }

    private void setCurrentItem(int index) {
        currentItem = index;
    }

    private boolean hasOnlyPodcasts() {
        for (Item item : items) {
            if (!(item instanceof Podcast)) {
                return false;
            }
        }

        return true;
    }

    public Integer getStorageSize() {
        Integer storageSize = 0;

        if (!hasOnlyPodcasts()) {
            for (Item item : items) {
                storageSize += item.getStorageSize();
            }
        }

        return storageSize;
    }

    public void addItem(Item item) throws IllegalAccessException {
        if (!hasOnlyPodcasts() && (getStorageSize() + item.getStorageSize() > maximumStorage)) {
            throw new IllegalAccessException("Esse item não pode ser inserido, pois excederia o tamanho da playlist.");
        }

        items.add(item);
    }

    public void removeItem(Item item) {
        if (!items.contains(item)) {
            System.err.println("Impossível remover item, pois ele havia sido inserido.");
        }

        items.remove(item);
    }

    public Item getShortestTime() {
        Item shortest = items.get(0);

        for (Item item : items) {
            if (item.getTime() < shortest.getTime()) {
                shortest = item;
            }
        }

        return shortest;
    }

    public Item getLongestTime() {
        Item longest = items.get(0);

        for (Item item : items) {
            if (item.getTime() > longest.getTime()) {
                longest = item;
            }
        }

        return longest;
    }

    public Integer getTime() {
        Integer time = 0;

        for (Item item : items) {
            time += item.getTime();
        }

        return time;
    }

    private Integer getPlaylistSize() {
        return items.size();
    }

    public Integer getAverageTime() {
        return getTime() / getPlaylistSize();
    }

    public Item play() {
        return play(false);
    }

    public Item play(boolean shuffle) {
        int nextItem = 0;

        if (shuffle) {
            Random rand = new Random();
            
            do {
                nextItem = rand.nextInt(getPlaylistSize());
            } while (nextItem == currentItem);
        } else {
            nextItem = currentItem + 1;
        }

        setCurrentItem(nextItem);
        if (currentItem >= getPlaylistSize()) {
            setCurrentItem(0);
        }

        return items.get(currentItem);
    }

    public Song findSong(String songName) {
        for (Item item: items) {
            if (item.getName().equals(songName)) {
                return (Song) item;
            }
        }

        return null;
    }
}
