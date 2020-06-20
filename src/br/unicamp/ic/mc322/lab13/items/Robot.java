package br.unicamp.ic.mc322.lab13.items;

import br.unicamp.ic.mc322.lab04.Position;
import br.unicamp.ic.mc322.lab13.exceptions.RobotOutOfEnergyException;

import java.util.ArrayList;
import java.util.List;

public class Robot implements Item {

    private Position position;
    private List<Jewel> bag;
    private Integer energyPoints;

    private static final Integer START_ENERGY = 5;
    private static final String ROBOT_CODE = "ME";
    private static final String ROBOT_OUT_OF_ENERGY_MESSAGE = "Impossível se mover, robô sem energia";

    public Robot(Integer x, Integer y) {
        this.position = new Position(x, y);
        this.bag = new ArrayList<>();
        this.energyPoints = START_ENERGY;
    }

    public Integer getX() {
        return position.getX();
    }

    public Integer getY() {
        return position.getY();
    }

    private boolean outOfEnergy() {
        return energyPoints == 0;
    }

    public void moveNorth() {
        if (outOfEnergy()) {
            throw new RobotOutOfEnergyException(ROBOT_OUT_OF_ENERGY_MESSAGE);
        }

        energyPoints--;
        position.decX();
    }

    public void moveSouth() {
        if (outOfEnergy()) {
            throw new RobotOutOfEnergyException(ROBOT_OUT_OF_ENERGY_MESSAGE);
        }

        energyPoints--;
        position.incX();
    }

    public void moveEast() {
        if (outOfEnergy()) {
            throw new RobotOutOfEnergyException(ROBOT_OUT_OF_ENERGY_MESSAGE);
        }

        energyPoints--;
        position.incY();
    }

    public void moveWest() {
        if (outOfEnergy()) {
            throw new RobotOutOfEnergyException(ROBOT_OUT_OF_ENERGY_MESSAGE);
        }

        energyPoints--;
        position.decY();
    }

    public void collectJewel(Jewel jewel) {
        this.bag.add(jewel);
    }

    public void recharge(Integer energyPoints) {
        this.energyPoints += energyPoints;
    }

    private Integer getBagPoints() {
        Integer totalPoints = 0;

        for (Jewel jewel : bag) {
            totalPoints += jewel.getScorePoints();
        }

        return totalPoints;
    }

    public void printJewels() {
        System.out.println("Energy points: " + energyPoints +
                " | Bag total items: " + bag.size() +
                " | Bag total values: " + getBagPoints());
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean canCollect() {
        return false;
    }

    @Override
    public Integer getEnergyPoints() {
        return energyPoints;
    }

    @Override
    public void resetEnergyPoints() {
        this.energyPoints = 0;
    }

    @Override
    public boolean canUseToRecharge() {
        return false;
    }

    @Override
    public String toString() {
        return ROBOT_CODE;
    }
}
