package br.unicamp.ic.mc322.lab13;

import br.unicamp.ic.mc322.lab13.exceptions.RobotOutOfEnergyException;
import br.unicamp.ic.mc322.lab13.map.Map;

import java.util.Scanner;

import static br.unicamp.ic.mc322.lab13.enums.ColorEnum.*;
import static br.unicamp.ic.mc322.lab13.enums.ColorEnum.BLUE;
import static br.unicamp.ic.mc322.lab13.enums.ObstacleEnum.TREE;
import static br.unicamp.ic.mc322.lab13.enums.ObstacleEnum.WATER;

public class JewelCollector {

    private static final String QUIT = "quit";
    private static final String U = "u";

    public static void main(String[] args) {
        Map map = new Map(10, 10);

        map.addJewel(1, 9, RED);
        map.addJewel(8, 8, RED);
        map.addJewel(9, 1, GREEN);
        map.addJewel(7, 6, GREEN);
        map.addJewel(3, 4, BLUE);
        map.addJewel(2, 1, BLUE);

        map.addObstacle(5, 0, WATER);
        map.addObstacle(5, 1, WATER);
        map.addObstacle(5, 2, WATER);
        map.addObstacle(5, 3, WATER);
        map.addObstacle(5, 4, WATER);
        map.addObstacle(5, 5, WATER);
        map.addObstacle(5, 6, WATER);
        map.addObstacle(5, 9, TREE);
        map.addObstacle(3, 9, TREE);
        map.addObstacle(8, 3, TREE);
        map.addObstacle(2, 5, TREE);
        map.addObstacle(1, 4, TREE);

        map.createRobot(0, 0);

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;

        while (running) {
            if (map.getTotalJewels() == 0) {
                System.out.println("Parabéns, você coletou todas as joias!!");
                break;
            }

            map.printMap();
            System.out.print("Enter the command: ");

            String command = keyboard.nextLine();

            if (command.equals(QUIT)) {
                running = false;
            } else if (command.equals(U)) {
                map.tryToRecharge();
                map.tryToCollectJewels();
            } else {
                try {
                    map.moveRobot(command);
                } catch (RobotOutOfEnergyException e) {
                    System.err.println(e.getMessage());
                    System.err.println("Você perdeu!!");
                    running = false;
                }

            }

        }
    }

}
