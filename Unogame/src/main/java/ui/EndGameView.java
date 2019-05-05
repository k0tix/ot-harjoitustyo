package ui;

import domain.Uno;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class EndGameView extends View {
    
    public EndGameView(BorderPane rootLayout, Uno game) {
        super(rootLayout, game);
    }

    public Parent getView() {
        VBox scores = new VBox(10);
        
        Label text = new Label(game.getScoreBoard().toString());
        text.setStyle("-fx-text-fill: white;" + "-fx-font-size: 24");
        
        scores.getChildren().add(text);
        BorderPane.setAlignment(scores, Pos.CENTER);
        
        return scores;
    }
    
}
