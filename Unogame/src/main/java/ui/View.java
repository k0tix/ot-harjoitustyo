package ui;

import domain.Uno;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author k0tix
 */
abstract class View {
    
    BorderPane rootLayout;
    Uno game;
    
    public View(BorderPane rootLayout, Uno game) {
        this.rootLayout = rootLayout;
        this.game = game;
    }
    
    public void clearRootLayout() {
        rootLayout.setTop(null);
        rootLayout.setBottom(null);
        rootLayout.setRight(null);
        rootLayout.setCenter(null);
    }
    
    abstract public Parent getView();
}
