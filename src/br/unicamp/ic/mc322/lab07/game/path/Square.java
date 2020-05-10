package br.unicamp.ic.mc322.lab07.game.path;

import br.unicamp.ic.mc322.lab07.agents.Agent;
import br.unicamp.ic.mc322.lab07.agents.daleks.Dalek;
import br.unicamp.ic.mc322.lab07.agents.doctor.Doctor;
import br.unicamp.ic.mc322.lab07.agents.doctor.Tower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Square {

    private Integer number;
    private List<Agent> agents;

    public Square() {
        this.number = -1;
        this.agents = new ArrayList<>();
    }

    public Square(Integer number) {
        this.number = number;
        this.agents = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void removeAgent(Agent agent) {
        agents.remove(agent);
    }

    public boolean hasDaleks() {
        for (Agent agent : agents) {
            if (agent instanceof Dalek) {
                return true;
            }
        }

        return false;
    }

    public Dalek getDalek() {
        // Pegando o primeiro Dalek da lista de agentes
        for (Agent agent : agents) {
            if (agent instanceof Dalek) {
                return (Dalek) agent;
            }
        }

        return null;
    }

    public boolean hasDoctor() {
        for (Agent agent : agents) {
            if (agent instanceof Doctor) {
                return true;
            }
        }

        return false;
    }

    public Doctor getDoctor() {
        for (Agent agent : agents) {
            if (agent instanceof Doctor) {
                return (Doctor) agent;
            }
        }

        return null;
    }

    public boolean hasTower() {
        for (Agent agent : agents) {
            if (agent instanceof Tower) {
                return true;
            }
        }

        return false;
    }

    public Tower getTower() {
        for (Agent agent : agents) {
            if (agent instanceof Tower) {
                return (Tower) agent;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        // Verificando como cada casa deve ser imprimida
        if (agents == null || agents.isEmpty()) {
            if (number == -1) {
                return "--";
            } else if (number < 10) {
                return "0" + number;
            }

            return number.toString();

        } else {
            return agents
                    .stream()
                    .map(Agent::getCode)
                    .collect(Collectors.joining("/"));
        }
    }
}
