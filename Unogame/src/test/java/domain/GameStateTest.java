package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {
    
    GameState state;
    
    @Before
    public void setUp() {
        state = new GameState(8);
    }

    @Test
    public void GameStateHasCorrectDirection() {
        assertEquals("clockwise", state.getDirection());
    }
    
    @Test
    public void GameStateScoreHasRightAmountOfColumns() {
        assertEquals(8, state.getScores().length);
    }
}
