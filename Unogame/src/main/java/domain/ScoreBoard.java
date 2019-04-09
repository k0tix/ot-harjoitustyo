package domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author k0tix
 */
public class ScoreBoard {
    
    private HashMap<String, Integer> points;
    
    public ScoreBoard(ArrayList<Player> players) {
        this.points = new HashMap<>();
        for (Player p : players) {
            this.points.put(p.getId(), 0);
        }
    }
    
    public int getScore(String playerId) {
        return this.points.get(playerId);
    }
    
    public void addToScore(String playerId, int amount) {
        int current = points.get(playerId);
        this.points.put(playerId, current + amount);
    }
    
    public void updateScores(HashMap<String, Integer> changes) {
        
        for (String id : changes.keySet()) {
            addToScore(id, changes.get(id));
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Scores: ");
        for (String id : this.points.keySet()) {
            result.append(String.format("\n Player %s: %d", id, this.points.get(id)));
        }
        return result.toString();
    }
}
