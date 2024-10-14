package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size: ");
        int boardSize = scanner.nextInt();

        System.out.println("Choose game mode (1 for Simple, 2 for General): ");
        int modeChoice = scanner.nextInt();
        GameMode mode = (modeChoice == 1) ? GameMode.SIMPLE : GameMode.GENERAL;

        SOSGame game = new SOSGame(boardSize, mode);
        System.out.println("SOS Game Started!");

        // Main game loop
        while (true) {
            if (game.getCurrentPlayer().isHuman()) {
                int row, col;
                while (true) {
                    System.out.println("Enter row and column to place a letter: ");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;

                    // Validate row and column inputs
                    if (row >= 0 && col >= 0 && row < game.getBoard().getSize() && col < game.getBoard().getSize()) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter values within the board size.");
                    }
                }

                System.out.println("Enter 'S' or 'O': ");
                char letter = scanner.next().charAt(0);

                game.placeLetter(row, col, letter);
            } else {
                System.out.println("CPU is making its move...");
                game.cpuMove();
            }

            game.getBoard().printBoard();


            if (game.getBoard().isFull()) {
                System.out.println("The board is full! Game over.");
                break;
            }
        }
    }
}