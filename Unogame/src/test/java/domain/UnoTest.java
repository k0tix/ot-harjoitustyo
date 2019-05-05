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
        players.add(new Player("Pekka"));
        players.add(new Player("Kerttu"));
        players.add(new Player("Mikko"));

        uno = new Uno(new ScoreBoard(players));
        uno.addPlayer(players.get(0));
        uno.addPlayer(players.get(1));
        uno.addPlayer(players.get(2));
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
    public void playersAreAddedCorrectly() {
        assertEquals(3, uno.getPlayers().size());
        uno.addPlayer(new Player("Juuso"));
        assertEquals(4, uno.getPlayers().size());
    }

    @Test
    public void nextPlayerIsCalculatedCorrectly() {
        assertEquals(players.get(0), uno.getCurrentPlayer());
        uno.nextPlayer();
        assertEquals(players.get(1), uno.getCurrentPlayer());
        uno.nextPlayer();
        uno.nextPlayer();
        assertEquals(players.get(0), uno.getCurrentPlayer());
        uno.changeDirection();
        uno.nextPlayer();
        assertEquals(players.get(2), uno.getCurrentPlayer());
    }

    @Test
    public void correctAmountOfCardsAreDealt() {
        uno.startRound(0);
        assertEquals(7, uno.getPlayers().get(0).getCards().size());
    }
}
