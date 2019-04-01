package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        assertEquals("YELLOW 4", card.toString());
    }
    
    @Test
    public void toStringReturnsCorrectValuesForWildCards() {
        card = new Card(Type.WILD, Color.YELLOW, Value.TWO);
        assertEquals("WILD", card.toString());
    }
    
    @Test
    public void toStringReturnsCorrectValuesForSpecialCards() {
        card = new Card(Type.REVERSE, Color.GREEN, Value.SPECIAL);
        assertEquals("GREEN REVERSE", card.toString());
    }
}
