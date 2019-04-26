package ui;

import domain.Card;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author k0tix
 */
public class GameView {
    
    private ViewController views;
    private Card selected;
    private int index;
    
    public GameView(ViewController views) {
        this.views = views;
    }
    
    public Parent getView(ArrayList<Card> hand) {
        HBox cards = new HBox(10);
        ScrollPane scroller = new ScrollPane(cards);
        scroller.setFitToHeight(true);
        
        cards.setStyle("-fx-background-color: #3f4144");
        cards.setAlignment(Pos.CENTER);
        
        for(int i = 0; i < hand.size(); i++) {
            Button card = new Button(hand.get(i).toString());
            card.setId("" + i);
            String color = hand.get(i).getColor().toString().toLowerCase();
            color = color.equals("wild") ? "black" : color;
            card.setStyle("-fx-background-color: " + color + "; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2px; -fx-pref-width: 100px; -fx-pref-height: 200px;");
            card.setWrapText(true);
            cards.getChildren().add(card);
            
            card.setOnMouseClicked((event) -> {
                Button b = (Button) event.getSource();
                int index = Integer.parseInt(b.getId());
                if (this.views.getGame().playTurn(hand.get(index), index)) {
                    this.views.setView(new GameView(views).getView(this.views.getGame().getCurrentPlayer().getCards()));
                }
            });
        }
                
        return scroller;
    }
}
