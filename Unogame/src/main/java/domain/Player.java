package domain;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

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
     *
     * @param card lisättävä kortti
     */
    public void giveCard(Card card) {
        if (card != null) {
            this.cards.add(card);
        }
    }

    /**
     * Pelaa kortin pelaajan kädestä
     *
     * @param index kortin indeksi listassa
     * @return pelattava kortti
     */
    public boolean playCard(Card card) {
        return this.cards.remove(card);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Palauttaa kortit joita pelaaja voi pelata
     *
     * @param topCard viimeisin pelattu kortti
     * @return lista mahdollisista korteista
     */
    public ArrayList<Card> getPlayableCards(Card topCard) {
        return this.cards.stream()
                .filter((card) -> (card.isPlayable(topCard))).collect(Collectors.toCollection(ArrayList::new));
    }
}
