package br.unicamp.ic.mc322.lab04;

import br.unicamp.ic.mc322.lab04.enums.ColorEnum;
import br.unicamp.ic.mc322.lab04.enums.ObstacleEnum;

import java.util.ArrayList;
import java.util.List;

import static br.unicamp.ic.mc322.lab04.enums.ColorEnum.*;
import static br.unicamp.ic.mc322.lab04.enums.ObstacleEnum.*;

public class Map {

    private String[][] map;
    private Integer rows;
    private Integer columns;
    private List<Jewel> jewels;
    private List<Obstacle> obstacles;
    private Robot robot;

    //códigos do mapa
    private static final String BLANK_SPACE = "--";
    private static final String ROBOT_CODE = "ME";

    //teclas de movimentação
    private static final String UP = "w";
    private static final String LEFT = "a";
    private static final String DOWN = "s";
    private static final String RIGHT = "d";

    //mensagens de erro
    private static final String OBSTACLE_MESSAGE = "Tente se mover em outra direção, essa possui um obstáculo!!";
    private static final String AVAILABLE_JEWEL_MESSAGE = "Aperte g para coletar a joia antes de se mover!!";
    private static final String INVALID_POSITION_MESSAGE = "Posição inválida, impossível se mover nessa direção!!";

    public Map(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        this.jewels = new ArrayList<>();
        this.obstacles = new ArrayList<>();

        fillMap();
    }

    //iniciando mapa com todas as posições vazias
    private void fillMap() {
        map = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = BLANK_SPACE;
            }
        }
    }

    public void addJewel(Integer x, Integer y, ColorEnum color) {
        if (!validPosition(x, y)) {
            System.err.println("Impossível inserir joia nessa posição!!");
            return;
        }

        Jewel jewel = new Jewel(x, y, color);
        jewels.add(jewel);

        map[x][y] = color.getCode();
    }

    public void removeJewel(Jewel jewel) {
        jewels.remove(jewel);

        map[jewel.getX()][jewel.getY()] = BLANK_SPACE;
    }

    private Jewel findJewel(Integer x, Integer y) {
        for (Jewel jewel : jewels) {
            if (jewel.getX().equals(x) && jewel.getY().equals(y)) {
                return jewel;
            }
        }

        return null;
    }

    public Integer getTotalJewels() {
        return jewels.size();
    }

    public void addObstacle(Integer x, Integer y, ObstacleEnum type) {
        if (!validPosition(x, y)) {
            System.err.println("Impossível inserir obstáculo nessa posição!!");
            return;
        }

        Obstacle obstacle = new Obstacle(x, y, type);
        obstacles.add(obstacle);

        map[x][y] = type.getCode();
    }

    public void removeObstacle(Integer x, Integer y) {
        Obstacle obstacle = findObstacle(x, y);

        if (obstacle == null) {
            System.err.println("Impossível remover, esse obstáculo não foi inserido!!");
            return;
        }

        obstacles.remove(obstacle);
    }

    private Obstacle findObstacle(Integer x, Integer y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX().equals(x) && obstacle.getY().equals(y)) {

                return obstacle;
            }
        }

        return null;
    }

    public void createRobot(Integer x, Integer y) {
        robot = new Robot(x, y);

        map[x][y] = ROBOT_CODE;
    }

    //verificando se as coordenadas estão dentro do mapa
    private boolean validPosition(Integer x, Integer y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < columns);
    }

    //verificando se as coordenadas possuem um obstáculo
    private boolean hasObstacle(Integer x, Integer y) {
        return validPosition(x, y) && (map[x][y].equals(WATER.getCode()) || map[x][y].equals(TREE.getCode()));
    }

    //verificando se as coordenadas possuem uma joia
    private boolean hasJewel(Integer x, Integer y) {
        return validPosition(x, y) && (map[x][y].equals(RED.getCode()) || map[x][y].equals(GREEN.getCode()) || map[x][y].equals(BLUE.getCode()));
    }

    //verificando se existe algum impedimento para movimentação do robô
    private boolean invalidMovement(Integer x, Integer y) {
        if (hasObstacle(x, y)) {
            System.err.println(OBSTACLE_MESSAGE);
            return true;
        } else if (hasJewel(x, y)) {
            System.err.println(AVAILABLE_JEWEL_MESSAGE);
            return true;
        } else if (!validPosition(x, y)) {
            System.err.println(INVALID_POSITION_MESSAGE);
            return true;
        }
        
        return false;
    }

    public void moveRobot(String key) {
        Integer currentX = robot.getX();
        Integer currentY = robot.getY();

        switch (key) {
            case UP:
                if(invalidMovement(currentX - 1, currentY)) {
                    return;
                }

                map[currentX][currentY] = BLANK_SPACE;
                robot.moveNorth();

                break;
            case LEFT:
                if(invalidMovement(currentX, currentY - 1)) {
                    return;
                }

                map[currentX][currentY] = BLANK_SPACE;
                robot.moveWest();

                break;
            case DOWN:
                if(invalidMovement(currentX + 1, currentY)) {
                    return;
                }

                map[currentX][currentY] = BLANK_SPACE;
                robot.moveSouth();

                break;
            case RIGHT:
                if(invalidMovement(currentX, currentY + 1)) {
                    return;
                }

                map[currentX][currentY] = BLANK_SPACE;
                robot.moveEast();

                break;
        }

        map[robot.getX()][robot.getY()] = ROBOT_CODE;
    }

    private void catchJewel(Integer x, Integer y) {
        Jewel jewel = findJewel(x, y);

        robot.collectJewel(jewel);
        removeJewel(jewel);
    }

    public void collectJewelRobot() {
        Integer jewelsCollected = 0;
        Integer x = robot.getX();
        Integer y = robot.getY();

        //verificando se existe uma joia acima do robô
        if (hasJewel(x - 1, y)) {
            catchJewel(x - 1, y);
            jewelsCollected++;
        }

        //verificando se existe uma joia a esquerda do robô
        if (hasJewel(x, y - 1)) {
            catchJewel(x, y - 1);
            jewelsCollected++;
        }

        //verificando se existe uma joia embaixo do robô
        if (hasJewel(x + 1, y)) {
            catchJewel(x + 1, y);
            jewelsCollected++;
        }

        //verificando se existe uma joia a direita do robô
        if (hasJewel(x, y + 1)) {
            catchJewel(x, y + 1);
            jewelsCollected++;
        }

        //Mensagem de erro caso não seja possível coletar nenhuma joia
        if (jewelsCollected.equals(0)) {
            System.err.println("Não é possível coletar nenhuma joia!!");
        }

    }

    public void printMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" " + map[i][j] + " ");
            }

            System.out.print("\n");
        }

        robot.printJewels();
    }

}
