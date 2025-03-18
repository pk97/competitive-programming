package daily.challenge.backtracking;

import java.util.ArrayList;

public class RatMaze {
    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {1,0,0,0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ArrayList<String> s = new Solution().findPath(maze);
        s.stream().forEach(System.out::println);

    }
}


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        boolean[][] vis = new boolean[mat.length][mat.length];
        ArrayList<String> ans = new ArrayList<>();
               //     solve(mat, 0,0, vis, ans, "");
        return ans;

    }

}
