package lab02;

import java.time.LocalDate;

public class Musicfy {

    public static void main(String[] args) throws Exception {
        User user1 = new User("Marcos Paulo", "777.777.777-77");
        User user2 = new User("Cookiezi", "111.111.11-11", LocalDate.now(), "Masculino");

        Song song1 = new Song("Seven Nation Army", "Rock", "The White Stripes", 100);
        Song song2 = new Song("Crazy Train", "Rock", "Ozzy Osbourne", 90);
        Song song3 = new Song("Feels", "Pop", "Calvin Harris", 80);
        Song song4 = new Song("Roar", "Pop", "Katy Perry", 70);
        Song song5 = new Song("Anima", "Hardcore", "Xi", 50);
        Song song6 = new Song("Freedom Dive", "Hardcore", "Xi", 10);
        Song song7 = new Song("Teo", "Hardcore", "Omoi");

        Playlist rockPlaylist = new Playlist("Awesome Rock Songs", "Rock");
        rockPlaylist.addSong(song1);
        rockPlaylist.addSong(song2);

        Playlist osuPlaylist = new Playlist("Osu Memories", "hardcore");
        osuPlaylist.addSong(song5);
        osuPlaylist.addSong(song6);
        osuPlaylist.addSong(song7);

        System.out.println("A menor música dessa playlist é: " + osuPlaylist.getShortestSong().getName());
        System.out.println("");
        System.out.println("A maior música dessa playlist é: " + osuPlaylist.getLongestSong().getName());
        System.out.println("");
        System.out.println("A duração média dessas músicas é: " + osuPlaylist.getAverageSongsDuration());
        System.out.println("");
        System.out.println("A duração total dessas músicas é: " + osuPlaylist.getAllSongsDuration());
        System.out.println("");
        System.out.println("O artista mais comum dessa playlist é: " + osuPlaylist.getMostCommonArtist());
        System.out.println("");

        Playlist popPlaylist = new Playlist("Awesome Pop Songs", "Pop");
        popPlaylist.addSong(song3);
        popPlaylist.addSong(song4);

        Playlist randomPlaylist = new Playlist("Awesome random Songs", "Mix");
        randomPlaylist.addSong(song1);
        randomPlaylist.addSong(song3);
        randomPlaylist.addSong(song7);
        randomPlaylist.removeSong(song7);

        user1.addPlaylist(rockPlaylist);
        user1.transferPlaylist(user2, rockPlaylist);
        user1.changeSubscription();

        user2.addPlaylist(osuPlaylist);
        user2.removePlaylist(rockPlaylist);
        user2.addPlaylist(rockPlaylist);
        user2.addPlaylist(popPlaylist);

        System.out.println(user1.getPlaylists().get(0).getDetails());
        System.out.println("");
        System.out.println(user2.getDetails());

        Song songToPlay;

        songToPlay = osuPlaylist.play();
        songToPlay = osuPlaylist.play();
        songToPlay = osuPlaylist.play(true);
    }
}