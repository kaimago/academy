package connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiagonalConnect4Test {

    Board board;

    @Before
    public void setUp() {

        board = new Board();
    }

    @Test
    public void ShouldGetDiagonalConnectTopRight() throws Exception {

        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));
        Token tokenToCheck = new Token(Token.Color.RED, 0);

        boolean connect = board.hasGridDiagonalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetDiagonalConnectTopLeft() throws Exception {

        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        Token tokenToCheck = new Token(Token.Color.RED, 3);

        boolean connect = board.hasGridDiagonalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetDiagonalConnectBottomRight() throws Exception {

        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        Token tokenToCheck = new Token(Token.Color.RED, 0);
        tokenToCheck.setRow(3);

        boolean connect = board.hasGridDiagonalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetDiagonalConnectLeftBottom() throws Exception {

        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));

        Token tokenToCheck = new Token(Token.Color.RED, 3);
        tokenToCheck.setRow(3);

        boolean connect = board.hasGridDiagonalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }


    @Test
    public void ShouldGetDiagonalConnectLeftBottomAndRightTop() throws Exception {

        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));
        board.addToken(new Token(Token.Color.RED, 3));

        Token tokenToCheck = new Token(Token.Color.RED, 1);
        tokenToCheck.setRow(1);

        boolean connect = board.hasGridDiagonalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

    @Test
    public void ShouldGetDiagonalConnectLeftTopAndRightBottom() throws Exception {

        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 0));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 3));

        Token tokenToCheck = new Token(Token.Color.RED, 2);
        tokenToCheck.setRow(1);

        boolean connect = board.hasGridDiagonalConnect(tokenToCheck);

        Assert.assertTrue(connect);

    }

}
