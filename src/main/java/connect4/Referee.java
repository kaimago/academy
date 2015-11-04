package connect4;

public class Referee {

    public boolean isDraw(Board board) {

        for (Token[] columns : board.grid) {
            for (Token token : columns) {
                if (token == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
