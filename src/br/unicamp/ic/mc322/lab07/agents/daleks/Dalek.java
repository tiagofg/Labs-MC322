package br.unicamp.ic.mc322.lab07.agents.daleks;

import br.unicamp.ic.mc322.lab07.agents.Agent;

public abstract class Dalek extends Agent {

    private Integer startTime;

    private static final Integer TARDIS_POSITION = 44;

    public Dalek(Integer hp, Integer ap, Integer position, Integer startTime, String code) {
        super(hp, ap, position, code);
        this.startTime = startTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public abstract void move();

    public boolean arrivedAtTardis() {
        return getPosition() >= TARDIS_POSITION;
    }
}
