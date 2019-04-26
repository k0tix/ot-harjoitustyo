package domain;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Luokka tarjoaa pelaajan toiminnallisuutta eli pitää kirjaa nimesta, luo
 * yksilöllisen id:n ja pitää listaa pelaajan kädessä olevista korteista
 * 
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
    
    /**
     * Lisää pelaajan käteen uuden kortin
     * @param card lisättävä kortti
     */
    public void giveCard(Card card) {
        this.cards.add(card);
    }
    
    /**
     * Pelaa kortin pelaajan kädestä
     * @param index kortin indeksi listassa
     * @return pelattava kortti
     */
    public Card playCard(int index) {
        return this.cards.remove(index);
    }
    
    public ArrayList<Card> getCards() {
        return this.cards;
    }
    
}
