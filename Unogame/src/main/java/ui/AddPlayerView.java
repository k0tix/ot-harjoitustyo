package ui;

import domain.Player;
import domain.Uno;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class AddPlayerView {
    
    private BorderPane rootLayout;
    private Uno game;
    
    public AddPlayerView(BorderPane rootLayout, Uno game) {
        this.rootLayout = rootLayout;
        this.game = game;
    }
    
    public Parent getView(int number) {
        VBox items = new VBox(10);
        
        items.setStyle("-fx-background-color: #333333");
        items.setAlignment(Pos.CENTER);
        
        Label title = new Label("Player " + (this.game.getPlayerAmount()+1));
        title.setStyle("-fx-text-fill: white;" + "-fx-font-size: 24");
        
        TextField textField = new TextField();
        textField.setPromptText("Name...");
        textField.setMaxWidth(200);
                
        Button addPlayerButton = new Button("Add player");
        
        addPlayerButton.setOnMouseClicked((event) -> {
            Player p = new Player(textField.getText());
            this.game.addPlayer(p);
            
            if(this.game.getPlayerAmount() == number) {
                System.out.println("All players set");
                this.game.startRound(0);
                GameView gameView = new GameView(rootLayout, game);
                this.rootLayout.setCenter(gameView.getTopCard());
                this.rootLayout.setBottom(gameView.getMainView());
            } else {
                title.setText("Player " + (game.getPlayerAmount()+1));
                textField.setText("");
            }
            
        });
        
        items.getChildren().addAll(title, textField, addPlayerButton);
        
        return items;
    }
}
