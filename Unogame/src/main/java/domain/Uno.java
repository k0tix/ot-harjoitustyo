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
    private boolean gameEnd;

    public Uno() {
        this.score = null;
        this.players = new ArrayList<>();
        this.direction = true;
        this.currentPlayer = 0;
        this.gameEnd = false;
    }
    
    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.score = scoreBoard;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getPlayerAmount() {
        return this.players.size();
    }

    /**
     * Metodi aloittaa yksittäisen pelin ja luo sitä varten uuden pakan ja jakaa
     * aloituskortit pelaajille
     *
     * @param startingPoint pelaaja, josta aloitetaan
     */
    public void startRound(int startingPoint) {
        this.deck = new Deck();
        this.deck.initializeCards();

        initializePlayersCards(deck);

        this.lastPlayedCard = deck.pick();
    }

    /**
     * Metodi pelaa yhden pelaajan valitseman kortin, asettaa sen päällimäiseksi
     * ja muuttaa pelin tilaa ja muiden pelaajien korttien määrä ja pelivuoroa
     * pelatun kortin mukaan
     *
     * @param card pelattu kortti
     * @return onnistuiko kortin pelaaminen
     */
    public boolean playTurn(Card card) {
        if (!card.isPlayable(getLastPlayedCard())) {
            return false;
        }

        getCurrentPlayer().playCard(card);

        if (getCurrentPlayer().getCards().isEmpty()) {
            score.addToScore(getCurrentPlayer(), calculateScore());
            this.gameEnd = true;
        }

        this.lastPlayedCard = card;

        handleGameChanges();

        return true;
    }

    private void handleGameChanges() {
        Type t = this.lastPlayedCard.getType();

        if (t.equals(Type.REVERSE)) {
            changeDirection();
        }

        nextPlayer();

        if (t.equals(Type.DRAW_TWO)) {
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
            nextPlayer();
        } else if (t.equals(Type.DRAW_FOUR)) {
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
            getCurrentPlayer().giveCard(deck.pick());
            nextPlayer();
        } else if (t.equals(Type.SKIP)) {
            nextPlayer();
        }
    }
    
    public boolean getGameEnd() {
        return gameEnd;
    }

    public Player getCurrentPlayer() {
        return this.players.get(currentPlayer);
    }

    /**
     * Metodi jakaa pelaajille 7 aloituskorttia
     *
     * @param deck pelissä käytettävä pakka
     */
    public void initializePlayersCards(Deck deck) {
        for (Player p : this.players) {
            for (int i = 0; i < 7; i++) {
                p.giveCard(deck.pick());
            }
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
     * Metodi siirtää vuoron seuraavalle pelaajalle suunnan mukaan
     */
    public void nextPlayer() {

        if (this.direction) {
            if (this.currentPlayer + 1 < players.size()) {
                this.currentPlayer += 1;
            } else {
                this.currentPlayer = 0;
            }
        } else {
            if (this.currentPlayer - 1 < 0) {
                this.currentPlayer = players.size() - 1;
            } else {
                this.currentPlayer -= 1;
            }
        }
    }

    public int calculateScore() {
        int score = 0;
        for (Player p : players) {
            if (!p.getCards().isEmpty()) {
                score += p.getCards().stream().map(c -> c.getPoints()).reduce(0, (a, b) -> a + b);
            }
        }
        return score;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public ScoreBoard getScoreBoard() {
        return this.score;
    }
}
