package daily.challenge.april2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximusBinaryTree {
    
       static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int max=0;
        for(int i=0;i<nums.length;i++) {
            if (nums[max] < nums[i]) {
                max= i;
            }
        }
        TreeNode tr = new TreeNode(nums[max]);
        int[] pre = new int[max];
        int[] pos = new int[nums.length -1 - max];
        for(int i=0;i<max;i++)
            pre[i] = nums[i];
        for(int i=max+1;i< nums.length;i++)
            pos[i-max-1] = nums[i];
        System.out.println(max);
        tr.left =  constructMaximumBinaryTree(pre);
        tr.right = constructMaximumBinaryTree(pos);

        return tr;
    }

    static TreeNode  construct(int[] nums, int l, int r) {
        if (r <= l) return null;
        int maxI = maxIndex(nums,l,r);
        TreeNode tr = new TreeNode(nums[maxI]);
        tr.left = construct(nums,l,maxI-1);
        tr.right = construct(nums, maxI+1, r);

        return tr;
    }


    static int maxIndex(int[] nums, int l, int r) {
        int max = l;
        for(int i=l;i<=r;i++)
        {
            if (nums[max] < nums[i])
                max = i;
        }
        return max;
    }

    int bfs(int root, List<List<Integer>> adj, int n) {
        Queue<Integer> q = new LinkedList();
        boolean[] visited = new boolean[n];
        q.add(root);
        visited[root]=true;
        int height=0;
        while (!q.isEmpty()) {
            int size = q.size();
            height++;
            for(int i=0;i<size;i++) {
                int x = q.poll();
                for(Integer child : adj.get(x)) {
                    if (!visited[child]) {
                        visited[child]=true;
                        q.add(child);
                    }
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        //constructMaximumBinaryTree(new int []{3,2,1,6,0,5});
        construct(new int []{3,2,1,6,0,5}, 0 ,5);

        int[] arr = new int[] {1,2,3,4};
        String s = "dfdisplay";
        Arrays.stream(arr)
                .forEach((x) -> System.out.println(s + x));
        s ="adsad";
        Runnable r = () -> {
            System.out.println(s);
        };
//        s = "as213d";
        r.run();
//        s ="asdds";
    }
}
