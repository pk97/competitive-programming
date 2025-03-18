package daily.challenge.backtracking;

public class MaxNumberAfterAtmostKswaps {

//    //Function to find the largest number after k swaps.
//    public static String findMaximumNum(String str, int k)
//    {
//        //code here.
//        int max = Integer.parseInt(str);
//        f(str, k, max,0);
//        return String.valueOf(max);
//    }
//
//    static void f(String s, int swap, int max, int idx) {
//        if (swap == 0) {
//            max = Math.max(max, Integer.parseInt(s));
//            return;
//        }
//        for(int i=idx;i<s.length(); i++) {
//            if (i !=idx) swap--;
//            swap(s, i,idx);
//            f(s, swap,max,i+1);
//            swap(s,i,idx);
//            if (i !=idx) swap++;
//        }
//    }
//
//    static void swap(String s, int i, int j) {
//        StringBuilder x = new StringBuilder(s);
//        char a = x.charAt(i);
//        x.setCharAt(i, x.charAt(j));
//        x.setCharAt(j, a);
//        return x.toString();
//    }
}
