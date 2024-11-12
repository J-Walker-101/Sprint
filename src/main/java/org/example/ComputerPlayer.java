package org.example;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name, false);
    }

    public int[] makeMove(Board board) {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(board.getSize());
            col = rand.nextInt(board.getSize());
        } while (!board.isValidMove(row, col));
        return new int[]{row, col};
    }

    public char chooseLetter() {
        return Math.random() < 0.5 ? 'S' : 'O'; // Randomly choose 'S' or 'O'
    }
}
