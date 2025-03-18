package daily.challenge.backtracking;

import java.util.ArrayList;

public class Trial {

    public static void main(String[] args) {
        increasingNumbers(2).stream().forEach(System.out::println);
    }
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> ans  = new ArrayList<>();
        if ( n == 1) {
            for (int i = 0; i < 10; i++) {
            ans.add(i);
            }
        }
        else
            f(ans,new int[n], 0, n);
        return ans;
    }

    static void f(ArrayList<Integer> ans,int[] s, int idx, int n) {
        if (idx == n) {
            int p=0;
            for(int x : s) {
                p = p*10 +x;
            }
            ans.add(p);
            return;
        }
        for (int i = 1; i <= 9 ; i++) {
            if (idx == 0 || s[idx-1] < i) {
                s[idx] = i;
                f(ans,s,idx+1,n);
                //s[idx]=0;
            }
        }
    }
}

