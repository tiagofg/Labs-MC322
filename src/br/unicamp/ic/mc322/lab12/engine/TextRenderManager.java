package br.unicamp.ic.mc322.lab12.engine;

import br.unicamp.ic.mc322.lab12.map.*;

class TextRenderManager implements LabyrinthObjectVisitor {

    private char[][] charMap;

    public TextRenderManager(Integer mapWidth, Integer mapHeight) {
        this.charMap = new char[mapHeight][mapWidth];
    }

    public void render(LabyrinthMap map) {
        clearMap();
        map.accept(this);
        printMap();
    }

    private void clearMap() {
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[i].length; j++) {
                charMap[i][j] = ' ';
            }
        }
    }

    private void printMap() {
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[i].length; j++) {
                System.out.println(charMap[i][j] + " ");
            }

            System.out.println();
        }
    }

    private void setSymbol(LabyrinthObject obj, char character) {
        charMap[obj.getY()][obj.getX()] = character;
    }

    @Override
    public void visit(Player player) {
        setSymbol(player, 'J');
    }

    @Override
    public void visit(Wall wall) {
        setSymbol(wall, 'X');
    }

    @Override
    public void visit(CheckPoint checkPoint) {
        if (checkPoint.isConquered()) {
            setSymbol(checkPoint, 'T');
        } else {
            setSymbol(checkPoint, 'C');
        }
    }

}
