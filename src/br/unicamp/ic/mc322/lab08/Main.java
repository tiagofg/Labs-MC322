package br.unicamp.ic.mc322.lab08;

import br.unicamp.ic.mc322.lab08.tweets.image.ImageExtensionEnum;
import br.unicamp.ic.mc322.lab08.tweets.image.ImageTweet;
import br.unicamp.ic.mc322.lab08.tweets.video.VideoExtensionEnum;
import br.unicamp.ic.mc322.lab08.tweets.video.VideoTweet;
import br.unicamp.ic.mc322.lab08.users.GenderEnum;
import br.unicamp.ic.mc322.lab08.users.User;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Twitter twitter = new Twitter();

        User joao = new User("João Costa", "joac@gmail.com",
                "jo@o12345", GenderEnum.MALE, "Brazil",
                LocalDate.of(1986, 5, 2), "joaoc");

        User maria = new User("Maria Silva", "msilva@outlook.com",
                "m@ria@", GenderEnum.FEMALE, "Argentina",
                LocalDate.of(1975, 4, 6), "msilva");

        User carlos = new User("Carlos Vargas", "carlos.vargas@gmail.com",
                "carlos123", GenderEnum.MALE, "Brazil",
                LocalDate.of(2001, 12, 21), "varguinhas");

        twitter.addUser(joao);
        twitter.addUser(maria);
        twitter.addUser(carlos);

        joao.follow(maria);
        joao.follow(carlos);

        carlos.follow(joao);

        maria.follow(joao);
        maria.follow(carlos);

        twitter.login("joaoc", "jo@o12345");
        VideoTweet videoTweet = twitter.publishVideoTweet("Primeiro dia na praia", 20, VideoExtensionEnum.AVI);
        twitter.logoff();


        twitter.login("varguinhas", "carlos123");
        twitter.like(videoTweet);
        twitter.comment(videoTweet, "Parabéns pelo passeio.");
        ImageTweet imageTweet = twitter.publishImageTweet("Cachorro dormindo", 1080, "cachorro dormindo na varanda", ImageExtensionEnum.GIF);
        twitter.logoff();

        twitter.login("joaoc", "jo@o12345");
        twitter.like(imageTweet);
        twitter.retweet(imageTweet);
        twitter.logoff();


        twitter.login("msilva", "m@ria@");
        twitter.like(imageTweet);
        twitter.comment(imageTweet, "Como cresceu seu cachorro");
        twitter.logoff();

        twitter.printUsersSummary();
    }

}
