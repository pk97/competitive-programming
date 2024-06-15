package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class EPAM2 {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("CSE", "RAM", 1000));
        transactions.add(new Transaction("CSE", "SHYAM", 2000));
        transactions.add(new Transaction("ECE", "ABC", 3000));
        transactions.add(new Transaction("CSE", "SHYAM", 2000));
        transactions.add(new Transaction("ECE", "SHYAM", 1000));
        transactions.add(new Transaction("EEE", "RAM", 1000));

        Map<String, List<Transaction>> mappedTransaction = transactions.stream()
                .collect(groupingBy(Transaction::getEmployeeName));

        Map<String, Integer> salaries = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        mappedTransaction.forEach(
                (key, value) -> {
                    Integer totalSalary = value.stream().map(Transaction::getSalary).reduce(0, Integer::sum);
                    System.out.println(key + "-" +totalSalary);
                    salaries.put(key, totalSalary);
                    list.add(totalSalary);
                }
        );
        // [1,15,24,99,12]
        salaries.forEach((key, value) -> {

        });

    }
}
