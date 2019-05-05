package ui;

import domain.Player;
import domain.Uno;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class StartView {    
    private Uno game;
    private BorderPane rootLayout;
    
    public StartView(BorderPane rootLayout, Uno game) {
        this.game = game;
        this.rootLayout = rootLayout;
    }
    
    public Parent getView() {
        VBox startmenu = new VBox();
        startmenu.setSpacing(10);
        startmenu.setStyle("-fx-background-color: #333333");
        startmenu.setAlignment(Pos.CENTER);
                
        Label text = new Label("How many players are playing?");
        text.setStyle("-fx-text-fill: white;" + "-fx-font-size: 24");
        
        Spinner<Integer> playerAmount = new Spinner<>();
        playerAmount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2,10, 2));
        
        Button playButton = new Button("Play!");
        playButton.setStyle("-fx-background-color: #42f22b;" + "-fx-font-size: 30");
        
        startmenu.getChildren().add(text);
        startmenu.getChildren().add(playerAmount);
        startmenu.getChildren().add(playButton);
        
        playButton.setOnMouseClicked((event) -> {
            int players = playerAmount.getValue();
            
            this.game.startRound(0);
            
            this.rootLayout.setCenter(new AddPlayerView(rootLayout, game).getView(players));
        });
        
        return startmenu;
    }
    
}
