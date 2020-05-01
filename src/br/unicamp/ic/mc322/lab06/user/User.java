package br.unicamp.ic.mc322.lab06.user;

import br.unicamp.ic.mc322.lab06.playlist.Playlist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String cpf;
    private LocalDate birthDate;
    private GenderEnum gender;
    private boolean subscriber;
    private List<Playlist> playlists;

    private static final Integer MBS_ALLOWED_NON_SUBSCRIBER = 90;
    private static final Integer MBS_ALLOWED_SUBSCRIBER = 900;

    public User(String name, String cpf, LocalDate birthDate, GenderEnum gender, boolean subscriber) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subscriber = subscriber;
        this.playlists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public boolean isSubscriber() {
        return subscriber;
    }

    public Integer getStorageAllowed() {
        if (subscriber) {
            return MBS_ALLOWED_SUBSCRIBER;
        }

        return MBS_ALLOWED_NON_SUBSCRIBER;
    }

    private Integer getPlaylistsStorage() {
        Integer playlistsStorage = 0;

        for (Playlist playlist : playlists) {
            playlistsStorage += playlist.getStorageSize();
        }

        return playlistsStorage;
    }

    public void addPlaylist(Playlist playlist) {
        Integer storageAllowed = getStorageAllowed();

        if (playlist.getStorageSize() + getPlaylistsStorage() >= storageAllowed) {
            System.err.println("Não é possível inserir uma nova playlist, você já antigiu o seu limite de armazenamento.");
        }

        playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        if (!playlists.contains(playlist)) {
            System.err.println("Não é possível excluir essa playlist, ela não havia sido inserida.");
        }

        playlists.remove(playlist);
    }

    public void changeSubscription() {
        subscriber = !subscriber;
    }

    public void transferPlaylist(User user, Playlist playlist) {
        user.addPlaylist(playlist);
    }
}
