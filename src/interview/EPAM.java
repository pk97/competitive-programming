package interview;


import java.util.Arrays;
import java.util.List;

public class EPAM {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(4,2,3,1,10,28,7,11);
        int n  = 18;
        // a + b +c = 18

        for (int i=0; i < array.size();i++) {
            int a = array.get(i);
            for(int j=i+1;j< array.size();j++) {
                int b = array.get(j);
                for (int k = j+1; k < array.size(); k++) {
                    if (a + b + array.get(k) == n) {
                        System.out.println("TRUE");
                        System.out.println("Elements are "+a+","+b+","+array.get(k));
                        return;
                    }
                }
            }
        }


    }
}
