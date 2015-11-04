package connect4;

public class Player {

    private Token.Color color;
    private String name;

    public Player(Token.Color color) {
        this.color = color;
    }

    public Token.Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}