package greedy;

import java.util.HashMap;
import java.util.Map;

public class Lemonade {

    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> myBills = new HashMap<>();
        myBills.put(5, 0);
        myBills.put(10, 0);
        myBills.put(20, 0);

        for (int bill : bills) {
            myBills.put(bill, myBills.get(bill) + 1);

            int change = bill - 5;

            int[] values = {20,10,5};
            for (int value : values) {
                while (change >= value && myBills.get(value) > 0) {
                    myBills.put(value, myBills.get(value) - 1);
                    change -= value;
                }
            }

            if (change > 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Caso 1
        if(lemonadeChange(new int[]{5, 5, 5, 10, 20}))
            System.out.println("Verdadeiro");
        else
            System.out.println("Falso");

        // Caso 2
        if(lemonadeChange(new int[]{5, 5, 10, 10, 20}))
            System.out.println("Verdadeiro");
        else
            System.out.println("Falso");
    }
}
