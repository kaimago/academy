package connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Connect4Test {

    Connect4 connect4;

    @Before
    public void setUp() {

        connect4 = new Connect4();

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
