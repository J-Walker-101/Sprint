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
        System.out.println("Set cell at (" + row + ", " + col + ") to '" + letter + "'");
    }

    public char getCell(int row, int col) {
        return grid[row][col];
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

  /*public boolean hasSOS(int row, int col) {
        char letter = grid[row][col];

        // Horizontal check
        if (col > 0 && col < grid.length - 1 && grid[row][col - 1] == 'S' && letter == 'O' && grid[row][col + 1] == 'S') {
            System.out.println("Horizontal SOS detected at (" + row + "," + col + ")");
            return true;
        }
        // Vertical check
        if (row > 0 && row < grid.length - 1 && grid[row - 1][col] == 'S' && letter == 'O' && grid[row + 1][col] == 'S') {
            System.out.println("Vertical SOS detected at (" + row + "," + col + ")");
            return true;
        }
        // Diagonal check (top-left to bottom-right)
        if (row > 0 && row < grid.length - 1 && col > 0 && col < grid.length - 1 &&
                grid[row - 1][col - 1] == 'S' && letter == 'O' && grid[row + 1][col + 1] == 'S') {
            System.out.println("Diagonal SOS detected at (" + row + "," + col + ")");
            return true;
        }

        if (row > 0 && row < grid.length - 1 && col > 0 && col < grid.length - 1 &&
                grid[row - 1][col + 1] == 'S' && letter == 'O' && grid[row + 1][col - 1] == 'S') {
            System.out.println("Anti-diagonal SOS detected at (" + row + "," + col + ")");
            return true;
        }
        return false;
    }

     */