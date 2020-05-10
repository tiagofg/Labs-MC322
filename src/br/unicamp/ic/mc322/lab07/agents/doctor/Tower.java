package br.unicamp.ic.mc322.lab07.agents.doctor;

import br.unicamp.ic.mc322.lab07.agents.Agent;

public class Tower extends Agent {

    private static final Integer HP_TOWER = 300;
    private static final Integer AP_TOWER = 25;

    public Tower(Integer position) {
        super(HP_TOWER, AP_TOWER, position, "TW");
    }
}
