package br.unicamp.ic.mc322.lab07.game.path;

import br.unicamp.ic.mc322.lab07.agents.Agent;
import br.unicamp.ic.mc322.lab07.agents.daleks.Dalek;
import br.unicamp.ic.mc322.lab07.agents.doctor.Doctor;
import br.unicamp.ic.mc322.lab07.agents.doctor.Tower;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private Square[][] map;

    // Constante para visualizar o mapa
    private static final Integer ROWS = 9;
    private static final Integer COLUMNS = 8;
    private static final Integer END = 44;

    public Path() {
        map = new Square[ROWS][COLUMNS];
        fillMap();
    }

    private void fillMap() {
        Integer position = END;
        boolean right = true;
        boolean reverse = false;

        for (int i = 0; i < ROWS; i++) {
            // Se a linha for par, todas as casas devem ser preenchidas
            if (i % 2 == 0) {
                // As linhas podem ser preenchidas da esquerda para direita, ou da direita pra esquerda
                if (reverse) {
                    for (int j = COLUMNS - 1; j >= 0; j--) {
                        map[i][j] = new Square(position--);
                    }

                    reverse = false;
                } else {
                    for (int j = 0; j < COLUMNS; j++) {
                        map[i][j] = new Square(position--);
                    }

                    reverse = true;
                }
            } else {
                // Linhas ímpares só tem uma casa preenchida, na ponta esquerda ou na ponta direita
                if (right) {
                    for (int j = 0; j < COLUMNS - 1; j++) {
                        map[i][j] = new Square();
                    }

                    map[i][COLUMNS - 1] = new Square(position--);
                    right = false;
                } else {
                    map[i][0] = new Square(position--);

                    for (int j = 1; j < ROWS - 1; j++) {
                        map[i][j] = new Square();
                    }

                    right = true;
                }
            }
        }
    }

    private void addTower(Agent agent, Integer i, Integer j) {
        // Se houver duas casas ocupadas acima da posição escolhida, a torre é inserida 3 linhas acima
        if ((agent.getPosition() + 1) % 9 == 0) {
            if (i - 3 >= 0) {
                agent.setI(i - 3);
                agent.setJ(j);
                map[i - 3][j].addAgent(agent);
            }
        // Se houver uma casa ocupada acima da posição escolhida, a torre é inserida 2 linhas acima
        } else if (agent.getPosition() % 9 == 0) {
            if (i - 2 >= 0) {
                agent.setI(i - 2);
                agent.setJ(j);
                map[i - 2][j].addAgent(agent);
            }
        // Se não houver casas ocupadas acima da posição escolhida, a torre é inserida 1 linha acima
        } else if (i - 1 >= 0) {
            agent.setI(i - 1);
            agent.setJ(j);
            map[i - 1][j].addAgent(agent);
        }
    }

    public void addAgentToMap(Agent agent) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                // Verificando no mapa a posição que o agente vai ser inserido
                if (map[i][j].getNumber().equals(agent.getPosition())) {
                    if (agent instanceof Tower) {
                        addTower(agent, i , j);
                    } else {
                        agent.setI(i);
                        agent.setJ(j);
                        map[i][j].addAgent(agent);
                    }
                }
            }
        }
    }

    public void removeAgentFromMap(Agent agent) {
        map[agent.getI()][agent.getJ()].removeAgent(agent);
    }

    public void moveDalek(Dalek dalek) {
        // Movendo um Dalek no mapa
        removeAgentFromMap(dalek);
        dalek.move();
        addAgentToMap(dalek);
    }

    public void moveDoctor(Doctor doctor, Dalek highestPositionDalek) {
        Integer position = 0;

        if (highestPositionDalek != null) {
            position = highestPositionDalek.getPosition();
        }

        // Movendo o Doutor no mapa
        removeAgentFromMap(doctor);
        doctor.followDaleks(position);
        addAgentToMap(doctor);
    }


    private Dalek getHighestPositionDalekAround(Integer i, Integer j) {
        // Verificando qual Dalek está em uma posição mais avançada em relação a torre
        if (i - 1 >= 0) {
            if (j + 1 < COLUMNS && map[i - 1][j + 1].hasDaleks()) {
                return map[i - 1][j + 1].getDalek();
            } else if (map[i - 1][j].hasDaleks()) {
                return map[i - 1][j].getDalek();
            } else if (j - 1 >= 0 && map[i - 1][j - 1].hasDaleks()) {
                return map[i - 1][j - 1].getDalek();
            }
        }

        if (i + 1 < ROWS) {
            if (j + 1 < COLUMNS && map[i + 1][j + 1].hasDaleks()) {
                return map[i + 1][j + 1].getDalek();
            } else if (map[i + 1][j].hasDaleks()) {
                return map[i + 1][j].getDalek();
            } else if (j - 1 >= 0 && map[i + 1][j - 1].hasDaleks()) {
                return map[i + 1][j - 1].getDalek();
            }
        }

        return null;
    }

    public Dalek getDalekToAttack(Agent agent) {
        return getHighestPositionDalekAround(agent.getI(), agent.getJ());
    }

    private List<Agent> getEnemiesAround(Integer i, Integer j) {
        List<Agent> agents = new ArrayList<>();

        // Verificando as opções de ataque para um Dalek
        if (i - 1 >= 0) {
            if (j + 1 < COLUMNS) {
                if (map[i - 1][j + 1].hasTower()) {
                    agents.add(map[i - 1][j + 1].getTower());
                } else if (map[i - 1][j + 1].hasDoctor()) {
                    agents.add(map[i - 1][j + 1].getDoctor());
                }
            }

            if (j - 1 >= 0) {
                if (map[i - 1][j - 1].hasTower()) {
                    agents.add(map[i - 1][j - 1].getTower());
                } else if (map[i - 1][j - 1].hasDoctor()) {
                    agents.add(map[i - 1][j - 1].getDoctor());
                }
            }

            if (map[i - 1][j].hasTower()) {
                agents.add(map[i - 1][j].getTower());
            } else if (map[i - 1][j].hasDoctor()) {
                agents.add(map[i - 1][j].getDoctor());
            }
        }

        if (i + 1 < ROWS) {
            if (j + 1 < COLUMNS) {
                if (map[i + 1][j + 1].hasTower()) {
                    agents.add(map[i + 1][j + 1].getTower());
                } else if (map[i + 1][j + 1].hasDoctor()) {
                    agents.add(map[i + 1][j + 1].getDoctor());
                }
            }

            if (j - 1 >= 0) {
                if (map[i + 1][j - 1].hasTower()) {
                    agents.add(map[i + 1][j - 1].getTower());
                } else if (map[i + 1][j - 1].hasDoctor()) {
                    agents.add(map[i + 1][j - 1].getDoctor());
                }
            }

            if (map[i + 1][j].hasTower()) {
                agents.add(map[i + 1][j].getTower());
            } else if (map[i + 1][j].hasDoctor()) {
                agents.add(map[i + 1][j].getDoctor());
            }
        }

        if (j + 1 < COLUMNS) {
            if (map[i][j + 1].hasTower()) {
                agents.add(map[i][j + 1].getTower());
            } else if (map[i][j + 1].hasDoctor()) {
                agents.add(map[i][j + 1].getDoctor());
            }
        }

        if (j - 1 >= 0) {
            if (map[i][j - 1].hasTower()) {
                agents.add(map[i][j - 1].getTower());
            } else if (map[i][j - 1].hasDoctor()) {
                agents.add(map[i][j - 1].getDoctor());
            }
        }

        return agents;
    }

    private Agent getLowestLifeEnemyAround(Integer i, Integer j) {
        // Selecionando o agente que será atacado pelo Dalek
        List<Agent> enemiesAround = getEnemiesAround(i, j);

        if (enemiesAround.isEmpty()) {
            return null;
        }

        Agent lowestLifeEnemy = enemiesAround.get(0);

        for (Agent agent : enemiesAround) {
            if (agent.getHp() < lowestLifeEnemy.getHp()) {
                lowestLifeEnemy = agent;
            }
        }

        return lowestLifeEnemy;
    }

    public Agent getEnemyToAttack(Dalek dalek) {
        return getLowestLifeEnemyAround(dalek.getI(), dalek.getJ());
    }

    public void print() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(" " + map[i][j] + " ");
            }

            System.out.print("\n");
        }
    }
}
