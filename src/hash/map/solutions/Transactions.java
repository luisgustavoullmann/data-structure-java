package hash.map.solutions;

import java.util.*;

// https://leetcode.com/problems/invalid-transactions/submissions/1601961917/
public class Transactions {
    // O(n*n) - O(n²) - with List
    // O(n) - Map
    public static List<String> invalidTransactions(String[] transactions) {
        class Transaction {
            String name;
            int time;
            int money;
            String city;
            String csv;

            public Transaction(String csv) {
                String[] parts = csv.split(",");
                name = parts[0];
                time = Integer.parseInt(parts[1]);
                money = Integer.parseInt(parts[2]);
                city = parts[3];
                this.csv = csv;
            }
        }

        Map<String, List<Transaction>> map = new HashMap<>();
        List<Transaction> allTransactions = new ArrayList<>();

        List<String> result = new ArrayList<>();

        for (String s : transactions) {
            Transaction t = new Transaction(s);
            allTransactions.add(t);

            if (map.containsKey(t.name)) {
                map.get(t.name).add(t);
            } else map.put(t.name, new ArrayList<>(List.of(t)));
        }

        for (Transaction t : allTransactions) {
            if (t.money > 1000) result.add(t.csv);
            else {
                for (Transaction t2 : map.get(t.name)) {
                    if (Math.abs(t.time - t2.time) <= 60 && !t.city.equals(t2.city)) {
                        result.add(t.csv);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,100,beijing" }));
        System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,1200,mtv" }));
        System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "bob,50,1200,mtv" }));
    }
}
