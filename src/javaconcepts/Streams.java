package javaconcepts;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        String s = "234324sadfdkjsfbdsjf";

        List<Integer> list = Arrays.asList(1,2,3,4,5,3,2);
        int sw = list.stream().filter(e -> e%2 ==0)
                .reduce(0, Integer::sum);

        System.out.println(list.stream()
                .mapToInt(Integer::intValue)
                .max());

        List<String> list2 = Arrays.asList("asd","asdasd", "asd");

       String ans =  list2.stream()
                .reduce("", (a,b) -> a+b);

        System.out.println(ans);
    }
}
