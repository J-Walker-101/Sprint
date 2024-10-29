import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.SOSGame;
import org.example.SimpleGame;
import org.example.GeneralGame;
import org.example.GameMode;

public class SOSGameTest {
    private SOSGame simpleGame;
    private SOSGame generalGame;

    @BeforeEach
    public void setUp() {
        simpleGame = new SimpleGame(3);
        generalGame = new GeneralGame(3);
    }

    @Test
    public void testValidMoveInSimpleGame() {
        assertTrue(simpleGame.getBoard().isValidMove(0, 0));
        simpleGame.placeLetter(0, 0, 'S');
        assertFalse(simpleGame.getBoard().isValidMove(0, 0));
    }

    @Test
    public void testValidMoveInGeneralGame() {
        assertTrue(generalGame.getBoard().isValidMove(0, 0));
        generalGame.placeLetter(0, 0, 'S');
        assertFalse(generalGame.getBoard().isValidMove(0, 0));
    }

    @Test
    public void testFullBoardSimpleGame() {
        fillBoard(simpleGame);
        assertTrue(simpleGame.getBoard().isFull());
    }

    @Test
    public void testFullBoardGeneralGame() {
        fillBoard(generalGame);
        assertTrue(generalGame.getBoard().isFull());
    }

    private void fillBoard(SOSGame game) {
        game.placeLetter(0, 0, 'S');
        game.placeLetter(0, 1, 'O');
        game.placeLetter(0, 2, 'S');
        game.placeLetter(1, 0, 'O');
        game.placeLetter(1, 1, 'S');
        game.placeLetter(1, 2, 'O');
        game.placeLetter(2, 0, 'S');
        game.placeLetter(2, 1, 'O');
        game.placeLetter(2, 2, 'S');
    }

    @Test
    public void testSOSDetection() {
        SimpleGame game = new SimpleGame(3);
        game.getBoard().setCell(0, 0, 'S');
        game.getBoard().setCell(0, 1, 'O');
        game.getBoard().setCell(0, 2, 'S');
        assertTrue(game.hasSOS(0, 1), "Expected SOS at (0,1) but was not detected.");
    }

    @Test
    public void testScoreCountingInGeneralGame() {
        generalGame.placeLetter(0, 0, 'S');
        generalGame.placeLetter(0, 1, 'O');
        generalGame.placeLetter(0, 2, 'S'); // Red scores
        assertEquals(1, ((GeneralGame) generalGame).getRedPlayerScore());

        generalGame.placeLetter(1, 0, 'S');
        generalGame.placeLetter(1, 1, 'O');
        generalGame.placeLetter(1, 2, 'S'); // Blue scores
        assertEquals(1, ((GeneralGame) generalGame).getBluePlayerScore());
    }

    @Test
    public void testInvalidMoveOnOccupiedCell() {
        simpleGame.placeLetter(0, 0, 'S');
        assertFalse(simpleGame.getBoard().isValidMove(0, 0)); // Cell is now occupied
    }

    @Test
    public void testInvalidMoveOnNonEmptyCell() {
        // Arrange: Place an 'S' in the cell (0, 0)
        simpleGame.placeLetter(0, 0, 'S');

        // Act & Assert: Attempt to place another letter on the same cell
        assertFalse(simpleGame.getBoard().isValidMove(0, 0), "Expected cell (0, 0) to be invalid after placing a letter.");
    }

    @Test
    public void testTurnSwitchingAfterMove() {
        // Arrange: Confirm Red player starts the game
        assertEquals("Red", simpleGame.getCurrentPlayer().getName(), "Expected Red player to start the game.");

        // Act & Assert: Red places a letter, then check that it's Blue's turn
        simpleGame.placeLetter(0, 0, 'S');
        assertEquals("Blue", simpleGame.getCurrentPlayer().getName(), "Expected turn to switch to Blue after Red's move.");

        // Blue places a letter, then check that it's Red's turn
        simpleGame.placeLetter(0, 1, 'O');
        assertEquals("Red", simpleGame.getCurrentPlayer().getName(), "Expected turn to switch back to Red after Blue's move.");
    }

}