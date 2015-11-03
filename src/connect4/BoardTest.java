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
    public void ShouldGetSameColor() throws Exception {

        Token token = new Token(Token.Color.RED, 0);
        board.addToken(token);

        boolean hasTokenSameColor = board.hasTokenThisColor(Token.Color.RED, 0, 0);

        Assert.assertTrue(hasTokenSameColor);
    }


    @Test
    public void NewGridShouldBeEmpty() throws Exception {

        Token emptyToken = board.getGridToken(4,5);

        Assert.assertEquals(null, emptyToken);
    }

    @Test
    public void addTokenToNoneExistingGridPlusValue() throws Exception {

        Token newToken = new Token(Token.Color.BLUE, 10);

        Token tokenAdded;
        try {
            tokenAdded = board.addToken(newToken);
        } catch (ArrayIndexOutOfBoundsException e) {

            Assert.assertTrue(true);
            return;
        }

        Assert.assertNotNull(tokenAdded);

    }

    @Test
    public void addTokenToNoneExistingGridNegativeValue() throws Exception {

        Token newToken = new Token(Token.Color.BLUE, -1);

        Token tokenAdded;
        try {
            tokenAdded = board.addToken(newToken);
        } catch (ArrayIndexOutOfBoundsException e) {

            Assert.assertTrue(true);
            return;
        }

        Assert.assertNotNull(tokenAdded);

    }

    @Test
    public void ShouldAddTokenToGridColumn() throws Exception {

        Token newToken = new Token(Token.Color.BLUE, 0);

        Token tokenAdded = board.addToken(newToken);

        Assert.assertNotNull(tokenAdded);

        Token addedToken = board.getGridToken(0,0);

        org.junit.Assert.assertTrue(addedToken.equals(newToken));
        org.junit.Assert.assertFalse(addedToken.equals(new Token(Token.Color.BLUE, 0)));

    }

    @Test
    public void ShouldAddMoreTokenToOneColumnThanPossible() {

        Token newToken = new Token(Token.Color.BLUE, 0);

        try {

            board.addToken(newToken);
            board.addToken(newToken);
            board.addToken(newToken);
            board.addToken(newToken);
            board.addToken(newToken);
            board.addToken(newToken);
            board.addToken(newToken);
            board.addToken(newToken);

        } catch (Exception e) {
            Assert.assertTrue(true);
            return;
        }

        Assert.assertFalse(true);

    }


    public void printGrid() throws Exception {

        board.addToken(new Token(Token.Color.BLUE, 1));
        board.addToken(new Token(Token.Color.RED, 2));
        board.addToken(new Token(Token.Color.RED, 1));
        board.addToken(new Token(Token.Color.RED, 2));

        board.printGrid();
    }

}
