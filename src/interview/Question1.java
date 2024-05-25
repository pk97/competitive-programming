package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        bs(new int[]{2,4,6}, 2, 2)
                .forEach(System.out::println);
    }

    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(nums[0]);

        for(int i=1;i< nums.length;i++) {
            dp.add(new ArrayList<>());
            List<Integer> bs = dp.get(i-1);
            List<Integer> ans = new ArrayList<>(bs);
            boolean flag =true;

                for( Integer x: bs) {
                    if (Math.abs(x-nums[i]) == k ) {
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    ans.add(nums[i]);
                }
                dp.get(i).addAll(bs);
                dp.get(i).add(nums[k]);
        }

        dp.stream()
                .forEach(x -> x.stream()
                        .forEach(y -> System.out.println(y + ",")));

        return dp.size();
    }

    public static List<List<Integer>> bs(int[] nums, int k, int idx) {
        List<Integer> ans = new ArrayList<>();
        if (idx == 0) {
            ans.add(nums[0]);
            List<List<Integer>> p = new ArrayList<>();
            p.add(ans);
            return p;
        }
        else {
            List<List<Integer>> x = bs(nums, k, idx-1);
            List<List<Integer>> newBS = new ArrayList<>(x);

            for(List<Integer> y : x) {
                boolean flag=true;
                for(Integer z: y) {
                    if (Math.abs(z-k) == 2)
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    List<Integer> z2 = new ArrayList<>(y);
                    z2.add(nums[k]);
                    newBS.add(z2);
                }
            }
            newBS.add(Arrays.asList(nums[k]));
            return newBS;
        }
    }
}
