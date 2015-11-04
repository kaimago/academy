package connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Connect4Test {

    Connect4 connect4;

    @Before
    public void setUp() {

        connect4 = new Connect4();

    }

    @Test
    public void ShouldFindAwaitingPlayer() {

        Player currentPlayer = connect4.findAwaitingPlayer();
        //Currentplayer init Value is Red
        Assert.assertEquals(Token.Color.RED, currentPlayer.getColor());

    }

    @Test
    public void ShouldFindOngoingPlayer() {

        Player currentPlayer = connect4.findOOngoingPlayer();
        //Currentplayer init Value is Red
        Assert.assertEquals(Token.Color.BLUE, currentPlayer.getColor());

    }

        @Test
    public void ShouldValidateInputOnlyOneComma() {

            boolean validateInput = connect4.validateInput("34534,34545");

            Assert.assertTrue(validateInput);

    }

    @Test
    public void ShouldValidateIfNameMatchingMock() {

        Connect4 connect4Mock = mock(Connect4.class);
        Player player = new Player(Token.Color.BLUE);
        player.setName("lanxi");
        when(connect4Mock.getPlayerBlue()).thenReturn(player);
        when(connect4Mock.validateInput(Mockito.anyString())).thenCallRealMethod();

        boolean validateInput = connect4Mock.validateInput("lanxi,34545");

        Assert.assertTrue(validateInput);

    }

    @Test
    public void testRoundWrongInput() {

        Token wrongValue = connect4.play(Token.Color.BLUE, "WrongValue");

        Assert.assertNull(wrongValue);



    }

    @Test
    public void CheckIfColumnNumberIsTooBig() {

        Token wrongValue = connect4.play(Token.Color.BLUE, "8");

        Assert.assertNull(wrongValue);

    }

    @Test
    public void CheckIfColumnNumberIsTooSmall() {

        Token wrongValue = connect4.play(Token.Color.BLUE, "0");

        Assert.assertNull(wrongValue);

    }

    @Test
    public void InputShouldBeValid() {

        Token correctValue = connect4.play(Token.Color.BLUE, "1");

        Assert.assertNotNull(correctValue);

    }


}
