package daily.challenge.arrays;

import java.util.HashMap;

public class LongestSubarrayForSizeK {

    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int st = 0,  end=0, ans=0;
        long sum=0;
        while(  end < a.length) {
            while(sum < k && end < a.length) {
                end++;
                if (end < a.length) sum = sum +a[end];
            }
            while(sum == k && end < a.length) {
                ans = Math.max(ans, end-st +1);
                end++;
                if (end < a.length) sum = sum +a[end];

            }
            if(sum > k) {
                sum -= a[st];
                st++;
            }
        }
        return ans;
    }

    public static int getLongestSubarray(int []nums, int k) {
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,0);
        int ps = 0;
        int ans=0;
        for(int i=0;i< nums.length;i++) {
            ps += nums[i];
            if (!map.containsKey(ps)) {
                map.put(ps, i+1);
            }
            if (map.containsKey(ps -k)) {
                ans = Math.max(ans, i - map.get(ps -k));
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int k = longestSubarrayWithSumK(new int[] {1, 2, 1, 3}, 2);

        System.out.println(k);
    }
}
