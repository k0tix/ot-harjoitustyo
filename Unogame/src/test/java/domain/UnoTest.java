package domain;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k0tix
 */
public class UnoTest {
    
    Uno uno;
    ArrayList<Player> players;
    
    @Before
    public void setUp() {
        players = new ArrayList<>();
        players.add(new Player(("Pekka")));
        players.add(new Player(("Matti")));
        players.add(new Player(("Kerttu")));
        
        uno = new Uno(new ScoreBoard(players), players);
    }

    @Test
    public void directionIsCorrectAfterInitialization() {
        assertEquals("clockwise", uno.getDirection());
    }
    
    @Test
    public void firstPlayerIsCorrectAfterInitialization() {
        assertEquals(players.get(0), uno.getCurrentPlayer());
    }
    
    @Test
    public void directionIsChangedCorrectly() {
        uno.changeDirection();
        assertEquals("anticlockwise", uno.getDirection());
        uno.changeDirection();
        assertEquals("clockwise", uno.getDirection());
    }
    
    @Test
    public void playersAreSettedCorrectly() {
        uno.setPlayers(new ArrayList<>());
        assertTrue(uno.getPlayers().isEmpty());
    }
    
    @Test
    public void nextPlayerIsCalculatedCorrectly() {
        assertEquals(players.get(0), uno.getCurrentPlayer());
        uno.nextPlayer();
        assertEquals(players.get(1), uno.getCurrentPlayer());
        uno.nextPlayer();
        uno.nextPlayer();
        assertEquals(players.get(0), uno.getCurrentPlayer());
    }
    
    @Test
    public void lastPlayerIsCalculatedCorrectly() {
        assertEquals(players.get(0), uno.getCurrentPlayer());
        uno.lastPlayer();
        assertEquals(players.get(2), uno.getCurrentPlayer());
        uno.lastPlayer();
        uno.lastPlayer();
        assertEquals(players.get(0), uno.getCurrentPlayer());
    }
    
    @Test
    public void correctAmountOfCardsAreDealt() {
        uno.startRound(0);
        assertEquals(7, uno.getPlayers().get(0).getCards().size());
    }
}
