package br.unicamp.ic.mc322.lab12.map;

import br.unicamp.ic.mc322.lab12.engine.LabyrinthObjectVisitor;

import java.util.List;

public class Player extends LabyrinthObject {

    private Direction currentDirection;

    private static final String DIRECAO_INVALIDA = "Impossível se mover nessa direção!!";

    Player(Integer x, Integer y) {
        super(x, y);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    void move(Direction direction, List<Wall> walls) throws IndexOutOfBoundsException {
        Coordinate coordinate = this.getCoordinate();

        switch (direction) {
            case UP:
                for (Wall wall : walls) {
                    if (wall.isSameCoordinates(getX(), getY() - 1)) {
                        throw new IndexOutOfBoundsException(DIRECAO_INVALIDA);
                    }
                }

                getCoordinate().changeCoordinates(getX(), getY() - 1);

                break;

            case DOWN:
                for (Wall wall : walls) {
                    if (wall.isSameCoordinates(getX(), getY() + 1)) {
                        throw new IndexOutOfBoundsException(DIRECAO_INVALIDA);
                    }
                }

                coordinate.changeCoordinates(getX(), getY() + 1);

                break;

            case RIGHT:
                for (Wall wall : walls) {
                    if (wall.isSameCoordinates(getX() + 1, getY())) {
                        throw new IndexOutOfBoundsException(DIRECAO_INVALIDA);
                    }
                }

                coordinate.changeCoordinates(getX() + 1, getY());

                break;

            case LEFT:
                for (Wall wall : walls) {
                    if (wall.isSameCoordinates(getX() - 1, getY())) {
                        throw new IndexOutOfBoundsException(DIRECAO_INVALIDA);
                    }
                }

                coordinate.changeCoordinates(getX() - 1, getY());

                break;

            default:
                break;
        }
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }
}
