package daily.challenge.pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MapInDecreasingOrder {

    public static void ans(String[]  s) {
        Map<String, Integer> map  =new HashMap<>();

        for (String x: s) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue());

        for ( Map.Entry<String, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        q.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ans(new String[] {"A", "B", "A", "B", "C", "A"});
    }
}
