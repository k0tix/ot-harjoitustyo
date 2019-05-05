package ui;

import domain.Card;
import domain.Uno;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author k0tix
 */
public class GameView extends View {

    public GameView(BorderPane rootLayout, Uno game) {
        super(rootLayout, game);
    }

    public Parent getView() {
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
        setGameInfo();
        if (game.getGameEnd()) {
            rootLayout.setCenter(new EndGameView(rootLayout, game).getView());
            System.out.println("HERE");
            return;
        }

        cards.getChildren().clear();

        if (game.getCurrentPlayer().getPlayableCards(game.getLastPlayedCard()).size() < 1) {
            Button pickCard = new Button("Pick card");
            pickCard.setStyle("-fx-background-color: pink");
            pickCard.setOnMouseClicked((event) -> {
                Card newCard = game.getDeck().pick();
                game.getCurrentPlayer().giveCard(newCard);

                if (newCard.isPlayable(game.getLastPlayedCard())) {
                    setCards(cards);
                } else {
                    game.nextPlayer();
                    setCards(cards);
                }
            });

            rootLayout.setRight(pickCard);
        } else {
            rootLayout.setRight(null);
        }

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
                    System.out.println("also 1");
                } else if (game.playTurn(cardObject)) {
                    setCards(cards);
                    rootLayout.setCenter(getTopCard());
                    System.out.println("also 2");
                }
            });
        }

        if (game.getGameEnd()) {
            rootLayout.setCenter(new Button("NOONAOSDBOSADBOSABD"));
        }
    }

    private void setGameInfo() {
        HBox info = new HBox(10);

        Button currentPlayer = new Button("Player: " + game.getCurrentPlayer().getName());
        currentPlayer.setStyle("-fx-background-color: orange; -fx-font-size: 16;");

        Button direction = new Button(game.getDirection());
        direction.setStyle("-fx-background-color: orange; -fx-font-size: 16;");

        String color = game.getLastPlayedCard().getColor().toString().toLowerCase();
        Button currentColor = new Button(color);
        String buttonColor = "";

        switch (color) {
            case "red":
                buttonColor = "#F56462";
                break;
            case "green":
                buttonColor = "#2FE29B";
                break;
            case "blue":
                buttonColor = "#00C3E5";
                break;
            default:
                buttonColor = "#F7E359";
                break;
        }

        currentColor.setStyle("-fx-background-color: " + buttonColor + "; -fx-font-size: 16;");

        info.setStyle("-fx-background-color: orange; -fx-font-size: 16; -fx-text-fill: white");
        BorderPane.setAlignment(info, Pos.CENTER);
        info.getChildren().addAll(currentPlayer, direction, currentColor);
        info.setStyle("-fx-background-color: #333333;");
        info.setAlignment(Pos.CENTER);
        rootLayout.setTop(info);
    }

    private Parent selectColor(Card card, HBox cards) {
        VBox colors = new VBox();
        BorderPane.setAlignment(colors, Pos.CENTER);

        Button red = new Button("red");
        red.setStyle("-fx-background-color: #F56462");
        red.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.RED);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        Button green = new Button("green");
        green.setStyle("-fx-background-color: #2FE29B");
        green.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.GREEN);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        Button blue = new Button("blue");
        blue.setStyle("-fx-background-color: #00C3E5");
        blue.setOnMouseClicked((event) -> {
            card.setColor(Card.Color.BLUE);
            if (game.playTurn(card)) {
                setCards(cards);
                rootLayout.setCenter(getTopCard());
            }
        });

        Button yellow = new Button("yellow");
        yellow.setStyle("-fx-background-color: #F7E359");
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
}
