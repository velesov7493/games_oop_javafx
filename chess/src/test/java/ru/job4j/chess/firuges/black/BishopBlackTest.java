package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionFigure() {
        Cell expected = Cell.A6;
        Figure bishop = new BishopBlack(expected);
        Cell result = bishop.position();
        assertEquals(expected, result);
    }

    @Test
    public void whenCopyFigure() {
        Cell expected = Cell.B7;
        Figure bishop = new BishopBlack(Cell.A6);
        Figure bishop2 = bishop.copy(expected);
        Cell result = bishop2.position();
        assertEquals(expected, result);
    }

    @Test
    public void whenWayFigure() {
        Cell[] expected = new Cell[] { Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.G5);
        assertArrayEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayInvalid() {
        Figure bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.G4);
    }

}