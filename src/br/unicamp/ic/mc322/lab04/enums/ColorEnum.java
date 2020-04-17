package br.unicamp.ic.mc322.lab04.enums;

public enum ColorEnum {

    RED("Red", 100, "JR"),
    GREEN("Green", 50, "JG"),
    BLUE("Blue", 10, "JB"),
    OTHER("Other", 0, "--");

    private String name;
    private Integer points;
    private String code;

    ColorEnum(String name, Integer points, String code) {
        this.name = name;
        this.points = points;
        this.code = code;
    }

    public static ColorEnum getColor(String code) {
        for (ColorEnum color : ColorEnum.values()) {
            if (color.code.equals(code)) {
                return color;
            }
        }

        return ColorEnum.OTHER;
    }

    public String getName() {
        return name;
    }

    public Integer getPoints() {
        return points;
    }

    public String getCode() {
        return code;
    }
}
