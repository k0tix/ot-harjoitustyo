package ui;

import domain.Deck;
import domain.Uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author k0tix
 */
public class UnoUi extends Application {
    private ViewController views;
        
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane rootLayout = new BorderPane();
        
        this.views = new ViewController(rootLayout, new Uno());
        
        Label gameData = new Label("Direction: " + this.views.getGame().getDirection() + " Players: " + this.views.getGame().getPlayers().size());
        rootLayout.setTop(gameData);
        
        StartView startScreen = new StartView(this.views);
        Scene scene = new Scene(rootLayout, 600, 400);
        
        this.views.addView("startscreen", startScreen.getView());
        this.views.setView("startscreen");
        
        stage.setTitle("Uno");
        stage.setScene(scene);
        stage.show();
    }
    
}
