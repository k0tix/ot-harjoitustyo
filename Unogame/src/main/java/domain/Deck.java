package domain;

import domain.Card.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * Luokka toteuttaa korttipakan
 */
public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    /**
     * Metodi sekoittaa korttipakan
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Metodi palauttaa pakan päällimäisen kortin ja poistaa sen korttipakasta
     *
     * @return päällimainen kortti
     */
    public Card pick() {
        if (deck.isEmpty()) {
            return null;
        }
        
        return this.deck.remove(0);
    }

    /**
     * Metodi kerto onko korttipakassa vielä kortteja
     *
     * @return onko tyhjä
     */
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }

    /**
     * Metodi alustaa korttipakan ja lisää sinne Uno-pakassa olevat kortit ja
     * lopuksi sekoittaa pakan
     */
    public void initializeCards() {
        this.deck.clear();

        addNumberCards();
        addActionCards();
        addWildCards();

        shuffle();
    }

    /**
     * Metodi lisää pakkaan numerokortit
     */
    private void addNumberCards() {
        Arrays.stream(Color.values()).forEach(color -> {
            if (color.equals(Color.WILD)) {
                return;
            }
            this.deck.add(new Card(Type.NUMBER, color, Value.ZERO));

            for (int num = 1; num < 10; num++) {
                this.deck.add(new Card(Type.NUMBER, color, Value.values()[num]));
                this.deck.add(new Card(Type.NUMBER, color, Value.values()[num]));
            }
        });
    }

    /**
     * Metodi lisää pakkaan toimintakortit
     */
    private void addActionCards() {
        Arrays.stream(Color.values()).forEach(color -> {
            if (color.equals(Color.WILD)) {
                return;
            }
            this.deck.add(new Card(Type.SKIP, color, Value.SPECIAL));
            this.deck.add(new Card(Type.SKIP, color, Value.SPECIAL));
            this.deck.add(new Card(Type.REVERSE, color, Value.SPECIAL));
            this.deck.add(new Card(Type.REVERSE, color, Value.SPECIAL));
            this.deck.add(new Card(Type.DRAW_TWO, color, Value.SPECIAL));
            this.deck.add(new Card(Type.DRAW_TWO, color, Value.SPECIAL));
        });
    }

    /**
     * Metodi lisää pakkaan villikortit
     */
    private void addWildCards() {
        for (int i = 0; i < 4; i++) {
            this.deck.add(new Card(Type.CHANGE_COLOR, Color.WILD, Value.SPECIAL));
            this.deck.add(new Card(Type.DRAW_FOUR, Color.WILD, Value.SPECIAL));
        }
    }
}
