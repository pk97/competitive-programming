package daily.challenge.graph;

import java.util.*;

public class TopologicalSort {

    static void dfs(Stack<Integer> stack, int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i) {
        visited[i] = true;
        for (Integer n : adj.get(i)) {
            if (!visited[n])
                dfs(stack, V, adj, visited, n);
        }
        stack.push(i);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                    dfs(stack, V, adj, visited, i);
        }

        int[] ans = new int[V];
        int k=0;
        while (!stack.isEmpty()) {
            ans[k++] = stack.pop();
        }
        return  ans;
    }
//Kahn algorithm
    public static int[] bfsTopoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[]  ans  = new int[V];
        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];
        for (int i=0;i< adj.size();i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                visited[i]=true;
            }
        }
        int k=0;
        while (!q.isEmpty()) {
            int e = q.poll();
            ans[k++]=e;
            for (Integer n : adj.get(e)) {
                if (!visited[n]) {
                    visited[n] = true;
                    indegree[n]--;
                    if (indegree[n] == 0) q.add(n);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);



        int[] ans = topoSort(V, adj);
        int[] ansL = bfsTopoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
        for (int node : ansL) {
            System.out.print(node + " ");
        }
    }
    }
