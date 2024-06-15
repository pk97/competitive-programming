package daily.challenge.graph;

import java.util.Arrays;

public class Bipartite {
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        boolean ans = true;
        for (int i=0;i<V;i++) {
            if (color[i] == -1) {
                ans = dfs(graph, i, 0, color);
            }
            Arrays.stream(color).forEach(System.out::println);
            if (ans == false) return ans;
        }
        return true;
    }

    static boolean dfs(int[][] graph, int v, int c, int[] color) {
        if (color[v] == -1) color[v] = c;
        for (int n : graph[v]) {
            if (color[n] == color[v])
                return false;
            else if (color[n] == -1) {
                color[n] = (color[v]+1)%2;
                System.out.println(color[n]);
                dfs(graph, n, c, color);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}