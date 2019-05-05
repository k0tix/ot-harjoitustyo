package ui;

import domain.Card;
import domain.Uno;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class GameView {

    private BorderPane rootLayout;
    private Uno game;

    public GameView(BorderPane rootLayout, Uno game) {
        this.rootLayout = rootLayout;
        this.game = game;
    }

    public Parent getMainView() {
        ArrayList<Card> hand = game.getCurrentPlayer().getCards();
        System.out.println(game.getPlayerAmount());

        System.out.println("asd");

        HBox cards = new HBox(10);
        ScrollPane scroller = new ScrollPane(cards);
        scroller.setFitToHeight(true);

        cards.setStyle("-fx-background-color: #333333");
        cards.setAlignment(Pos.CENTER);

        setCards(cards);

        rootLayout.setStyle("-fx-background-color: #333333;");

        return scroller;
    }

    public ImageView getTopCard() {
        ImageView topCard = new ImageView(getFilePath(game.getLastPlayedCard().toString()));
        return topCard;
    }

    private String getFilePath(String fileName) {
        System.out.println(fileName);
        return ClassLoader.getSystemClassLoader().getResource("images/" + fileName).toString();
    }

    private void setCards(HBox cards) {
        cards.getChildren().clear();

        ArrayList<Card> hand = game.getCurrentPlayer().getCards();
        for (int i = 0; i < hand.size(); i++) {
            ImageView card = new ImageView(getFilePath(hand.get(i).toString()));
            card.setId("" + i);
            cards.getChildren().add(card);

            card.setOnMouseClicked((event) -> {
                ImageView c = (ImageView) event.getSource();
                int idx = Integer.parseInt(c.getId());
                Card cardObject = hand.get(idx);

                if (cardObject.getType().equals(Card.Type.CHANGE_COLOR) || cardObject.getType().equals(Card.Type.DRAW_FOUR)) {
                    rootLayout.setCenter(selectColor(cardObject, cards));
                } else if (game.playTurn(cardObject)) {
                    setCards(cards);
                    rootLayout.setCenter(getTopCard());
                }
            });
        }
    }

    private Parent selectColor(Card card, HBox cards) {
        VBox colors = new VBox();

        Button red = new Button("red");
        red.setStyle("-fx-background-color: red");
        red.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.RED);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        Button green = new Button("green");
        green.setStyle("-fx-background-color: green");
        green.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.GREEN);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        Button blue = new Button("blue");
        blue.setStyle("-fx-background-color: blue");
        blue.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.BLUE);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        Button yellow = new Button("yellow");
        yellow.setStyle("-fx-background-color: yellow");
        yellow.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.YELLOW);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        colors.getChildren().addAll(red, green, blue, yellow);
        return colors;
    }

    private void setTopCard(ImageView topCard) {
        topCard.setImage(new Image(getFilePath(game.getLastPlayedCard().toString())));
    }
}
