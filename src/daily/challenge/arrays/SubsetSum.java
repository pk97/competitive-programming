package daily.challenge.arrays;

public class SubsetSum {

    public static boolean f(int[] arr, int n, int k) {
        if (k == 0) return true;
        if (n < 0 || k < 0) return false;
        if (n == 0) return k == arr[n];
        return f(arr, n-1, k) || f(arr, n-1, k- arr[n]);
    }

    public static void main(String[] args) {
        int[][] dp = new int[5][5];
        System.out.println(f(new int[] {2 ,5 ,1, 6, 7}, 5-1, 4));
    }
}
