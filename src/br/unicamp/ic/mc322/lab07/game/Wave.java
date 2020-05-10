package br.unicamp.ic.mc322.lab07.game;

import br.unicamp.ic.mc322.lab07.agents.daleks.Dalek;
import br.unicamp.ic.mc322.lab07.agents.doctor.Doctor;
import br.unicamp.ic.mc322.lab07.agents.doctor.Tower;
import br.unicamp.ic.mc322.lab07.game.path.Path;

import java.util.ArrayList;
import java.util.List;

public class Wave {

    private List<Dalek> daleks;
    private List<Tower> towers;
    private Doctor doctor;
    private Path path;
    private Integer currentStep;

    public Wave() {
        this.daleks = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.doctor = new Doctor();
        this.path = new Path();
        this.currentStep = 0;
    }

    public Integer getCurrentStep() {
        return currentStep;
    }

    public void nextStep() {
        currentStep++;
    }

    public void addDalek(Dalek dalek) {
        daleks.add(dalek);
    }

    public void removeDalek(Dalek dalek) {
        if (!daleks.contains(dalek)) {
            System.err.println("Dalek não inserido!!");
        }

        daleks.remove(dalek);
    }

    public void addTower(Tower tower) {
        towers.add(tower);
        path.addAgentToMap(tower);
    }

    public void removeTower(Tower tower) {
        if (!towers.contains(tower)) {
            System.err.println("Torre não inserida!!");
        }

        towers.remove(tower);
    }

    public boolean daleksReachedTardis() {
        // Verificando se algum Dalek chegou na Tardis
        for (Dalek dalek : daleks) {
            if (dalek.arrivedAtTardis()) {
                return true;
            }
        }

        return false;
    }

    public boolean allDaleksDefeated() {
        // Verificando se todos os Daleks foram derrotados
        return daleks.isEmpty();
    }

    private Dalek getHighestPositionDalek() {
        // Verificando Dalek que está mais próximo do fim
        if (daleks.isEmpty()) {
            return null;
        }

        Dalek highestPosition = daleks.get(0);

        for (Dalek dalek : daleks) {
            if (dalek.getPosition() > highestPosition.getPosition()) {
                highestPosition = dalek;
            }
        }

        return highestPosition;
    }

    private void moveDoctor() {
        path.moveDoctor(doctor, getHighestPositionDalek());
    }

    private void moveDaleks() {
        // Movendo os Daleks
        for (Dalek dalek : daleks) {
            if (dalek.getPosition() != 0 ||
                    (dalek.getPosition() == 0 &&
                            dalek.getStartTime().equals(currentStep))) {
                path.moveDalek(dalek);
            }
        }
    }

    public void moveAgents() {
        moveDaleks();
        moveDoctor();
    }

    public void executeAttacks() {
        // Executando os ataques
        for (Dalek dalek : daleks) {
            dalek.attack(path.getEnemyToAttack(dalek));
        }

        for (Tower tower: towers) {
            tower.attack(path.getDalekToAttack(tower));
        }

        doctor.attack(getHighestPositionDalek());
    }

    public void checkDestroyedAgents() {
        // Removendo os agentes que foram destruídos
        List<Dalek> daleksToRemove = new ArrayList<>();

        for (Dalek dalek : daleks) {
            if (dalek.destroyed()) {
                path.removeAgentFromMap(dalek);
                daleksToRemove.add(dalek);
            }
        }

        // Evitando remoção dentro do for-each
        for (Dalek dalekToRemove : daleksToRemove) {
            removeDalek(dalekToRemove);
        }

        List<Tower> towersToRemove = new ArrayList<>();

        for (Tower tower : towers) {
            if (tower.destroyed()) {
                path.removeAgentFromMap(tower);
                towersToRemove.add(tower);
            }
        }

        // Evitando remoção dentro do for-each
        for (Tower towerToRemove : towersToRemove) {
            removeTower(towerToRemove);
        }

        if (doctor.destroyed()) {
            path.removeAgentFromMap(doctor);
        }
    }

    public boolean hasWinner() {
        return daleksReachedTardis() || allDaleksDefeated();
    }

    public String getWinner() {
        // Definindo o vencedor da Wave
        if (daleksReachedTardis()) {
            return "Daleks";
        } else if (allDaleksDefeated()) {
            return "Doctor";
        }

        return "Not finished";
    }

    public void printStep() {
        path.print();
    }
}
