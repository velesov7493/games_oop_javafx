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
        int dx = dest.getX() - position.getX();
        int dy = dest.getY() - position.getY();
        Cell[] steps = new Cell[Math.abs(dx)];
        dx = dx > 0 ? 1 : -1;
        dy = dy > 0 ? 1 : -1;
        int i = 0;
        Cell current = position;
        while (!current.equals(dest)) {
            current = Cell.findBy(current.getX() + dx, current.getY() + dy);
            steps[i++] = current;
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
