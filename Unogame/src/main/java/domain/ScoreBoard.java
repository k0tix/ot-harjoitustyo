package domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka tarjoaa toiminnallisuutta pelin pistetilanteen seuraamiseen
 * 
 */
public class ScoreBoard {
    
    private HashMap<Player, Integer> points;
    
    public ScoreBoard(ArrayList<Player> players) {
        this.points = new HashMap<>();
        for (Player p : players) {
            this.points.put(p, 0);
        }
    }
    
    public int getScore(Player p) {
        return this.points.get(p);
    }
    
    /**
     * Metodi kasvattaa pelaajan kokonaispisteitä
     * @param p pelaaja
     * @param amount kasvatettava pistemäärä
     */
    public void addToScore(Player p, int amount) {
        int current = points.get(p);
        this.points.put(p, current + amount);
    }
    
    /**
     * Metodi päivittää kokonaispistetilanteen pelaajien muuttuneiden pisteiden mukaan
     * @param changes muutokset pisteisiin
     */
    public void updateScores(HashMap<Player, Integer> changes) {
        for (Player p : changes.keySet()) {
            addToScore(p, changes.get(p));
        }
    }
    
    /**
     * Metodi palauttaa pistetilanteen tekstimuodossa
     * @return tilanne tekstimuodossa
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Scores: ");
        for (Player p : this.points.keySet()) {
            result.append(String.format("\n Player %s: %d", p.getName(), this.points.get(p)));
        }
        return result.toString();
    }
}
