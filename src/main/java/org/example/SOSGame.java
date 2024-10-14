package org.example;
import java.util.Random;

public class SOSGame {
    private Board board;
    private Player redPlayer;
    private Player bluePlayer;
    private Player currentPlayer;
    private GameMode gameMode;

    public SOSGame(int boardSize, GameMode mode) {
        this.board = new Board(boardSize);
        this.redPlayer = new Player("Red", true);
        this.bluePlayer = new Player("Blue", false);
        this.currentPlayer = redPlayer;
        this.gameMode = mode;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == redPlayer) ? bluePlayer : redPlayer;
    }

    public void placeLetter(int row, int col, char letter) {
        if (row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()) {
            System.out.println("Invalid position. Please enter a valid row and column.");
            return;
        }

        if (board.isValidMove(row, col)) {
            board.setCell(row, col, letter);
            switchTurn();
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    public void cpuMove() {
        if (board.isFull()) {
            System.out.println("The board is full, no more valid moves for the CPU.");
            return;
        }

        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(board.getSize());
            col = rand.nextInt(board.getSize());
        } while (!board.isValidMove(row, col));

        char letter = rand.nextBoolean() ? 'S' : 'O';
        board.setCell(row, col, letter);
        System.out.println("CPU placed " + letter + " at (" + (row + 1) + ", " + (col + 1) + ")");
        switchTurn();
    }

    public Board getBoard() {
        return board;
    }
}
