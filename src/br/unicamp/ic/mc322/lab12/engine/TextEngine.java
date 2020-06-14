package br.unicamp.ic.mc322.lab12.engine;

import br.unicamp.ic.mc322.lab12.map.Direction;
import br.unicamp.ic.mc322.lab12.map.LabyrinthMap;

import java.util.Scanner;

public class TextEngine extends GameEngine {

    private TextRenderManager textRenderManager;

    private static final String W = "W";
    private static final String S = "S";
    private static final String D = "D";
    private static final String A = "A";

    public TextEngine(LabyrinthMap labyrinthMap) {
        super(labyrinthMap);
        this.textRenderManager = new TextRenderManager(labyrinthMap.getWidth(), labyrinthMap.getHeight());
    }

    public Direction readCommandFromKeyboard(Scanner scanner) {
        System.out.println("Digite a direção que você deseja ir (com W, A, S, D):");
        String letra = scanner.nextLine();

        switch (letra.toUpperCase()) {
            case W:
                return Direction.UP;
            case S:
                return Direction.DOWN;
            case D:
                return Direction.RIGHT;
            case A:
                return Direction.LEFT;
            default:
                return null;
        }
    }

    @Override
    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        LabyrinthMap map = getLabyrinthMap();
        Direction newDirection;

        while (!map.isDone()) {
            textRenderManager.render(map);
            newDirection = readCommandFromKeyboard(scanner);
            map.updateMap(newDirection);
        }

        System.out.println("Labirinto finalizado! Parabéns!!");
        scanner.close();
    }
}
