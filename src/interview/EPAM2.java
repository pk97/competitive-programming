package interview;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class EPAM2 {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        int[] x = frequencySort(new int[] {1,1,2,2,2,3} );
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

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return  b.getKey() - a.getKey();
            }
            else {
                return a.getValue() - b.getValue();
            }
        });
        pq.addAll(map.entrySet());
        int[] ans = new int[nums.length];
        int j=0;
      for (Map.Entry<Integer, Integer> x : pq) {
          int k = x.getKey();
          int v = x.getValue();
          while(k-- > 0) {
              ans[j++]=v;
          }
      }

        return ans;
    }
}
