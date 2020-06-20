package br.unicamp.ic.mc322.lab13.enums;

public enum ColorEnum {

    RED("Red", 100, 0, "JR"),
    GREEN("Green", 50, 0, "JG"),
    BLUE("Blue", 10, 5, "JB");

    private String name;
    private Integer scorePoints;
    private Integer energyPoints;
    private String code;

    ColorEnum(String name, Integer scorePoints, Integer energyPoints, String code) {
        this.name = name;
        this.scorePoints = scorePoints;
        this.energyPoints = energyPoints;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getScorePoints() {
        return scorePoints;
    }

    public Integer getEnergyPoints() {
        return energyPoints;
    }

    public void setEnergyPoints(Integer energyPoints) {
        this.energyPoints = energyPoints;
    }

    public String getCode() {
        return code;
    }
}
