package daily.challenge.arrays;

import java.util.*;

public class SubSetSum2 {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.subsetsWithDup(new int[]{1,2,2}).stream().forEach(System.out::print);
    }
}



class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans2 = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        f(ans, nums, 0, new ArrayList<>());
        ans2.addAll(ans);
        return ans2;
    }

    void f(Set<List<Integer>> ans, int[] nums, int idx, List<Integer> cur) {
       if (idx == nums.length) {
           ans.add(new ArrayList<>(cur));
           return;
       }
       cur.add(nums[idx]);
       f(ans, nums, idx+1, cur);
       cur.remove(cur.size()-1);
       f(ans, nums, idx+1, cur);
    }
}
