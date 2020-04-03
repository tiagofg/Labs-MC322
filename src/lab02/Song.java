package lab02;

public class Song {

    private String name;
    private String genre;
    private String artist;
    private Integer duration;

    public Song(String name, String genre, String artist, Integer duration) {
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
    }

    public Song(String name, String genre, String artist) {
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.duration = 0;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDetails() {
        return "O nome dessa música é " + name +
                ", é do gênero " + genre +
                ", foi escrita por " + artist +
                " e tem a duração de " + duration +
                " segundos";
    }
}
