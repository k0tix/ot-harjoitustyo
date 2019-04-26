package domain;

/**
 *
 * @author k0tix
 */
public class Card {
    public enum Type { NUMBER, SKIP, REVERSE, DRAW_TWO, CHANGE_COLOR, DRAW_FOUR }
    public enum Color { RED, YELLOW, GREEN, BLUE, WILD }
    public enum Value {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), SPECIAL(-1);
        
        private int cardValue;
       
        private Value(int value) {
            this.cardValue = value;
        }
        
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

    @Override
    public String toString() {
        switch (this.type) {
            case NUMBER:
                return String.format("%s %d", this.color, this.number.getCardValue());
            case REVERSE:
                return String.format("%s %s", this.color, this.type);
            case SKIP:
                return String.format("%s %s", this.color, this.type);
            case DRAW_TWO:
                return String.format("%s %s", this.color, this.type);
            case CHANGE_COLOR:
                return "" + this.type;
            case DRAW_FOUR:
                return "" + this.type;
            default:
                return "Card unknown";
        }
    }
    
}
