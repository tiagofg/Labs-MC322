package br.unicamp.ic.mc322.lab08.tweets.video;

import br.unicamp.ic.mc322.lab08.tweets.image.ImageExtensionEnum;

public enum VideoExtensionEnum {

    AVI(".avi"),
    WMV(".wmv"),
    FLV(".flv");

    private final String extension;

    VideoExtensionEnum(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
