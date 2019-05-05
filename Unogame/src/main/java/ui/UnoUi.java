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
        
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane rootLayout = new BorderPane();
        
        Uno game = new Uno();
        
        StartView startScreen = new StartView(rootLayout, game);
        Scene scene = new Scene(rootLayout, 600, 400);
        
        rootLayout.setCenter(startScreen.getView());
        
        stage.setTitle("Uno");
        stage.setScene(scene);
        stage.show();
    }
    
}
