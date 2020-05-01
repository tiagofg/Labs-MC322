package br.unicamp.ic.mc322.lab06;

import br.unicamp.ic.mc322.lab06.playlist.Playlist;
import br.unicamp.ic.mc322.lab06.playlist.items.Album;
import br.unicamp.ic.mc322.lab06.playlist.items.Podcast;
import br.unicamp.ic.mc322.lab06.playlist.items.Song;
import br.unicamp.ic.mc322.lab06.playlist.items.Video;
import br.unicamp.ic.mc322.lab06.user.GenderEnum;
import br.unicamp.ic.mc322.lab06.user.User;

import java.time.LocalDate;

public class Musicfy {

    public static void main(String[] args) {
        User user = new User("Tiago Feliciano Gomes",
                "123456789",
                LocalDate.of(2000, 9, 9),
                GenderEnum.MALE,
                false);

        user.changeSubscription();

        Playlist playlist = new Playlist("Playlist bem legal",
                user.getStorageAllowed());

        Song song = new Song("Música famosa",
                10,
                "Eu mesmo");

        Video video = new Video("Video viral",
                20,
                "Eu também",
                7000,
                60);

        Podcast podcast = new Podcast("Podcast chato",
                3,
                "Eu",
                10);

        Album album = new Album();
        album.addSong(song);
        album.addSong(song);
        album.addSong(song);

        System.out.println("Autor: " + album.getAuthor());

        playlist.addItem(song);
        playlist.addItem(video);
        playlist.addItem(podcast);
        playlist.addItem(album);

        System.out.println("Tempo mais curto: " + playlist.getShortestTime().getTime());
        System.out.println("Tempo mais longo: " + playlist.getLongestTime().getTime());
        System.out.println("Tempo total: " + playlist.getTime());
        System.out.println("Tempo médio: " + playlist.getAverageTime());

//        playlist.addItem(podcast);
//        playlist.addItem(podcast);
//        playlist.addItem(podcast);
//        playlist.addItem(podcast);
//        playlist.addItem(podcast);
//        playlist.addItem(podcast);
//        playlist.addItem(podcast);

        System.out.println("Armazenamento total: " + playlist.getStorageSize());

        user.addPlaylist(playlist);
        user.removePlaylist(playlist);
    }

}
