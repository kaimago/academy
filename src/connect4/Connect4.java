package connect4;

import java.util.Scanner;

public class Connect4 {

    private Board board = new Board();

    public Token.Color currentColor = Token.Color.RED;

    final Scanner scanner = new Scanner(System.in);

    public void initGame() {

        board = new Board();

        System.out.println("Start Connect4");
        System.out.println("Player 1 starts (Red Tokens)");

        board.printGrid();

        inGame();
    }

    private void switchPlayer(){

        if (currentColor.equals(Token.Color.BLUE)) {
            currentColor = Token.Color.RED;
        } else {
            currentColor = Token.Color.BLUE;
        }
    }

    private void inGame() {

        GameStages currentGameStages = GameStages.IN_GAME;

        do {

            if (!currentGameStages.equals(GameStages.REPLAY)){
                switchPlayer();
            }

            System.out.println("Player " + currentColor.toString() + " please enter Column:");

            String enteredColumn = scanner.nextLine();
            Token currentToken = play(currentColor, enteredColumn);

            if (currentToken != null) {

                board.printGrid();
                if (checkWin(currentToken)){
                    System.out.println("Player " + currentColor.toString() + " win !!!!!! ");
                    currentGameStages = GameStages.END_GAME;
                } else {
                    currentGameStages = GameStages.IN_GAME;
                }
            } else {
                currentGameStages = GameStages.REPLAY;
            }

        } while (GameStages.IN_GAME.equals(currentGameStages) || GameStages.REPLAY.equals(currentGameStages) );


    }

    public enum GameStages{REPLAY, IN_GAME, END_GAME}


    public Token play(Token.Color color, String enteredColumn) {

        Integer enteredColumnInteger;

        try {
            enteredColumnInteger = Integer.valueOf(enteredColumn);
            //User entrance start with 1, but System start with 0
            enteredColumnInteger = enteredColumnInteger - 1;

        } catch (NumberFormatException e) {

            System.out.println("Please enter a number between 1 and 7");

            return null;
        }


        if (enteredColumnInteger < 0 || enteredColumnInteger > 6){

            System.out.println("Please enter a number between 1 and 7");

            return null;

        }

        try {

            return board.addToken(new Token(color, enteredColumnInteger));

        } catch (Exception e) {

            System.out.println("You can't add a Token to this column, because it is already full");

            return null;

        }


    }

    public boolean checkWin(Token token) {

        return board.hasGridDiagonalConnect(token) || board.hasGridVerticalConnect(token) ||
        board.hasGriHorizontalConnect(token);
    }

}
