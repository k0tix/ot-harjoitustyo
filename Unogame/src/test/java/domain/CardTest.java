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
}
