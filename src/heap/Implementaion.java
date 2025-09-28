package heap;

import java.util.Arrays;

public class Implementaion {

    public static void main(String[] args) {
        int[] heap = new int[10];
        Arrays.fill(heap,-1);
        int[] in = new int[]{101,5,4,12,41,21,4};

        for (int i=0;i<in.length;i++) {
            heap[i] = in[i];
        }
        int mid = (in.length/2) -1;

        for(int i= mid;i>=0;i--) {
            heapify(heap, i);
        }

        for (int i = 0; i < in.length; i++) {
            System.out.print(heap[i] +"->");
        }
       // Arrays.stream(heap).forEach(x -> System.out.print(x + "->"));

    }

    static void heapify(int[] arr, int i) {
        if (i*2+1 >= arr.length) return;
        if (arr[i] > arr[i+2+1]) {
            int t = arr[i];
            arr[i] = arr[i*2+1];
            arr[i*2+1] = t;
            heapify(arr,i*2+1);
        }
        if (arr[i] > arr[i*2 +2]) {
            int t = arr[i];
            arr[i] = arr[i*2+2];
            arr[i*2+2] = t;
            heapify(arr,i*2+2);
        }
    }

}
