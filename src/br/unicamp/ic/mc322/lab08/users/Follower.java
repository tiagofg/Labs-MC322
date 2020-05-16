package br.unicamp.ic.mc322.lab08.users;

import java.time.LocalDate;

public class Follower {

    private User user;
    private LocalDate date;

    public Follower(User user, LocalDate date) {
        this.user = user;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public String getNickname() {
        return user.getNickname();
    }
}
