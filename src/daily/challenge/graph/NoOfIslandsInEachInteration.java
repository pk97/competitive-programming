package daily.challenge.graph;



        import java.util.*;
        import java.lang.*;
        import java.io.*;


class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here]
        int[][] adj = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();
        for ( int[] o : operators) {
            adj[o[0]][o[1]] =1;
            int comp=0;
            boolean[][] visited = new boolean[rows][cols];
            for(int i=0;i< rows; i++) {
                for(int j=0;j< cols;j++) {
                    if (adj[i][j] == 1 && visited[i][j] == false) {
                        dfs(adj, i,j, visited);
                        comp++;
                    }
                }
                Arrays.stream(visited).forEach(x -> System.out.print(x[0]+ " "));
            }
            ans.add(comp);
        }
        return ans;
    }

    void dfs(int[][] adj, int x, int y, boolean[][] vis) {
        vis[x][y] = true;
        int[] dir = new int[] {-1,0,1,0,-1};

        for(int i=0;i<4;i++) {
            int nx = dir[i] +x;
            int ny = dir[i] + y;
            if (nx >=0 && ny >=0 && nx<adj.length
                    && ny<adj[0].length
                    && adj[nx][ny] == 1
                    && vis[nx][ny] == false)
            {
                dfs(adj,nx,ny,vis);
            }
        }

    }

}



class NoOfIslandsInEachInteration {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){

                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);

            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends