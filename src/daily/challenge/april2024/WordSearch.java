package daily.challenge.april2024;

import java.util.Stack;

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

    public String makeGood(String s) {

        Stack<Character> st = new Stack<>();

        for (char x : s.toCharArray()) {
            if (!st.isEmpty() && Math.abs(st.peek() - x) == 32)  {
                st.pop();
            }
            else {
                st.add(x);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Character c : st) {
            sb.append(c);
        }
        return sb.toString();

    }

    public String minRemoveToMakeValid(String s) {
        if (s.isEmpty()) return s;
        Stack<Integer> st = new Stack<>();
        char[] c = s.toCharArray();
        for(int i=0;i< c.length;i++) {
            if (c[i] == '(') {
                st.push(i);
            }
            else if (c[i] == ')') {
                if (st.isEmpty()) {
                    st.push(i);
                }
                else {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        while(!st.isEmpty()) {
            int i = st.pop();
            sb.delete(i,i+1);
        }
        return sb.toString();
    }
    }

