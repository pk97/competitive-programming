package daily.challenge.arrays;

import java.util.*;

public class LIS {
// [10,9,2,5,3,7,101,18]

    static void printSubsequence(int[] nums, int n, List<Integer> arr, List<List<Integer>> all) {
        if (n == -1) {
            all.add(new ArrayList<>(arr));
        } else {
            //take n
            arr.add(nums[n]);
            printSubsequence(nums, n - 1, arr, all);
            arr.removeLast();
            printSubsequence(nums, n - 1, arr, all);
        }
    }

    public static void getAllSubsequence(int[] nums) {
        int x = 1 <<nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            List<Integer> n = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                System.out.println(1<<j);
                // it represents the no. from 0 to 2^n-1 which tells which bits to consider.
                // j tells whether to consider that element or not
                if ((i& (1<<j)) != 0)
                    n.add(nums[j]);
            }
            ans.add(n);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        //lengthOfLIS(new int[] {0,1,0,3,2,3});
        List<List<Integer>> l = new ArrayList<>();
        System.out.println(1<<0);
        System.out.println(1<<1);
        System.out.println(1<<2);
        printSubsequence(new int[]{0,2}, 1, new ArrayList<>(), l);
        System.out.println(l);
        System.out.println(l.size());
        System.out.println("<<<<<<<<<");
        getAllSubsequence(new int[] {1,2,3});
        System.out.println("LIS from recursion");
        int ans = lis(new int[] {0,1,0,3,2,3}, 0, -1);
        System.out.println(ans);
        int[][] dp =new int[6][7];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // memoization
        System.out.println(solve(new int[] {0,1,0,3,2,3}, 0, -1, dp));
       // Tabulation rules
        //  1. Base case dp[N][0..N] = 0;
        // 2. Write loop in opposite direciton
        // 3. copy recurrence
        System.out.println(tab(new int[] {0,1,0,3,2,3}));
        System.out.println(tabSpaceOp(new int[] {0,1,0,3,2,3}));


    }
}