package br.unicamp.ic.mc322.lab08.tweets.image;

import br.unicamp.ic.mc322.lab04.enums.ColorEnum;

public enum ImageExtensionEnum {

    PNG(".png"),
    JPG(".jpg"),
    GIF(".gif");

    private final String extension;

    ImageExtensionEnum(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}
