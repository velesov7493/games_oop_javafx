package ru.job4j.puzzle;

public class Win {

    private static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean monoVertical(int[][] board, int column) {
        boolean result = true;
        for (int[] row : board) {
            if (row[column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static int[] extractDiagonal(int[][] board) {
        int[] result = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            result[i] = board[i][i];
        }
        return result;
    }

    public static boolean check(int[][] board) {
        boolean result = false;
        int[] diagonal = extractDiagonal(board);
        for (int i = 0; i < diagonal.length; i++) {
            if (diagonal[i] == 1 && (monoHorizontal(board, i) || monoVertical(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }
}
