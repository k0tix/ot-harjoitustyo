package ui;

import domain.Uno;
import java.util.HashMap;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author k0tix
 */
public class ViewController {
    private HashMap<String, Parent> views;
    private BorderPane rootLayout;
    private Uno game;
    
    public ViewController(BorderPane rootLayout, Uno game) {
        this.views = new HashMap<>();
        this.rootLayout = rootLayout;
        this.game = game;
    }
    
    public void addView(String name, Parent view) {
        this.views.put(name, view);
    }
    
    public void setView(String name) {
        this.rootLayout.setCenter(this.views.get(name));
    }
    
    public void setView(Parent view) {
        updateGameState();
        this.rootLayout.setCenter(view);
    }
    
    public void updateGameState() {
        this.rootLayout.setTop(new Label("Last card: " + game.getLastPlayedCard().toString() + " Direction: " + game.getDirection()));
    }
    
    public Uno getGame() {
        return this.game;
    }
}
