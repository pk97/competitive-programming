package daily.challenge.arrays;

import java.util.Arrays;

public class FindDuplicate {
    /*
    idx are from 0 to n-1
    values in array is from 1 to n.
    There is one to one mapping.
    every arr element contains a value between 1 to n and each of them are
    unique except one. Thus.

    1. Take the arr value.
    2. GO to that index and mark that value as negative, meaning that index is visted.
    3. If any value comes out to be negative, then it is indeed duplicate.
     */
    static int duplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i])-1;
            if (arr[idx] < 0) {
                return idx+1;
            }
            arr[idx] = -1 * arr[idx];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.duplicate(new int[] {1,3,4,2,2}));
    }
}
