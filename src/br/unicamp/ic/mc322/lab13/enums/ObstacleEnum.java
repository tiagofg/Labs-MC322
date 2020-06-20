package br.unicamp.ic.mc322.lab13.enums;

public enum ObstacleEnum {

    WATER("Water", "##", 0),
    TREE("Tree", "$$", 3);

    private String name;
    private String code;
    private Integer energyPoints;

    ObstacleEnum(String name, String code, Integer energyPoints) {
        this.name = name;
        this.code = code;
        this.energyPoints = energyPoints;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getEnergyPoints() {
        return energyPoints;
    }

    public void setEnergyPoints(Integer energyPoints) {
        this.energyPoints = energyPoints;
    }
}
