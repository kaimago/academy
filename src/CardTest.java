import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test...
 * 123
 * 123
 * avc
 * mybranch Change
 * 234
 */
public class CardTest {

    @Test
    public void testCheckForSameValue() throws Exception {

        final ArrayList<Card> currentList = new ArrayList<Card>();

        final Card cardAce = new Card(Card.suit.SPADES, Card.values.ACE);
        currentList.add(cardAce);
        currentList.add(cardAce);
        currentList.add(cardAce);
        currentList.add(cardAce);
//        currentList.add(cardAce);

        Assert.assertTrue(Main.checkForSameValue(currentList, 4));
        Assert.assertFalse(Main.checkForSameValue(currentList, 3));
        Assert.assertFalse(Main.checkForSameValue(currentList, 2));

    }

    @Test
    public void testCheckForDouble() throws Exception {

        final ArrayList<Card> currentList = new ArrayList<Card>();

        currentList.add(new Card(Card.suit.SPADES, Card.values.ACE));
        currentList.add(new Card(Card.suit.SPADES, Card.values.ACE));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));
        currentList.add(new Card(Card.suit.SPADES, Card.values.FOUR));

        Assert.assertFalse(Main.checkForSameValue(currentList, 4));
        Assert.assertFalse(Main.checkForSameValue(currentList, 3));
        Assert.assertTrue(Main.checkForSameValue(currentList, 2));

    }

    @Test
    public void testCheckForFullHouse() throws Exception {

        final ArrayList<Card> currentList = new ArrayList<Card>();

        currentList.add(new Card(Card.suit.SPADES, Card.values.ACE));
        currentList.add(new Card(Card.suit.SPADES, Card.values.ACE));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));

        Assert.assertFalse(Main.checkForSameValue(currentList, 4));
        Assert.assertTrue(Main.checkForSameValue(currentList, 3));
        Assert.assertTrue(Main.checkForSameValue(currentList, 2));

    }


    @Test
    public void testCheckForPairPair() throws Exception {

        final ArrayList<Card> currentList = new ArrayList<Card>();

        currentList.add(new Card(Card.suit.SPADES, Card.values.ACE));
        currentList.add(new Card(Card.suit.SPADES, Card.values.ACE));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));
        currentList.add(new Card(Card.suit.SPADES, Card.values.EIGHT));
        currentList.add(new Card(Card.suit.SPADES, Card.values.FOUR));

        Assert.assertFalse(Main.checkForSameValue(currentList, 4));
        Assert.assertFalse(Main.checkForSameValue(currentList, 3));
        Assert.assertTrue(Main.checkForSameValue(currentList, 2));

    }

}