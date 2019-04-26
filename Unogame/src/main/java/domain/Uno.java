package domain;

import java.util.ArrayList;
import domain.Card.*;

/**
 * Luokka tarjoaa toiminnallisuutta Uno-pelin pelilogiikkaan ja vuorojen kulkuun
 */
public class Uno {
    private ScoreBoard score;
    private ArrayList<Player> players;
    
    private boolean direction; //true = clockwise, false = anticlockwise
    private int currentPlayer;
    private Card lastPlayedCard;
    private Deck deck;
    
    public Uno(ScoreBoard scoreBoard, ArrayList<Player> players) {
        this.score = scoreBoard;
        this.players = players;
        this.direction = true;
        this.currentPlayer = 0;
    }
    
    public Uno() {
        this(null, new ArrayList<>());
    }
    
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    
    /**
     * Metodi aloittaa yksittäisen pelin ja luo sitä varten uuden pakan
     * ja jakaa aloituskortit pelaajille
     * @param startingPoint pelaaja, josta aloitetaan
     */
    public void startRound(int startingPoint) {
        this.deck = new Deck();
        this.deck.initializeCards();
        
        initializePlayersCards(deck);
        
        this.lastPlayedCard = deck.pick();
    }
    
    /**
     * Metodi pelaa yhden pelaajan valitseman kortin, asettaa sen päällimäiseksi ja 
     * muuttaa pelin tilaa ja muiden pelaajien korttien määrä ja pelivuoroa pelatun kortin
     * mukaan
     * @param card pelattu kortti
     * @param index kortin indeksi
     * @return onnistuiko kortin pelaaminen
     */
    public boolean playTurn(Card card, int index) {
        if (!isCardPlayable(card)) {
            return false;
        }
        
        this.lastPlayedCard = this.players.get(currentPlayer).playCard(index);
        nextPlayer();
        
        Type t = this.lastPlayedCard.getType();
        if (t.equals(Type.DRAW_TWO)) {
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
        } else if (t.equals(Type.DRAW_FOUR)) {
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
        } else if (t.equals(Type.SKIP)) {
            nextPlayer();
        } else if (t.equals(Type.REVERSE)) {
            lastPlayer();
        }
        
        return true;
    }
    
    /**
     * Metodi kertoo voiko kyseisen kortin pelata viimeksi pelatun kortin päälle
     * @param card pelattava kortti
     * @return voiko kortin pelata
     */
    public boolean isCardPlayable(Card card) {
        if (card.getColor().equals(Color.WILD)) {
            return true;
        } else if (card.getNumber().equals(lastPlayedCard.getNumber()) && card.getNumber().getCardValue() != -1) {
            System.out.println(card.getNumber().getCardValue() + " " + lastPlayedCard.getNumber().getCardValue());
            return true;
        } else if (card.getColor().equals(lastPlayedCard.getColor())) {
            System.out.println(card.getColor() + " " + lastPlayedCard.getColor());
            return true;
        } else if (card.getType().equals(lastPlayedCard.getType()) && !card.getType().equals(Type.NUMBER)) {
            return true;
        }
        
        return false;
    }
    
    public Player getCurrentPlayer() {
        return this.players.get(currentPlayer);
    }
    
    /**
     * Metodi jakaa pelaajille 7 aloituskorttia
     * @param deck pelissä käytettävä pakka 
     */
    public void initializePlayersCards(Deck deck) {
        for (Player p : this.players) {
            for (int i = 0; i < 7; i++) {
                p.giveCard(deck.pick());
            }
            System.out.println(p.getCards().size());
        }
    }
    
    public Card getLastPlayedCard() {
        return this.lastPlayedCard;
    }
    
    public String getDirection() {
        return this.direction ? "clockwise" : "anticlockwise";
    }
    
    /**
     * Metodi vaihtaa pelin suuntaa
     */
    public void changeDirection() {
        this.direction = !direction;
    }
    
    /**
     * Metodi siirtää vuoron seuraavalle pelaajalle
     */
    public void nextPlayer() {
       if(this.currentPlayer + 1 < players.size()) {
           this.currentPlayer += 1;
       } else {
           this.currentPlayer = 0;
       }
    }
    
    /**
     * Metodi siirtää vuoron edelliselle pelaajalle
     */
    public void lastPlayer() {
        if(this.currentPlayer - 1 < 0) {
            this.currentPlayer = players.size() - 1;
        } else {
            this.currentPlayer -= 1;
        }
    }
}