package daily.challenge.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i=0;i< nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            }
            else {
                Queue<Integer> l = new LinkedList<>();
                l.add(i);
                map.put(nums[i], l);
            }
        }

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey( target- nums[i]) && map.get(target-nums[i]).peek() != i) {
                System.out.println("yrd"+(target- nums[i]));
                ans[0]=i;
                Queue<Integer> x = map.get(target - nums[i]);
                ans[1]=x.peek();
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] x = twoSum(new int[]{3,2,4}, 6);
        Arrays.stream(x).forEach(System.out::println);
    }
}
