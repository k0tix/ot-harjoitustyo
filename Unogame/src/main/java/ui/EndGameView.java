package ui;

import domain.Uno;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author k0tix
 */
public class EndGameView extends View {
    
    public EndGameView(BorderPane rootLayout, Uno game) {
        super(rootLayout, game);
    }

    public Parent getView() {
        return new Button("YAYASKJDÖLAKFJÖLKDAJFASF");
    }
    
}
