package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KnapSackProblem {

    static int helper(int[] wt, int[] val, int K, int idx) {
        if (idx == -1)  return 0;
        if (wt[idx] <= K) {
            return Math.max(helper(wt, val, K, idx-1), val[idx] + helper(wt, val, K - wt[idx], idx-1));
        }
        return helper(wt, val, K, idx-1);
    }

    static int solveUsingTabulationDP(int[] wt, int[] val, int K) {
        int[] pre = new int[K+1];
        int[] cur = new int[K+1];

        for(int i=0;i<=K;i++)
            pre[i] = 0;

        for(int i=1;i<=wt.length;i++) {
            for(int j=1;j<=K;j++) {
                if (j>= wt[i-1]) {
                    cur[j]= Math.max(pre[j], val[i-1] + pre[j-wt[i-1]]);
                }
                else
                    cur[j] = pre[j];
            }
            pre=cur;
        }

        return pre[K];
    }

    static int solveUsingTabulation1DP(int[] wt, int[] val, int K) {
        int[] pre = new int[K+1];
//
//        for(int i=0;i<=K;i++)
//            pre[i] = 0;

        for(int i=1;i<=wt.length;i++) {
            for(int j=K;j>=wt[0]; j--) {
                if (j>= wt[i-1]) {
                    pre[j]= Math.max(pre[j], val[i-1] + pre[j-wt[i-1]]);
                }
            }
        }

        return pre[K];
    }


    public static void main(String[] args) {

        int x = solveUsingTabulation1DP(new int[]{5, 4, 6, 3}, new int[] {10, 40, 30, 50}, 5);
        System.out.println(x);
    }
}
