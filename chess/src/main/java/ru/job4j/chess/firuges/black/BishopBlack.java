package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(dest, position)) {
            throw new ImpossibleMoveException(String.format(
                "Слон может двигаться только по диагонали."
                +" Движение из %s в %s неприемлемо.", position, dest
            ));
        }
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();
        int size = Math.abs(deltaX);
        Cell[] steps = new Cell[size];
        deltaX = deltaX / Math.abs(deltaX);
        deltaY = deltaY / Math.abs(deltaY);
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(
                position.getX() + (index + 1) * deltaX,
                position.getY() + (index + 1) * deltaY
            );
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int dx = dest.getX() - source.getX();
        int dy = dest.getY() - source.getY();
        return Math.abs(dx) == Math.abs(dy);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
