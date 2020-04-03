package lab02;

import java.util.*;
import java.util.stream.Collectors;

public class Playlist {

    private String name;
    private String genre;
    private List<Song> songs;
    private Boolean subscriberUser;

    private Integer currentSongIndex = 0;

    private static final Integer SONGS_AMOUNT_NON_SUBSCRIBER = 10;
    private static final Integer SONGS_AMOUNT_SUBSCRIBER = 100;

    public Playlist(String name, String genre, List<Song> songs, Boolean subscriberUser) {
        this.name = name;
        this.genre = genre;
        this.songs = songs;
        this.subscriberUser = subscriberUser;
    }

    public Playlist(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.songs = new ArrayList<>();
        this.subscriberUser = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    private Integer getSongsAmount() {
        if (subscriberUser) {
            return SONGS_AMOUNT_SUBSCRIBER;
        }

        return SONGS_AMOUNT_NON_SUBSCRIBER;
    }

    public void addSong(Song song) throws Exception {
        Integer songsAmount = getSongsAmount();

        if (songs.size() >= songsAmount) {
            throw new Exception("Não é possível inserir uma nova música, pois essa playlist já antigiu o limite de músicas.");
        }

        songs.add(song);

        songs.sort(Comparator.comparing(Song::getName));
    }

    public void removeSong(Song song) throws Exception {
        if (!songs.contains(song)) {
            throw new Exception("Não é possível excluir essa música, pois ela não estava inserida.");
        }

        songs.remove(song);
    }

    public Song getShortestSong() {
        return Collections.min(songs, Comparator.comparing(Song::getDuration));
    }

    public Song getLongestSong() {
        return Collections.max(songs, Comparator.comparing(Song::getDuration));
    }

    public Double getAverageSongsDuration() {
        return songs.stream()
                .mapToInt(Song::getDuration).average()
                .orElse(0.0);
    }

    public Integer getAllSongsDuration() {
        return songs.stream()
                .mapToInt(Song::getDuration)
                .sum();
    }

    public String getMostCommonArtist() {
        return songs.stream()
                .collect(Collectors.groupingBy(Song::getArtist, Collectors.counting())).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public Song play() {
        if (currentSongIndex + 1 >= songs.size()) {
            currentSongIndex = 0;
        }

        return songs.get(currentSongIndex++);
    }

    public Song play(Boolean shuffle) {
        Integer randomIndex = new Random().nextInt(songs.size());

        while (randomIndex.equals(currentSongIndex)) {
            randomIndex = new Random().nextInt(songs.size());
        }

        return songs.get(randomIndex);
    }

    private String getAllSongs() {
        StringJoiner joiner = new StringJoiner(", ");

        for (Song song : songs) {
            joiner.add(song.getName());
        }
        return joiner.toString();
    }

    public String getDetails() {
        return "Essa playlist se chama " + name +
                ", é do gênero " + genre +
                " e possui as músicas: " + getAllSongs();
    }
}
