package domain;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author k0tix
 */
public class Player {
    
    private String name;
    private String id;
    private ArrayList<Card> cards;
    
    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.cards = new ArrayList<>();
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void giveCard(Card card) {
        this.cards.add(card);
    }
    
    public Card playCard(int index) {
        return this.cards.remove(index);
    }
    
}
