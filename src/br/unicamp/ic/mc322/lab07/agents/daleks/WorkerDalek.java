package br.unicamp.ic.mc322.lab07.agents.daleks;

public class WorkerDalek extends Dalek {

    private static final Integer HP_WORKER = 100;
    private static final Integer AP_WORKER = 0;

    public WorkerDalek(Integer startTime) {
        super(HP_WORKER, AP_WORKER, 0, startTime, "WD");
    }

    @Override
    public void move() {
        setPosition(getPosition() + 1);
    }
}
