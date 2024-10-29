package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size: ");
        int boardSize = scanner.nextInt();

        System.out.println("Choose game mode [1 for Simple, 2 for General]: ");
        int modeChoice = scanner.nextInt();

        SOSGame game = (modeChoice == 1) ? new SimpleGame(boardSize) : new GeneralGame(boardSize);
        System.out.println("SOS Game Started!");

        while (true) {
            System.out.println(game.getCurrentPlayer().getName() + "'s turn.");
            int row, col;
            while (true) {
                System.out.println("Enter row and column to place a letter: ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                if (row >= 0 && col >= 0 && row < game.getBoard().getSize() && col < game.getBoard().getSize()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a value within the board size.");
                }
            }
            System.out.println("Enter 'S' or 'O': ");
            char letter = scanner.next().charAt(0);

            game.placeLetter(row, col, letter);
            game.getBoard().printBoard();

            if (modeChoice == 1 && ((SimpleGame) game).hasSOS(row, col)) {  // Simple Game mode
                System.out.println("SOS detected! Game over.");
                break;
            } else if (modeChoice == 2 && game.getBoard().isFull()) {  // General Game mode
                System.out.println("The board is full! " + ((GeneralGame) game).getWinner());
                break;
            }
        }
    }
}