package br.unicamp.ic.mc322.lab13.map;

import br.unicamp.ic.mc322.lab13.enums.ColorEnum;
import br.unicamp.ic.mc322.lab13.enums.ObstacleEnum;
import br.unicamp.ic.mc322.lab13.exceptions.InvalidPositionException;
import br.unicamp.ic.mc322.lab13.items.*;

import java.security.InvalidKeyException;

public class Map {

    private Item[][] map;
    private Integer rows;
    private Integer columns;
    private Robot robot;
    private Integer totalJewels;

    private static final String W = "w";
    private static final String A = "a";
    private static final String S = "s";
    private static final String D = "d";

    private static final String OCCUPIED_POSITION_MESSAGE = "Impossível se mover para essa posição, tente outra direção.";
    private static final String AVAILABLE_JEWEL_MESSAGE = "Aperte U para coletar a joia antes de se mover!!";
    private static final String INVALID_POSITION_MESSAGE = "Posição inválida, impossível se mover nessa direção!!";
    private static final String INVALID_KEY_MESSAGE = "Tecla inválida!! Para se movimentar você deve usar as teclas W, A, S ou D e para coletar ou recarregar use a tecla U";
    private static final String IMPOSSIBLE_TO_ADD_JEWEL = "Impossível inserir joia nessa posição!!";
    private static final String IMPOSSIBLE_TO_ADD_OBSTACLE = "Impossível inserir obstáculo nessa posição!!";

    public Map(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        this.totalJewels = 0;

        fillMap();
    }

    public Integer getTotalJewels() {
        return totalJewels;
    }

    private void fillMap() {
        map = new Item[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = new BlankSpace();
            }
        }
    }

    public void addJewel(Integer x, Integer y, ColorEnum color) {
        if (!validPosition(x, y)) {
            throw new InvalidPositionException(IMPOSSIBLE_TO_ADD_JEWEL);
        }

        map[x][y] = new Jewel(color);
        totalJewels++;
    }

    public void removeJewel(Integer x, Integer y) {
        map[x][y] = new BlankSpace();
        totalJewels--;
    }

    public void addObstacle(Integer x, Integer y, ObstacleEnum type) {
        if (!validPosition(x, y)) {
            throw new InvalidPositionException(IMPOSSIBLE_TO_ADD_OBSTACLE);
        }

        map[x][y] = new Obstacle(type);
    }

    public void createRobot(Integer x, Integer y) {
        robot = new Robot(x, y);

        map[x][y] = robot;
    }

    private void verifyMovement(Integer x, Integer y) {
        if (!validPosition(x, y)) {
            throw new InvalidPositionException(INVALID_POSITION_MESSAGE);
        } else if (map[x][y].isOccupied() && map[x][y].canCollect()) {
            throw new InvalidPositionException(AVAILABLE_JEWEL_MESSAGE);
        } else if (map[x][y].isOccupied()) {
            throw new InvalidPositionException(OCCUPIED_POSITION_MESSAGE);
        }
    }

    public void moveRobot(String key) {
        try {
            Integer currentX = robot.getX();
            Integer currentY = robot.getY();

            switch (key.toLowerCase()) {
                case W:
                    verifyMovement(currentX - 1, currentY);
                    map[currentX][currentY] = new BlankSpace();
                    robot.moveNorth();

                    break;
                case A:
                    verifyMovement(currentX, currentY - 1);
                    map[currentX][currentY] = new BlankSpace();
                    robot.moveWest();

                    break;
                case S:
                    verifyMovement(currentX + 1, currentY);
                    map[currentX][currentY] = new BlankSpace();
                    robot.moveSouth();

                    break;
                case D:
                    verifyMovement(currentX, currentY + 1);
                    map[currentX][currentY] = new BlankSpace();
                    robot.moveEast();

                    break;
                default:
                    throw new InvalidKeyException(INVALID_KEY_MESSAGE);
            }

            map[robot.getX()][robot.getY()] = robot;

        } catch (InvalidPositionException | InvalidKeyException e) {
            System.err.println(e.getMessage());
        }
    }

    private void rechargeIfPossible(Integer x, Integer y) {
        if (validPosition(x, y) && map[x][y].canUseToRecharge()) {
            Rechargeable rechargeable = (Rechargeable) map[x][y];

            robot.recharge(rechargeable.getEnergyPoints());
            rechargeable.resetEnergyPoints();
        }
    }

    public void tryToRecharge() {
        Integer x = robot.getX();
        Integer y = robot.getY();

        rechargeIfPossible(x - 1, y);
        rechargeIfPossible(x, y - 1);
        rechargeIfPossible(x + 1, y);
        rechargeIfPossible(x, y + 1);
    }

    private void collectIfPossible(Integer x, Integer y) {
        if (validPosition(x, y) && map[x][y].canCollect()) {
            Jewel jewel = (Jewel) map[x][y];

            robot.collectJewel(jewel);
            removeJewel(x, y);
        }
    }

    public void tryToCollectJewels() {
        Integer x = robot.getX();
        Integer y = robot.getY();

        collectIfPossible(x - 1, y);
        collectIfPossible(x, y - 1);
        collectIfPossible(x + 1, y);
        collectIfPossible(x, y + 1);

    }

    private boolean validPosition(Integer x, Integer y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < columns);
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
