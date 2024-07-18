package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deloitte {

    public static void main(String[] args) {
        List<Integer> listA =  new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        listA.add(2);
        listA.add(8);
        listA.add(12);
        listA.add(18);

        listB.add(11);
        listB.add(15);
        listB.add(19);
        mergeArrays(listA, listB);
//        for (Integer a: listA) {
//            System.out.println(a);
//        }

    }

    static void  mergeArrays(List<Integer> a, List<Integer> b) {
        for (int k = 0; k < a.size(); k++) {
            if (a.get(k) > b.getFirst()) {
                int t = a.get(k);
                a.set(k, b.getFirst());
                b.set(0, t);
            }
        }
        a.addAll(b);
        for (Integer x: a) {
            System.out.println(x);
        }
    }
}
// -> [Button]
// library Components
// microFe1,
// //2,
// //3
// ,4  ->
