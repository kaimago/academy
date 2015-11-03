package connect4;

public class Board {

    Token[][] grid = new Token[7][6];

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public enum OPERATION {PLUS, MINUS, NEUTRAL}

    public Token addToken(Token token) throws Exception {

        int freeRowSlotOfColumn = getFreeRowSlotOfColumn(token.getColumn());
        token.setRow(freeRowSlotOfColumn);

        grid[token.getColumn()][token.getRow()] = token;

        return token;
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


    public void printGrid() {

        System.out.println("-----------------------------");

        for (int counterRow = grid[0].length-1; counterRow > -1; counterRow--) {
             String column = "| ";
            //Counter for Columns
            for (Token[] aGrid : grid) {

                Token token = aGrid[counterRow];

                if (token == null) {
                    column += ".";
                } else {

                    if (Token.Color.RED.equals(token.getColor())) {
                        column += ANSI_RED + token.getColor().getValue() + ANSI_RESET;
                    } else {
                        column += ANSI_BLUE + token.getColor().getValue() + ANSI_RESET;
                    }
                }

                column += " | ";
            }
        System.out.println(column);
        System.out.println("-----------------------------");

        }

    }

    public Token getGridToken(int column, int row) {

        try {
            return grid[column][row];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean hasGriHorizontalConnect(Token tokenToCheck) {

        int matchedTokenLeft = getMatchedToken(tokenToCheck, OPERATION.MINUS, OPERATION.NEUTRAL);

        int matchedTokenRight = getMatchedToken(tokenToCheck, OPERATION.PLUS, OPERATION.NEUTRAL);

        return matchedTokenLeft + matchedTokenRight >= 3;

    }

    public boolean hasGridVerticalConnect(Token tokenToCheck) {

        int matchedTokenTop = getMatchedToken(tokenToCheck, OPERATION.NEUTRAL, OPERATION.PLUS);

        int matchedTokenBottom = getMatchedToken(tokenToCheck, OPERATION.NEUTRAL, OPERATION.MINUS);

        return matchedTokenTop + matchedTokenBottom >= 3;

    }

    public boolean hasGridDiagonalConnect(Token token) {

        int matchedTokenRightTop = getMatchedToken(token, OPERATION.PLUS, OPERATION.PLUS);

        int matchedTokenLeftBottom = getMatchedToken(token, OPERATION.MINUS, OPERATION.MINUS);

        //Combine number of token in both right top and left bottom direction,
        //to check if there is a connect 4
        if (matchedTokenRightTop + matchedTokenLeftBottom >= 3) {
            return true;
        }

        int matchedTokenLeftTop = getMatchedToken(token, OPERATION.MINUS, OPERATION.PLUS);

        int matchedTokenRightBottom = getMatchedToken(token, OPERATION.PLUS, OPERATION.MINUS);

        //Combine number of token in left top and right bottom direction,
        //to check if there is a connect 4
        return matchedTokenLeftTop + matchedTokenRightBottom >= 3;

    }

    private int getMatchedToken(Token token, OPERATION columnSign, OPERATION rowSign) {

        int column = token.getColumn();
        int row = token.getRow();

        int matchedToken = 0;

        //Check for next Token in the left top direction
        for(int counter = 1; counter < 4; counter++) {

            int nextTokenColumn;
            if (columnSign.equals(OPERATION.PLUS)){
                nextTokenColumn = column + counter;
            } else if (columnSign.equals(OPERATION.MINUS))  {
                nextTokenColumn = column - counter;
            } else {
                nextTokenColumn = column;
            }

            int nextTokenRow;
            if (rowSign.equals(OPERATION.PLUS)){
                nextTokenRow = row + counter;
            } else if (rowSign.equals(OPERATION.MINUS)) {
                nextTokenRow = row - counter;
            } else {
                nextTokenRow = row;
            }

            if (hasTokenThisColor(token.getColor(), nextTokenColumn, nextTokenRow)) {

                matchedToken = counter;

            } else {
                break;
            }
        }
        return matchedToken;
    }



    public boolean hasTokenThisColor(Token.Color color, int column, int row) {

        Token gridToken = getGridToken(column, row);

        if (gridToken != null){

            if (gridToken.getColor().equals(color)) {

                return true;
            }
        }

        return false;

    }

}
