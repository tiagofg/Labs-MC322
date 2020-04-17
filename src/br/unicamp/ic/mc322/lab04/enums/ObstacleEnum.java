package br.unicamp.ic.mc322.lab04.enums;

public enum ObstacleEnum {

    WATER("Water", "##"),
    TREE("Tree", "$$");

    private String name;
    private String code;

    ObstacleEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
