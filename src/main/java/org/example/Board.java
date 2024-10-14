package org.example;

public class Board {
    private char[][] grid;

    public Board(int size) {
        grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int col) {
        return grid[row][col] == ' ';
    }

    public void setCell(int row, int col, char letter) {
        grid[row][col] = letter;
    }

    public int getSize() {
        return grid.length;
    }

    public void printBoard() {
        int size = grid.length;

        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
                if (j < size - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();

            if (i < size - 1) {
                System.out.print("  ");
                for (int j = 0; j < size; j++) {
                    System.out.print("--");
                    if (j < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}
