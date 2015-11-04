package connect4;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Connect4Mock {

    @Mock
    Connect4 connect4;

    @Test
    public void ShouldReturnATokenMock() {

        when(connect4.initGame()).thenReturn(new Token(Token.Color.BLUE, 1));

        Token token = connect4.initGame();
        assertNotNull(token);

    }


//    @Test
//    public void ShouldADraw() throws Exception {
//
//        //Not working because Mockito can not mock final Class
//          Alternativ Spring für Scanner benutzen
//
//        Referee refereeMock = mock(Referee.class);
//        Scanner scannerMock = mock(Scanner.class);
//
//        when(connect4.getReferee()).thenReturn(refereeMock);
//        when(connect4.getScanner()).thenReturn(scannerMock);
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