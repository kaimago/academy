package connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    Board board;

    @Before
    public void setUp() {

        board = new Board();

    }

    @Test
    public void ShouldAddTokenToGridColumn() throws Exception {

        Token newToken = new Token(Token.Color.BLUE);

        Token emptyToken = board.getGridToken(5,6);

        Assert.assertEquals(null, emptyToken);

        boolean tokenAdded = board.addToken(newToken, 0);

        org.junit.Assert.assertTrue(tokenAdded);

        Token addedToken = board.getGrid()[0][0];

        org.junit.Assert.assertTrue(addedToken.equals(newToken));
        org.junit.Assert.assertFalse(addedToken.equals(new Token(Token.Color.BLUE)));

    }

    @Test
    public void addTokenToFullColumn() {

        Token newToken = new Token(Token.Color.BLUE);

        try {

            board.addToken(newToken, 0);
            board.addToken(newToken, 0);
            board.addToken(newToken, 0);
            board.addToken(newToken, 0);
            board.addToken(newToken, 0);
            board.addToken(newToken, 0);
            board.addToken(newToken, 0);
            board.addToken(newToken, 0);

        } catch (Exception e) {
            Assert.assertTrue(true);
            return;
        }

        Assert.assertFalse(true);


    }


    @Test
    public void printGrid() throws Exception {

        Token tokenBlue = new Token(Token.Color.BLUE);
        Token tokenRed = new Token(Token.Color.RED);

        board.addToken(tokenBlue, 0);
        board.addToken(tokenRed, 1);
        board.addToken(tokenBlue, 2);
        board.addToken(tokenRed, 1);

        board.printGrid();



    }

//    @Test
//    public void hasLinie(){
//
//
//
//    }
}
