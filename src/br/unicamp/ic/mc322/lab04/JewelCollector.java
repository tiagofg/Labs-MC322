package br.unicamp.ic.mc322.lab04;

import java.util.Scanner;

import static br.unicamp.ic.mc322.lab04.enums.ColorEnum.*;
import static br.unicamp.ic.mc322.lab04.enums.ObstacleEnum.*;

public class JewelCollector {

    //possíveis comandos do usuário
    private static final String QUIT = "quit";
    private static final String W = "w";
    private static final String A = "a";
    private static final String S = "s";
    private static final String D = "d";
    private static final String G = "g";

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
        map.removeObstacle(1, 4);

        map.createRobot(0, 0);

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;

        while (running) {
            //fim de jogo
            if (map.getTotalJewels() == 0) {
                System.out.println("Parabéns, você coletou todas as joias!!");
                break;
            }

            map.printMap();
            System.out.print("Enter the command: ");

            String command = keyboard.nextLine();

            switch (command) {
                case QUIT:
                    running = false;
                    break;
                case G:
                    map.collectJewelRobot();
                    break;
                case W:
                case A:
                case S:
                case D:
                    map.moveRobot(command);
                    break;
                default:
                    //tecla diferente das permitidas
                    System.err.println("Comando inválido!!");
            }
        }
    }

}
