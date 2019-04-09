/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        assertEquals(0, score.getScore(players.get(0).getId()));
    }
    
    @Test
    public void scoreBoardUpdatesScoreCorrectly() {
        HashMap<String, Integer> newScores = new HashMap<>();
        newScores.put(players.get(0).getId(), 5);
        newScores.put(players.get(1).getId(), 2);
        newScores.put(players.get(2).getId(), 1);
        
        score.updateScores(newScores);
        
        assertEquals(5, score.getScore(players.get(0).getId()));
        assertEquals(2, score.getScore(players.get(1).getId()));
        assertEquals(1, score.getScore(players.get(2).getId()));
    }
    
}
