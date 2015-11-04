import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        final ArrayList<Card> cards = new ArrayList<Card>();
        for (Card.suit s : EnumSet.allOf(Card.suit.class)) {
            for (Card.values v : EnumSet.allOf(Card.values.class)) {
                cards.add(new Card(s, v));
            }
        }

        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));

        final ArrayList<Card> currentList = new ArrayList<Card>();
        currentList.add(cards.get(0));
        currentList.add(cards.get(1));
        currentList.add(cards.get(2));
        currentList.add(cards.get(3));
        currentList.add(cards.get(4));

        if (checkForSameValue(currentList, 2)){
            System.out.println("You have a pair");
        }

        if (checkForSameValue(currentList, 3)){
            System.out.println("You have a three of a kind");

            if (checkForSameValue(currentList, 2)){
                System.out.println("You have a fullhouse");
            }
        }

        if (checkForSameValue(currentList, 4)){
            System.out.println("You have a four of a kind");
        }

    }

    public static boolean checkForSameValue(List<Card> list, int aCounter){
        for (Card card :list) {

            final Card.values currentValue = card.getV();

            int counter = 0;

            for (Card card2 :list) {

                if (card2.getV().equals(currentValue)) {
                    counter++;
                }

            }
            if (counter == aCounter){
                return true;
            }

        }
        return false;
    }



}
