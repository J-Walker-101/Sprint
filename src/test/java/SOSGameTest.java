import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.SOSGame;
import org.example.GameMode;

public class SOSGameTest {
    private SOSGame game;

    @BeforeEach
    public void setUp() {
        game = new SOSGame(3, GameMode.SIMPLE);  // Set up a 3x3 board for each test
    }

    @Test
    public void testValidMove() {
        assertTrue(game.getBoard().isValidMove(0, 0));  // Check if (0, 0) is a valid move
        game.placeLetter(0, 0, 'S');
        assertFalse(game.getBoard().isValidMove(0, 0));  // Now it should be occupied
    }

    @Test
    public void testTurnSwitching() {
        game.placeLetter(0, 0, 'S');
        assertEquals("Blue", game.getCurrentPlayer().getName());  // After Red's turn, it should be Blue's turn
    }

    @Test
    public void testFullBoard() {
        // Fill the board
        game.placeLetter(0, 0, 'S');
        game.placeLetter(0, 1, 'O');
        game.placeLetter(0, 2, 'S');
        game.placeLetter(1, 0, 'S');
        game.placeLetter(1, 1, 'O');
        game.placeLetter(1, 2, 'S');
        game.placeLetter(2, 0, 'S');
        game.placeLetter(2, 1, 'O');
        game.placeLetter(2, 2, 'S');

        assertTrue(game.getBoard().isFull());  // The board should now be full
    }

}