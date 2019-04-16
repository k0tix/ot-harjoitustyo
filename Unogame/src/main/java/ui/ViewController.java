package ui;

import java.util.HashMap;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author k0tix
 */
public class ViewController {
    private HashMap<String, Parent> views;
    private BorderPane rootLayout;
    
    
    public ViewController(BorderPane rootLayout) {
        this.views = new HashMap<>();
        this.rootLayout = rootLayout;
    }
    
    public void addView(String name, Parent view) {
        this.views.put(name, view);
    }
    
    public void setView(String name) {
        this.rootLayout.setCenter(this.views.get(name));
    }
    
}
