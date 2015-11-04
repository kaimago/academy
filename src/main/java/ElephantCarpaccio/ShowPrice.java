package ElephantCarpaccio;

import java.util.HashMap;
import java.util.Scanner;

public class ShowPrice {


    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("What is the price of your ?");

        String singlePrice;
         int singlePriceInteger = 0;
        String items;
        int itemsInteger = 0;
        String statecode;

         HashMap<String, Float> taxRates = new HashMap<String, Float>();
        taxRates.put("UT", 0.0685f);
        taxRates.put("NV", 0.08f);
        taxRates.put("TX", 0.0625f);
        taxRates.put("AL", 0.04f);
        taxRates.put("CA", 0.0825f);


        //while (scanner.hasNextLine()) {
            singlePrice = scanner.nextLine();
        //}
        try {

            singlePriceInteger = Integer.parseInt(singlePrice);

        } catch (NumberFormatException e){

            System.out.println("The price have to be number !!");
        }

        System.out.println("How many items you want ?");

        items = scanner.nextLine();

        System.out.println("Enter your statecode?");

        statecode = scanner.nextLine();

        try {

            itemsInteger = Integer.parseInt(items);

        } catch (NumberFormatException e){

            System.out.println("The price have to be number !!");
        }


         float totalprice = singlePriceInteger * itemsInteger;

        if (totalprice >= 50000) {
            System.out.println("You get " + 0.15f*100 + "% discount !");
            totalprice = totalprice - (totalprice * 0.15f);
        }else if (totalprice >= 10000) {
            System.out.println("You get " + 0.10f * 100 + "% discount !");
            totalprice = totalprice - (totalprice * 0.10f);
        }   else if (totalprice >= 7000) {
                System.out.println("You get " + 0.07f*100 + "% discount !");
                totalprice = totalprice - (totalprice * 0.07f);

        } else if (totalprice >= 5000) {
            System.out.println("You get " + 0.05f*100 + "% discount !");
            totalprice = totalprice - (totalprice * 0.05f);

        }else if (totalprice >= 1000) {
            System.out.println("You get " + 0.03f*100 + "% discount !");
            totalprice = totalprice - (totalprice * 0.03f);

        }

        if (!taxRates.containsKey(statecode)){
            System.out.println("Statecode is not supported");
        } else {

        final Float taxRateForStateCode = taxRates.get(statecode);

        totalprice = totalprice + (totalprice * taxRateForStateCode);


        System.out.println("Your total price is " + totalprice + " Euro  (Taxrate included (" + taxRateForStateCode*100 + "% " +
                "for "+ statecode + ")");
        }

    }
}
