package connect4;

public class Token {

    private Color color;

    public enum Color {RED("R"), BLUE("B");
        private final String value;

        Color(String b) {
            value = b;
        }

        public String getValue() {
            return value;
        }
    }

    public Token(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
