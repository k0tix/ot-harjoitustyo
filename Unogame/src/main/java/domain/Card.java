package domain;

/**
 * Luokka tarjoaa Uno-kortin toiminnallisuuden
 *
 */
public class Card {
    /**
     * Mahdolliset kortin tyypit
     */
    public enum Type { NUMBER, SKIP, REVERSE, DRAW_TWO, CHANGE_COLOR, DRAW_FOUR }
    
    /**
     * Mahdolliset kortin värit
     */
    public enum Color { RED, YELLOW, GREEN, BLUE, WILD }
    
    /**
     * Mahdolliset kortin arvot
     */
    public enum Value {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), SPECIAL(-1);
        
        private int cardValue;
       
        private Value(int value) {
            this.cardValue = value;
        }
        
        /**
         * Metodi palauttaa kortin arvon numerona
         * @return kortin numeroarvo
         */
        public int getCardValue() {
            return cardValue;
        }
    }
    
    private final Type type; //Card can be a number, skip, reverse, draw two, wild or wild draw four
    private Color color; //Red, yellow, green, blue or wild if the color has not been set yet
    private final Value number; //normal cards 0-9, special card -1
    
    public Card(Type type, Color color, Value number) {
        this.type = type;
        this.color = color;
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Value getNumber() {
        return number;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Metodi kertoo voiko kyseissen kortin pelata viimeksi pelatun korin päälle
     * 
     * @param topCard viimeisin pelattu kortti
     * @return voiko kortin pelata
     */
    public boolean isPlayable(Card topCard) {
        if (getType().equals(Type.CHANGE_COLOR) || getType().equals(Type.DRAW_FOUR)) {
            return true;
        } else if (getNumber().equals(topCard.getNumber()) && getNumber().getCardValue() != -1) {
            System.out.println(getNumber().getCardValue() + " " + topCard.getNumber().getCardValue());
            return true;
        } else if (getColor().equals(topCard.getColor())) {
            System.out.println(getColor() + " " + topCard.getColor());
            return true;
        } else if (getType().equals(topCard.getType()) && !getType().equals(Type.NUMBER)) {
            return true;
        }

        return false;
    }
    
    /**
     * Metodi palauttaa kortin pistearvon
     * @return kortista saatavat pisteet
     */
    public int getPoints() {
        if (getNumber().equals(Value.SPECIAL)) {
            if (getType().equals(Type.DRAW_FOUR) || getType().equals(Type.CHANGE_COLOR)) {
                return 50;
            } else {
                return 20;
            }
        } else {
            return getNumber().getCardValue();
        }
    }
    
    /**
    * Palauttaa kortin kuvatiedoston nimen värin, tyypin ja numeron mukaan
    */
    @Override
    public String toString() {
        String color = this.color.toString().toLowerCase();
        switch (this.type) {
            case NUMBER:
                return String.format("%s_%d.png", color, this.number.getCardValue());
            case REVERSE:
                return String.format("%s_reverse.png", color);
            case SKIP:
                return String.format("%s_skip.png", color);
            case DRAW_TWO:
                return String.format("%s_picker.png", this.color.toString().toLowerCase());
            case CHANGE_COLOR:
                return "wild_color_changer.png";
            case DRAW_FOUR:
                return "wild_pick_four.png";
            default:
                return "Card unknown";
        }
    }
    
}
