package ui;

import domain.Player;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class SetPlayerView {

    private ArrayList<Player> players;
    
    public SetPlayerView(ArrayList<Player> players) {
        this.players = players;
    }
    
    public Parent getView(int number) {
        VBox items = new VBox(10);
        
        Label title = new Label("Player" + number);
        
        HBox input = new HBox();
        Label inputLabel = new Label("Name: ");
        TextField textField = new TextField();
        input.getChildren().addAll(inputLabel, textField);
        
        Button addPlayerButton = new Button("Add player");
        
        addPlayerButton.setOnMouseClicked((event) -> {
            Player p = new Player(textField.getText());
            this.players.add(p);
        });
        
        items.getChildren().addAll(title, input, addPlayerButton);
        
        return items;
    }
}
