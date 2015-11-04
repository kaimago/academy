package connect4;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class RefereeTest {


    @Test
    public void mockTestReferee() {

        Referee mockReferee = Mockito.mock(Referee.class);
        Mockito.stub(mockReferee.isDraw(null)).toReturn(true);

        Assert.assertTrue(mockReferee.isDraw(null));

    }

    @Test
    public void ShouldTestIsConnect4HasNoDraw() throws Exception {

        Board board = new Board();
        board.addToken(new Token(Token.Color.BLUE, 0));

        Assert.assertFalse(new Referee().isDraw(board));

    }

    @Test
    public void ShouldTestIsConnect4HasADraw() throws Exception {

        Board board = new Board();

        for (int i = 0; i < 7; i++) {

            board.addToken(new Token(Token.Color.BLUE, i));
            board.addToken(new Token(Token.Color.BLUE, i));
            board.addToken(new Token(Token.Color.BLUE, i));
            board.addToken(new Token(Token.Color.BLUE, i));
            board.addToken(new Token(Token.Color.BLUE, i));
            board.addToken(new Token(Token.Color.BLUE, i));

        }

        Assert.assertTrue(new Referee().isDraw(board));

    }

}
