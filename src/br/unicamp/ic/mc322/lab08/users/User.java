package br.unicamp.ic.mc322.lab08.users;

import br.unicamp.ic.mc322.lab08.tweets.Tweet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String fullName;
    private String email;
    private String password;
    private GenderEnum gender;
    private String birthPlace;
    private LocalDate dateOfBirth;
    private String nickname;
    private List<Follower> following;
    private List<Follower> followers;
    private List<Tweet> tweets;

    public User(String fullName, String email, String password,
                GenderEnum gender, String birthPlace,
                LocalDate dateOfBirth, String nickname) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthPlace = birthPlace;
        this.dateOfBirth = dateOfBirth;
        this.nickname = nickname;
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.tweets = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private boolean addFollowing(User user) {
        Follower follower = new Follower(user, LocalDate.now());

        if (following.contains(follower)) {
            System.err.println("Usuário já seguido.");
            return false;
        }

        following.add(follower);
        return true;
    }

    private boolean removeFollowing(User user) {
        Follower followerToRemove = null;

        for (Follower follower : following) {
            if (follower.getUser().equals(user)) {
                followerToRemove = follower;
            }
        }

        if (followerToRemove == null) {
            System.err.println("Usuário não seguido");
            return false;
        }

        following.remove(followerToRemove);
        return true;
    }

    private void addFollower(User user) {
        Follower follower = new Follower(user, LocalDate.now());

        if (followers.contains(follower)) {
            System.err.println("Usuário já é seguidor.");
            return;
        }

        followers.add(follower);
    }

    private void removeFollower(User user) {
        Follower followerToRemove = null;

        for (Follower follower : followers) {
            if (follower.getUser().equals(user)) {
                followerToRemove = follower;
            }
        }

        if (followerToRemove == null) {
            System.err.println("Usuário não seguido");
        } else {
            followers.remove(followerToRemove);
        }
    }

    public void follow(User user) {
        if (addFollowing(user)) {
            user.addFollower(this);
        }
    }

    public void unfollow(User user) {
        if (removeFollowing(user)) {
            user.removeFollower(this);
        }
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet) {
        if (!tweets.contains(tweet)) {
            System.err.println("Você não publicou esse tweet, então não pode removê-lo.");
            return;
        }

        tweets.remove(tweet);
    }

    public boolean hasAlreadyTweeted(Tweet tweet) {
        return tweets.contains(tweet);
    }

    private String printFollowing() {
        return following.stream()
                .map(Follower::getNickname)
                .collect(Collectors.joining(", "));
    }

    private String printFollowers() {
        return followers.stream()
                .map(Follower::getNickname)
                .collect(Collectors.joining(", "));
    }

    public void printTweets() {
        for (Tweet tweet : tweets) {
            System.out.print("\n");
            System.out.println(tweet);
            tweet.printComments();
        }
    }

    @Override
    public String toString() {
        return "Nome completo: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "País: " + birthPlace + "\n" +
                "Data de nascimento: " + dateOfBirth + "\n" +
                "Seguindo: " + printFollowing() + "\n" +
                "Seguidores: " + printFollowers();

    }
}
