package br.unicamp.ic.mc322.lab11.playlist;

public abstract class Item {

    private String name;
    private Integer time;
    private String author;

    public Item() {
    }

    public Item(String name, Integer time, String author) {
        this.name = name;
        this.time = time;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public abstract Integer getStorageSize();
}
