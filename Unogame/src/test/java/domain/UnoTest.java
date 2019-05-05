package domain;

import domain.Card.*;
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

        uno = new Uno();
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
        uno.nextPlayer();
        assertEquals(players.get(1), uno.getCurrentPlayer());        
    }

    @Test
    public void correctAmountOfCardsAreDealt() {
        uno.startRound(0);
        assertEquals(7, uno.getPlayers().get(0).getCards().size());
    }
    
    @Test
    public void gameEndReturnsCorrectValue() {
        assertEquals(false, uno.getGameEnd());
    }
    
    @Test
    public void correctPlayerAmountReturned() {
        assertEquals(3, uno.getPlayerAmount());
    }
    
    @Test
    public void correctScoreForDeck() {
        Player p = players.get(0);
        p.giveCard(new Card(Type.DRAW_FOUR, Color.WILD, Value.SPECIAL));
        p.giveCard(new Card(Type.DRAW_TWO, Color.YELLOW, Value.SPECIAL));
        p.giveCard(new Card(Type.NUMBER, Color.BLUE, Value.THREE));
        
        assertEquals(73, uno.calculateScore());
    }
}
