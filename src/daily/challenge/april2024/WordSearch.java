package daily.challenge.april2024;

public class WordSearch {

        public static boolean exist(char[][] board, String word) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];

                    if (dfs(word, board, i, j, 0, visited))
                        return true;
                }
            }
            return false;
        }


        private static boolean dfs(String word, char[][] board, int i, int j, int l, boolean[][] visited) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
            if (visited[i][j] || board[i][j] != word.charAt(l)) return false;
            if (word.length() - 1 == l) return true;

            visited[i][j] = true;

            int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

            for (int k=0;k<4;k++) {
                int idx = i+ dir[k][0];
                int idy = j+dir[k][1];
                if (dfs(word, board, idx,idy, l + 1, visited)) return true;
            }
            visited[i][j] = false;
            return false;
        }

        public static void main(String[] args) {
            boolean x = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");

            System.out.println(x);
        }
    }

