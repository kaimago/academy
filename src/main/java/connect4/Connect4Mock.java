package connect4;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Connect4Mock {

    @Mock
    Connect4 connect4;

    @Test
    public void ShouldReturnATokenMock() {

        Mockito.when(connect4.initGame()).thenReturn(new Token(Token.Color.BLUE, 1));

        Token token = connect4.initGame();
        Assert.assertNotNull(token);

    }


//    @Test
//    public void ShouldADraw() throws Exception {
//
//        //Not working because Mockito can not mock final Class
//
//        Referee refereeMock = Mockito.mock(Referee.class);
//        Scanner scannerMock = Mockito.mock(Scanner.class);
//
//        Mockito.when(connect4.getReferee()).thenReturn(refereeMock);
//        Mockito.when(connect4.getScanner()).thenReturn(scannerMock);
//
//
//        Mockito.stub(scannerMock.nextLine()).toReturn("1");
//
//        Mockito.stub(refereeMock.isDraw(null)).toReturn(true);
//        Token token = connect4.initGame();
//
//        Assert.assertNotNull(token);
//
//    }
}