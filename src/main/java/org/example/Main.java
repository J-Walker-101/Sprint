package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter board size: ");
        int boardSize = scanner.nextInt();

        System.out.println("Choose game mode [1 for Simple, 2 for General]: ");
        int modeChoice = scanner.nextInt();

        System.out.println("Choose Red player type [1 for Human, 2 for Computer]: ");
        int redPlayerType = scanner.nextInt();

        System.out.println("Choose Blue player type [1 for Human, 2 for Computer]: ");
        int bluePlayerType = scanner.nextInt();

        SOSGame game = (modeChoice == 1) ? new SimpleGame(boardSize) : new GeneralGame(boardSize);

        if (redPlayerType == 2) {
            game.setRedPlayer(new ComputerPlayer("Red"));
        } else {
            game.setRedPlayer(new Player("Red", true)); // Human Player
        }

        if (bluePlayerType == 2) {
            game.setBluePlayer(new ComputerPlayer("Blue"));
        } else {
            game.setBluePlayer(new Player("Blue", true)); // Human Player
        }

        System.out.println("SOS Game Started!");

        while (true) {
            System.out.println(game.getCurrentPlayer().getName() + "'s turn.");

            int row = -1, col = -1;  // Declare row and col here, outside the conditional blocks
            char letter;

            if (game.getCurrentPlayer() instanceof ComputerPlayer) {
                game.makeComputerMove();
            } else {
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
                letter = scanner.next().charAt(0);

                game.placeLetter(row, col, letter);
            }

            game.getBoard().printBoard();

            if (modeChoice == 1 && game.hasSOS(row, col)) {
                System.out.println("SOS detected! " + game.getCurrentPlayer().getName() + " wins the game.");
                break;
            } else if (modeChoice == 2 && game.getBoard().isFull()) {
                System.out.println("The board is full! " + ((GeneralGame) game).getWinner());
                break;
            }

            game.switchTurn();
        }
    }
}