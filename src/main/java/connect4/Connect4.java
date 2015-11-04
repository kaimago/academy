package connect4;

import java.util.Scanner;

public class Connect4 {

    private Board board = new Board();

    private Referee referee = new Referee();

    public Token.Color currentColor = Token.Color.RED;

    final Scanner scanner = new Scanner(System.in);

    private Player playerRed = new Player(Token.Color.RED);
    private Player playerBlue = new Player(Token.Color.BLUE);


    public Token initGame() {

        board = new Board();

        System.out.println("Start Connect4");

        savePlayername(Token.Color.BLUE);
        savePlayername(Token.Color.RED);

        board.printGrid();

        inGame();
        return null;
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

            System.out.println("Awaiting " + findAwaitingPlayer().getName() + ", Ongoing " + findOOngoingPlayer().getName() );
            System.out.println("Please enter name,columnnumber:");


            String enteredColumn = getScanner().nextLine();
            Token currentToken = play(currentColor, enteredColumn);

            if (currentToken != null) {

                board.printGrid();
                if (checkWin(currentToken)){
                    System.out.println("Player " + currentColor.toString() + " win !!!!!! ");
                    currentGameStages = GameStages.END_GAME;
                } else if (getReferee().isDraw(board)){
                    System.out.println("The game is draw");
                    currentGameStages = GameStages.END_GAME;
                } else {
                    currentGameStages = GameStages.IN_GAME;
                }
            } else {
                currentGameStages = GameStages.REPLAY;
            }

        } while (GameStages.IN_GAME.equals(currentGameStages) || GameStages.REPLAY.equals(currentGameStages) );


    }

    public void savePlayername(Token.Color color) {

        System.out.println("Player " + color.toString() + " please enter your name !");

        String enteredColumn = getScanner().nextLine();

        String username = enteredColumn.trim();

        if (color.equals(Token.Color.BLUE)) {
            playerBlue.setName(username);
        } else {
            playerRed.setName(username);
        }
        
    }

    public Player findAwaitingPlayer() {

        if (currentColor.equals(playerBlue.getColor())) {
            return playerBlue;
        } else {
            return playerRed;
        }
    }

    public Player findOOngoingPlayer() {

        if (currentColor.equals(playerBlue.getColor())) {
            return playerRed;
        } else {
            return playerBlue;
        }
    }

    public boolean validateInput(String enteredValue) {

        String[] split = enteredValue.split(",");

        if (split.length != 2){
            System.out.println("You entered more than one comma");
            return false;
        }

        String playername = split[0];

        if (!(playername.equalsIgnoreCase(getPlayerBlue().getName()) || playername.equalsIgnoreCase(getPlayerRed().getName()))){
            System.out.println("Playername can not be matched");
            return false;
        }

        return true;
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

    public Scanner getScanner() {
        return scanner;
    }

    public Referee getReferee() {
        return referee;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }
}
