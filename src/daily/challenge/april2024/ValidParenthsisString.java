package daily.challenge.april2024;

import java.util.Stack;

public class ValidParenthsisString {

    public static boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int star=0;
        for(char x : s.toCharArray()) {
            if (x == '(') {
                st.push('(');
            }
            else if (x == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                }
                else if (star == 0) return false;
                else {
                    star--;
                }
            }
            else {
                star++;
            }
        }
        while( star > 0 && !st.isEmpty()) {
            st.pop();
            star--;
        }
        return st.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}

