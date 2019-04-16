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
    private Uno game;
    private ViewController views;
        
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
        this.game = new Uno();
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane rootLayout = new BorderPane();
        
        this.views = new ViewController(rootLayout);
        
        Label gameData = new Label("Here is some data about the game");
        rootLayout.setTop(gameData);
        
        StartView startScreen = new StartView(game, this.views);
        Scene scene = new Scene(rootLayout, 600, 400);
        
        this.views.addView("startscreen", startScreen.getView());
        this.views.setView("startscreen");                
        stage.setTitle("Uno");
        stage.setScene(scene);
        stage.show();
    }
    
}
