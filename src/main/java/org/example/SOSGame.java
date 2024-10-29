package org.example;

public abstract class SOSGame {
    protected Board board;
    protected Player redPlayer;
    protected Player bluePlayer;
    protected Player currentPlayer;
    protected GameMode gameMode;

    public SOSGame(int boardSize) {
        this.board = new Board(boardSize);
        this.redPlayer = new Player("Red", true);
        this.bluePlayer = new Player("Blue", true);
        this.currentPlayer = redPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == redPlayer) ? bluePlayer : redPlayer;
    }

    public abstract void placeLetter(int row, int col, char letter);

    public Board getBoard() {
        return board;
    }

    public boolean hasSOS(int row, int col) {
        char currentLetter = board.getCell(row, col);

        // Check horizontally
        if (col - 1 >= 0 && col + 1 < board.getSize() &&
                board.getCell(row, col - 1) == 'S' &&
                currentLetter == 'O' &&
                board.getCell(row, col + 1) == 'S') {
            System.out.println("SOS found horizontally at row " + row);
            return true;
        }
        if (col - 2 >= 0 &&
                board.getCell(row, col - 2) == 'S' &&
                board.getCell(row, col - 1) == 'O' &&
                currentLetter == 'S') {
            System.out.println("SOS found horizontally at row " + row);
            return true;
        }
        if (col + 2 < board.getSize() &&
                currentLetter == 'S' &&
                board.getCell(row, col + 1) == 'O' &&
                board.getCell(row, col + 2) == 'S') {
            System.out.println("SOS found horizontally at row " + row);
            return true;
        }

        // Check vertically
        if (row - 1 >= 0 && row + 1 < board.getSize() &&
                board.getCell(row - 1, col) == 'S' &&
                currentLetter == 'O' &&
                board.getCell(row + 1, col) == 'S') {
            System.out.println("SOS found vertically at column " + col);
            return true;
        }
        if (row - 2 >= 0 &&
                board.getCell(row - 2, col) == 'S' &&
                board.getCell(row - 1, col) == 'O' &&
                currentLetter == 'S') {
            System.out.println("SOS found vertically at column " + col);
            return true;
        }
        if (row + 2 < board.getSize() &&
                currentLetter == 'S' &&
                board.getCell(row + 1, col) == 'O' &&
                board.getCell(row + 2, col) == 'S') {
            System.out.println("SOS found vertically at column " + col);
            return true;
        }

        // Check diagonal
        if (row - 1 >= 0 && col - 1 >= 0 && row + 1 < board.getSize() && col + 1 < board.getSize() &&
                board.getCell(row - 1, col - 1) == 'S' &&
                currentLetter == 'O' &&
                board.getCell(row + 1, col + 1) == 'S') {
            System.out.println("SOS found diagonally (top-left to bottom-right)");
            return true;
        }
        if (row - 2 >= 0 && col - 2 >= 0 &&
                board.getCell(row - 2, col - 2) == 'S' &&
                board.getCell(row - 1, col - 1) == 'O' &&
                currentLetter == 'S') {
            System.out.println("SOS found diagonally (top-left to bottom-right)");
            return true;
        }
        if (row + 2 < board.getSize() && col + 2 < board.getSize() &&
                currentLetter == 'S' &&
                board.getCell(row + 1, col + 1) == 'O' &&
                board.getCell(row + 2, col + 2) == 'S') {
            System.out.println("SOS found diagonally (top-left to bottom-right)");
            return true;
        }

        if (row + 1 < board.getSize() && col - 1 >= 0 && row - 1 >= 0 && col + 1 < board.getSize() &&
                board.getCell(row + 1, col - 1) == 'S' &&
                currentLetter == 'O' &&
                board.getCell(row - 1, col + 1) == 'S') {
            System.out.println("SOS found diagonally (bottom-left to top-right)");
            return true;
        }
        if (row + 2 < board.getSize() && col - 2 >= 0 &&
                board.getCell(row + 2, col - 2) == 'S' &&
                board.getCell(row + 1, col - 1) == 'O' &&
                currentLetter == 'S') {
            System.out.println("SOS found diagonally (bottom-left to top-right)");
            return true;
        }
        if (row - 2 >= 0 && col + 2 < board.getSize() &&
                currentLetter == 'S' &&
                board.getCell(row - 1, col + 1) == 'O' &&
                board.getCell(row - 2, col + 2) == 'S') {
            System.out.println("SOS found diagonally (bottom-left to top-right)");
            return true;
        }

        System.out.println("No SOS detected for this move.");
        return false;
    }
}