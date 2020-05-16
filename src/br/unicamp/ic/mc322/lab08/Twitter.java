package br.unicamp.ic.mc322.lab08;

import br.unicamp.ic.mc322.lab08.tweets.Tweet;
import br.unicamp.ic.mc322.lab08.tweets.image.ImageExtensionEnum;
import br.unicamp.ic.mc322.lab08.tweets.image.ImageTweet;
import br.unicamp.ic.mc322.lab08.tweets.text.TextTweet;
import br.unicamp.ic.mc322.lab08.tweets.video.VideoExtensionEnum;
import br.unicamp.ic.mc322.lab08.tweets.video.VideoTweet;
import br.unicamp.ic.mc322.lab08.tweets.website.WebsiteTweet;
import br.unicamp.ic.mc322.lab08.users.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Twitter {

    private static final Integer MAX_TITLE_SIZE = 60;
    private static final Integer MAX_WORDS_TEXT = 1200;

    private List<User> users;
    private User currentUser;

    public Twitter() {
        this.users = new ArrayList<>();
        this.currentUser = null;
    }

    public void addUser(User user) {
        Integer age = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();

        if (age < 18) {
            System.err.println("Você precisa ter mais de 18 anos para acessar o Twitter.");
            return;
        }

        users.add(user);
    }

    public void login(String nickname, String password) {
        for (User user : users) {
            if (user.getNickname().equals(nickname) &&
                    user.getPassword().equals(password)) {
                currentUser = user;
                return;
            }
        }

        System.err.println("Usuário não cadastrado!!");
    }

    public void logoff() {
        this.currentUser = null;
    }

    private boolean disconnected() {
        return currentUser == null;
    }

    private boolean invalidTitle(String title) {
        return title.length() > MAX_TITLE_SIZE;
    }

    private boolean canNotPublish(String title) {
        if (disconnected()) {
            System.err.println("Você precisa estar logado para publicar um tweet.");
            return true;
        } else if (invalidTitle(title)) {
            System.err.println("Não é possível publicar o tweet, o título é muito longo.");
            return true;
        }

        return false;
    }

    public VideoTweet publishVideoTweet(String title, Integer time, VideoExtensionEnum extension) {
        if (canNotPublish(title)) {
            return null;
        }

        VideoTweet videoTweet = new VideoTweet(title, LocalDate.now(), time, extension);
        currentUser.addTweet(videoTweet);

        return videoTweet;
    }

    public ImageTweet publishImageTweet(String title, Integer resolution,
                                  String description, ImageExtensionEnum extension) {
        if (canNotPublish(title)) {
            return null;
        }

        ImageTweet imageTweet = new ImageTweet(title, LocalDate.now(), resolution, description, extension);
        currentUser.addTweet(imageTweet);

        return imageTweet;
    }

    public WebsiteTweet publishWebsiteTweet(String title, String url,
                                  LocalDate visitDate, boolean hasInappropriateContent) {
        if (canNotPublish(title)) {
            return null;
        } else if (hasInappropriateContent) {
            System.err.println("Você não pode publicar publicar um tweet com um website de conteúdo inadequado.");
            return null;
        }

        WebsiteTweet websiteTweet = new WebsiteTweet(title, LocalDate.now(), url, visitDate);
        currentUser.addTweet(websiteTweet);

        return websiteTweet;
    }

    private Integer getWordsNumber(String text) {
        StringTokenizer st = new StringTokenizer(text);
        return st.countTokens();
    }

    public TextTweet publishTextTweet(String title, String text, String language) {
        if (canNotPublish(title)) {
            return null;
        } else if (getWordsNumber(text) > MAX_WORDS_TEXT) {
            System.err.println("Esse tweet possui mais palavras que o permitido.");
            return null;
        }

        TextTweet textTweet = new TextTweet(title, LocalDate.now(), text, language);
        currentUser.addTweet(textTweet);

        return textTweet;
    }

    public void like(Tweet tweet) {
        tweet.addLike();
    }

    public void retweet(Tweet tweet) throws CloneNotSupportedException {
        if (currentUser.hasAlreadyTweeted(tweet)) {
            System.err.println("Você só pode retweetar uma vez cada tweet.");
            return;
        }

        tweet.addRetweet();

        Tweet retweet = (Tweet) tweet.clone();
        retweet.setRetweetDate(LocalDate.now());

        currentUser.addTweet(retweet);
    }

    public void comment(Tweet tweet, String text) {
        tweet.addComment(currentUser.getNickname(), text);
    }

    public void printUsersSummary() {
        for (User user : users) {
            System.out.print("\n");
            System.out.println("-----------------------------");
            System.out.println(user);
            System.out.print("\n");
            System.out.println("Tweets: ");
            user.printTweets();
            System.out.println("-----------------------------");
        }
    }

}
