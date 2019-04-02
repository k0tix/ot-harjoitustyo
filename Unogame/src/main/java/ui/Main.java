package ui;

import domain.Deck;

/**
 *
 * @author k0tix
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Deck deck = new Deck();
        System.out.println(deck.isEmpty());
        deck.initializeCards();
        System.out.println(deck.isEmpty());
    }
    
}
