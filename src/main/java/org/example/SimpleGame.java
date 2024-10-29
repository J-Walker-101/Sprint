package org.example;

public class SimpleGame extends SOSGame {

    public SimpleGame(int boardSize) {
        super(boardSize);
        this.gameMode = GameMode.SIMPLE;
    }

    @Override
    public void placeLetter(int row, int col, char letter) {
        if (board.isValidMove(row, col)) {
            board.setCell(row, col, letter);
            if (hasSOS(row, col)) {
                System.out.println("SOS found! " + currentPlayer.getName() + " wins the game.");
                board.printBoard();
                System.exit(0);
            } else if (board.isFull()) {
                System.out.println("The board is full. This game ended in a draw.");
                board.printBoard();
                System.exit(0);
            } else {
                System.out.println("No SOS detected for this move.");
                switchTurn();
            }
        } else {
            System.out.println("Invalid move. This cell is already occupied.");
        }
    }
}