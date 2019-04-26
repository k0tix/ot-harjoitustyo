package ui;

import domain.Player;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class AddPlayerView {

    private ArrayList<Player> players;
    
    private ViewController views;
    
    public AddPlayerView(ArrayList<Player> players, ViewController views) {
        this.players = players;
        this.views = views;
    }
    
    public Parent getView(int number) {
        VBox items = new VBox(10);
        
        items.setStyle("-fx-background-color: #3f4144");
        items.setAlignment(Pos.CENTER);
        
        Label title = new Label("Player " + (players.size()+1));
        title.setStyle("-fx-text-fill: white;" + "-fx-font-size: 24");
        
        TextField textField = new TextField();
        textField.setPromptText("Name...");
        textField.setMaxWidth(200);
                
        Button addPlayerButton = new Button("Add player");
        
        addPlayerButton.setOnMouseClicked((event) -> {
            Player p = new Player(textField.getText());
            this.players.add(p);
            
            if(this.players.size() == number) {
                System.out.println("All players set");
                this.views.setView(new GameView(views).getView(views.getGame().getCurrentPlayer().getCards()));
            } else {
                this.views.setView(new AddPlayerView(players, views).getView(number));
            }
            
        });
        
        items.getChildren().addAll(title, textField, addPlayerButton);
        
        return items;
    }
}
