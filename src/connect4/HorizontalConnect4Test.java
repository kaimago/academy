package connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HorizontalConnect4Test {

    Board board;

    @Before
    public void setUp() {

        board = new Board();
    }

    @Test
    public void ShouldGetConnectHorizontalLeft() throws Exception {

        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));
        Token tokenToCheck = new Token(Token.Color.RED, 3);
        tokenToCheck.setRow(0);

        boolean connect = board.hasGriHorizontalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetConnectHorizontalRight() throws Exception {

        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));
        Token tokenToCheck = new Token(Token.Color.RED, 0);
        tokenToCheck.setRow(0);

        boolean connect = board.hasGriHorizontalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetConnectHorizontalRightAndLeft() throws Exception {

        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));
        Token tokenToCheck = new Token(Token.Color.RED, 1);
        tokenToCheck.setRow(0);

        boolean connect = board.hasGriHorizontalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }



}
