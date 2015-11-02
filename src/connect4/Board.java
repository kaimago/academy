package connect4;

public class Board {

    Token[][] grid = new Token[7][6];

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public boolean addToken(Token token, int column) throws Exception {

        int freeRowSlotOfColumn = getFreeRowSlotOfColumn(column);

        grid[column][freeRowSlotOfColumn] = token;

        return true;
    }

    public int getFreeRowSlotOfColumn(int column) throws Exception {

        Token[] tokens = grid[column];

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i] == null) {
                return i;
            }
        }
        throw new Exception();
    }

    public Token[][] getGrid() {
        return grid;
    }

    public void printGrid() {

        System.out.println("-----------------------------");

        for (int counterRow = grid[0].length-1; counterRow > -1; counterRow--) {
             String column = "| ";
            //Counter for Columns
            for (int counterColumn = 0; counterColumn < grid.length; counterColumn++) {

            Token token = grid[counterColumn][counterRow];

            if (token == null) {
                column += ".";
            } else {

                if (Token.Color.RED.equals(token.getColor())){
                    column += ANSI_RED+token.getColor().getValue()+ANSI_RESET;
                } else {
                    column += ANSI_BLUE+token.getColor().getValue()+ANSI_RESET;
                }
            }

            column += " | ";
        }
        System.out.println(column);
        System.out.println("-----------------------------");

        }

    }

    public Token getGridToken(int column, int row) {
        return getGrid()[column][row];
    }
}
