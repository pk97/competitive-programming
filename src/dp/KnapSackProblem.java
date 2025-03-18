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
            for(int j=K;j>=0; j--) {
                if (j>= wt[i-1]) {
                    pre[j]= Math.max(pre[j], val[i-1] + pre[j-wt[i-1]]);
                }
            }
        }

        return pre[K];
    }
// for every weight w[i], either you select or don't select. You can only select if Knapsack K >= w[i],
    // take the maximum of both options
   // problem is base case in the end, try to put base case in the start, i.e i== 0 so it will help in developing tabulation logic.
    static int f(int w[], int p[], int K, int i, int[][] dp) {
        if (i == w.length) return 0;
        if (dp[K][i] == -1) {
            if (K >= w[i])
                return Math.max(f(w, p, K - w[i], i + 1,dp) + p[i], f(w, p, K, i + 1,dp));
            return f(w, p, K, i + 1,dp);
        }
        return dp[K][i];
    }

    static int simpleRecursion(int w[], int p[], int K) {
        int[][] dp = new int[K+1][w.length];
        for (int[] x : dp)
            Arrays.fill(x,-1);
        return f(w,p,K,0,dp);
    }

/*
*
*  I was not able to make sense of any of this code for 1 month Hence writing these comments down.
*  Given a set of items of weight W[] and their prices P[], find the maximum items which can be kept in knapSack of size K.
 */
    public static void main(String[] args) {

        int x = solveUsingTabulation1DP(new int[]{5, 4, 6, 3}, new int[] {10, 40, 30, 50}, 5);
        int y = simpleRecursion(new int[]{5, 4, 6, 3}, new int[] {10, 40, 30, 50}, 5);
        System.out.println(x+","+y);
    }
}
