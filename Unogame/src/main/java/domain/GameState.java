package domain;

/**
 *
 * @author k0tix
 */
public class GameState {
    private String direction;
    private int[] scores;
    
    public GameState(int playerAmount) {
        this.direction = "clockwise";
        scores = new int[playerAmount];
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public int[] getScores() {
        return this.scores;
    }
    
    
}
