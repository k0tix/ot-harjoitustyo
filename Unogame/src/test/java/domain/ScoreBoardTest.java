package domain;

import domain.Player;
import domain.ScoreBoard;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k0tix
 */
public class ScoreBoardTest {
    
    ScoreBoard score;
    ArrayList<Player> players;
    
    @Before
    public void setUp() {
        players = new ArrayList<>();
        players.add(new Player(("Pekka")));
        players.add(new Player(("Matti")));
        players.add(new Player(("Kerttu")));
        
        score = new ScoreBoard(players);
    }

    @Test
    public void scoreBoardReturnZeroAsStartScore() {
        assertEquals(0, score.getScore(players.get(0)));
    }
    
    @Test
    public void scoreBoardUpdatesScoreCorrectly() {
        HashMap<Player, Integer> newScores = new HashMap<>();
        newScores.put(players.get(0), 5);
        newScores.put(players.get(1), 2);
        newScores.put(players.get(2), 1);
        
        score.updateScores(newScores);
        
        assertEquals(5, score.getScore(players.get(0)));
        assertEquals(2, score.getScore(players.get(1)));
        assertEquals(1, score.getScore(players.get(2)));
    }
    
}
