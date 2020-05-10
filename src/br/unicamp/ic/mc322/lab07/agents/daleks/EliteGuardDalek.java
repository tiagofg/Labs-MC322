package br.unicamp.ic.mc322.lab07.agents.daleks;

public class EliteGuardDalek extends Dalek {

    private static final Integer HP_ELITE = 200;
    private static final Integer AP_ELITE = 20;

    public EliteGuardDalek(Integer startTime) {
        super(HP_ELITE, AP_ELITE, 0, startTime, "ED");
    }

    @Override
    public void move() {
        if (getHp() > 100) {
            setPosition(getPosition() + 1);
        } else {
            setPosition(getPosition() + 3);
        }
    }
}
