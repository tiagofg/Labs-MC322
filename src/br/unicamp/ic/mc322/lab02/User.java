package br.unicamp.ic.mc322.lab02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String gender;
    private Boolean subscriber;
    private List<Playlist> playlists;

    private static final Integer PLAYLISTS_AMOUNT_NON_SUBSCRIBER = 3;
    private static final Integer PLAYLISTS_AMOUNT_SUBSCRIBER = 10;

    public User(String name, String cpf, LocalDate birthDate, String gender, Boolean subscriber, List<Playlist> playlists) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subscriber = subscriber;
        this.playlists = playlists;
    }

    public User(String name, String cpf, LocalDate birthDate, String gender) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subscriber = false;
        this.playlists = new ArrayList<>();
    }

    public User(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
        this.subscriber = false;
        this.playlists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Boolean subscriber) {
        this.subscriber = subscriber;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    private Integer getPlaylistsAmount() {
        if (subscriber) {
            return PLAYLISTS_AMOUNT_SUBSCRIBER;
        }

        return PLAYLISTS_AMOUNT_NON_SUBSCRIBER;
    }

    public void addPlaylist(Playlist playlist) throws Exception {
        Integer playlistsAmount = getPlaylistsAmount();

        if (playlists.size() >= playlistsAmount) {
            throw new Exception("Não é possível inserir uma nova playlist, pois você já antigiu o seu limite de playlists.");
        }

        playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) throws Exception {
        if (!playlists.contains(playlist)) {
            throw new Exception("Não é possível excluir essa playlist, pois ela não estava inserida.");
        }

        playlists.remove(playlist);
    }

    public void changeSubscription() {
        subscriber = !subscriber;
    }

    public void transferPlaylist(User user, Playlist playlist) throws Exception {
        user.addPlaylist(playlist);
    }

    public String getDetails() {
        return "O usuário se chama " + name +
                ", possui o cpf " + cpf +
                ", nasceu em " + birthDate +
                " e é do gênero " + gender;
    }
}
