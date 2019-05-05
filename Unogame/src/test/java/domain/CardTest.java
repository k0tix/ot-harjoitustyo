package domain;

import domain.Card.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k0tix
 */
public class CardTest {

    Card card;

    @Before
    public void setUp() {
        card = new Card(Type.NUMBER, Color.YELLOW, Value.TWO);
    }

    @Test
    public void constructorSetsCorrectValues() {
        assertEquals(Value.TWO, card.getNumber());
        assertEquals(Type.NUMBER, card.getType());
        assertEquals(Color.YELLOW, card.getColor());
    }

    @Test
    public void toStringReturnsCorrectValuesForNumberCards() {
        card = new Card(Type.NUMBER, Color.YELLOW, Value.FOUR);
        assertEquals("yellow_4.png", card.toString());
    }

    @Test
    public void toStringReturnsCorrectValuesForWildCards() {
        card = new Card(Type.CHANGE_COLOR, Color.YELLOW, Value.TWO);
        assertEquals("wild_color_changer.png", card.toString());
    }

    @Test
    public void toStringReturnsCorrectValuesForSpecialCards() {
        card = new Card(Type.REVERSE, Color.GREEN, Value.SPECIAL);
        assertEquals("green_reverse.png", card.toString());
    }

    @Test
    public void toStringReturnsCorrectValuesForSkipCards() {
        card = new Card(Type.SKIP, Color.GREEN, Value.SPECIAL);
        assertEquals("green_skip.png", card.toString());
    }

    @Test
    public void toStringReturnsCorrectValuesForDrawTwoCards() {
        card = new Card(Type.DRAW_TWO, Color.RED, Value.SPECIAL);
        assertEquals("red_picker.png", card.toString());
    }

    @Test
    public void toStringReturnsCorrectValuesForDrawFourCards() {
        card = new Card(Type.DRAW_FOUR, Color.WILD, Value.SPECIAL);
        assertEquals("wild_pick_four.png", card.toString());
    }
    
    @Test
    public void isPlayableCardReturnsCorrectValues() {        
        assertTrue(card.isPlayable(new Card(Type.REVERSE, Color.YELLOW, Value.SPECIAL)));
        assertTrue(card.isPlayable(new Card(Type.NUMBER, Color.RED, Value.TWO)));
        assertFalse(card.isPlayable(new Card(Type.NUMBER, Color.BLUE, Value.EIGHT)));
        
        card = new Card(Type.CHANGE_COLOR, Color.WILD, Value.SPECIAL);
        assertTrue(card.isPlayable(new Card(Type.NUMBER, Color.YELLOW, Value.TWO)));
        
        card = new Card(Type.DRAW_FOUR, Color.WILD, Value.SPECIAL);
        assertTrue(card.isPlayable(new Card(Type.DRAW_FOUR, Color.WILD, Value.SPECIAL)));
        
        card = new Card(Type.REVERSE, Color.BLUE, Value.SPECIAL);
        assertTrue(card.isPlayable(new Card(Type.REVERSE, Color.RED, Value.SPECIAL)));
    }
    
    @Test
    public void cardReturnsCorrectAmountOfPoints() {
        assertEquals(2, card.getPoints());
        
        card = new Card(Type.CHANGE_COLOR, Color.WILD, Value.SPECIAL);
        assertEquals(50, card.getPoints());
        
        card = new Card(Type.DRAW_FOUR, Color.WILD, Value.SPECIAL);
        assertEquals(50, card.getPoints());
        
        card = new Card(Type.REVERSE, Color.RED, Value.SPECIAL);
        assertEquals(20, card.getPoints());
    }
}
