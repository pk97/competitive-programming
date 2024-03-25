import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int i=0, ans=0;
        while (i < a.length) {
            int sum =0;
            int j=0;
            for( j=i;j< a.length;j++) {
                sum += a[j];
                if (sum >= k) break;
            }
            System.out.println( j-i+1);
            if (k == sum) ans = Math.max(ans, j-i+1);
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        longestSubarrayWithSumK(new int[]{1, 2, 3, 1, 1, 1, 1}, 3);

    }

}
