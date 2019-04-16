package domain;

import java.util.ArrayList;

public class Uno {
    private ScoreBoard score;
    private ArrayList<Player> players;
    private int playerAmount;
    
    public Uno(ScoreBoard scoreBoard, ArrayList<Player> players) {
        this.score = scoreBoard;
        this.players = players;
    }
    
    public Uno() {
        
    }
    
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    
    public void setPlayerAmount(int amount) {
        this.playerAmount = amount;
    }
    
    public void playRound(int startingPoint) {
        Deck deck = new Deck();
        deck.initializeCards();
        
        String direction = "clockwise";
        
        initializePlayersCards(deck);
        
        Card lastPlayedCard = deck.pick();
    }
    
    public void initializePlayersCards(Deck deck) {
        for (Player p : this.players) {
            for (int i = 0; i < 7; i++) {
                p.giveCard(deck.pick());
            }
        }
    }
    
}
