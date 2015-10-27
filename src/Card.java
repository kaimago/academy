public class Card {

    public Card(suit s, values v) {
        this.s = s;
        this.v = v;
    }

    public enum values  {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, KING, QUEEN, JACK}

    public enum suit {SPADES, HEARTS, DIAMONDS, CLUBS}

    suit s;

    values v;


    public suit getS() {
        return s;
    }

    public void setS(suit s) {
        this.s = s;
    }

    public values getV() {
        return v;
    }

    public void setV(values v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Card{" +
                "s=" + s +
                ", v=" + v +
                '}';
    }
}
