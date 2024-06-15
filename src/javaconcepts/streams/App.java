package javaconcepts.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class App {
    public static void main(String[] args) {
        Trader t1 = new Trader("A","Delhi");
        Trader t2 = new Trader("B","Mumbai");
        Trader t3 = new Trader("C","Delhi");
        Trader t4 = new Trader("D","Delhi");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(t1, 2011, 300),
                new Transaction(t1, 2011, 300),
                new Transaction(t2, 2011, 600),
                new Transaction(t3, 2012, 500),
                new Transaction(t4, 2012, 300),
                new Transaction(t4, 2011, 8000)
        );
        // All transcation in year 2011 & sort them by value ascending

        transactions.stream()
                .filter(t ->t.getYear() == 2011)
                .sorted((a,b) -> a.getValue()- b.getValue())
                .forEach(System.out::println);

        // All unique cuties of traders

        transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // All traders from Delhi in alphabetic order

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Delhi"))
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);

        // A string of All traders od Delhi

        String ans = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .reduce("", (a, b) -> a+ " " +b );

        System.out.println(ans);

        // highest transaction
        int x = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.comparingInt(x1 -> x1))
                .orElse(0);

        System.out.println(x);

        // count transactions
       Long c = transactions.stream()
                .collect(Collectors.counting());

        System.out.println("total transactions count "+c);

       Transaction x3 = transactions.stream()
               .max(Comparator.comparingInt(Transaction::getValue))
                       .orElse(null);

       System.out.println(x3.getValue());

      transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        int totalTransactions = transactions.stream().map(Transaction::getValue).reduce(0, (a, b) -> a.intValue() + b.intValue());

        Map<Integer, List<Transaction>> map = transactions
                .stream()
                .collect(groupingBy(Transaction::getYear));

        map.forEach((key,value) -> System.out.println(key+","+value));

        List<Integer> arr  = Arrays.asList(1,2,1,1,2,4);

        Map<Integer, List<Integer>> map2 = arr.stream().collect(groupingBy(Integer::intValue));

    }
}
