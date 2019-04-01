package domain;

import domain.Card.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author k0tix
 */
public class Deck {
    private ArrayList<Card> deck;
    
    public Deck() {
        this.deck = new ArrayList<>();
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card pick() {
        return this.deck.remove(0);
    }
    
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }
    
    public void initializeCards() {
        this.deck.clear();
        
        //add number cards, 1x 0 for each color and 2x other numbers
        Arrays.stream(Color.values()).forEach(color -> {
            this.deck.add(new Card(Type.NUMBER, color, Value.ZERO));
            
            for(int num = 1; num < 10; num++) {
                this.deck.add(new Card(Type.NUMBER, color, Value.values()[num]));
                this.deck.add(new Card(Type.NUMBER, color, Value.values()[num]));
            }
        });
        
        //add action cards
        Arrays.stream(Color.values()).forEach(color -> {
            this.deck.add(new Card(Type.SKIP, color, Value.SPECIAL));
            this.deck.add(new Card(Type.SKIP, color, Value.SPECIAL));
            
            this.deck.add(new Card(Type.REVERSE, color, Value.SPECIAL));
            this.deck.add(new Card(Type.REVERSE, color, Value.SPECIAL));
            
            this.deck.add(new Card(Type.DRAW_TWO, color, Value.SPECIAL));
            this.deck.add(new Card(Type.DRAW_TWO, color, Value.SPECIAL));
        });
        
        //add wild cards
        for(int i = 0; i < 4; i++) {
            this.deck.add(new Card(Type.WILD, null, Value.SPECIAL));
            this.deck.add(new Card(Type.WILD, null, Value.SPECIAL));
            
            this.deck.add(new Card(Type.WILD_DRAW_FOUR, null, Value.SPECIAL));
            this.deck.add(new Card(Type.WILD_DRAW_FOUR, null, Value.SPECIAL));
        }
        
        shuffle();
    }
}
