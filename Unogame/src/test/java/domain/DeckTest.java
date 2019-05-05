package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k0tix
 */
public class DeckTest {
    
    Deck deck;
    
    @Before
    public void setUp() {
        deck = new Deck();
    }
    
    @Test
    public void deckIsEmptyAfterConstruction() {
        assertTrue(deck.isEmpty());
    }
    
    @Test
    public void deckIsNotEmptyAfterInitialization() {
        deck.initializeCards();
        assertFalse(deck.isEmpty());
    }
}
