package br.unicamp.ic.mc322.lab07.agents.doctor;

import br.unicamp.ic.mc322.lab07.agents.Agent;

public class Doctor extends Agent {

    private static final Integer HP_DOCTOR = 999999999;
    private static final Integer AP_DOCTOR = 10;

    public Doctor() {
        super(HP_DOCTOR, AP_DOCTOR, 0, "D");
    }

    public void followDaleks(Integer highestDalekPosition) {
        setPosition(highestDalekPosition);
    }
}
