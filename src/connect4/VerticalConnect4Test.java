package connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VerticalConnect4Test {

    Board board;

    @Before
    public void setUp() {

        board = new Board();
    }

    @Test
    public void ShouldGetConnectVerticalTop() throws Exception {

        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        Token tokenToCheck = new Token(Token.Color.RED, 1);
        tokenToCheck.setRow(0);

        boolean connect = board.hasGridVerticalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetConnectVerticalBottom() throws Exception {

        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        Token tokenToCheck = new Token(Token.Color.RED, 1);
        tokenToCheck.setRow(3);

        boolean connect = board.hasGridVerticalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetConnectVerticalBottomAndTop() throws Exception {

        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        Token tokenToCheck = new Token(Token.Color.RED, 1);
        tokenToCheck.setRow(1);

        boolean connect = board.hasGridVerticalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

}
