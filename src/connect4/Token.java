package connect4;

public class Token {

    private Color color;

    private int row;

    private int column;

    public enum Color {RED("R"), BLUE("B");
        private final String value;

        Color(String b) {
            value = b;
        }

        public String getValue() {
            return value;
        }
    }

    public Token(Color color, int column) {
        this.color = color;
        this.column = column;
    }



    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
