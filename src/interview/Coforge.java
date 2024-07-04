package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Coforge {

    static class Train {
        int arr;
        int dep;
        Train(int x, int y) {
            arr=x;
            dep=y;
        }
    }
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        List<Train> trains = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            trains.add(new Train(arr[i], dep[i]));
        }

        Collections.sort(trains, (a,b) -> a.arr - b.arr);

        PriorityQueue<Train> pq = new PriorityQueue<>((a,b) -> a.dep - b.dep);

        for (Train t : trains) {

            if (pq.isEmpty()) {
                pq.add(t);
                continue;
            }
            else if (pq.peek().dep < t.arr) {
                pq.poll();
            }
            pq.add(t);
        }
        return pq.size();

    }


    public static void main(String[] args) {
        int[] arr = new int[]{900, 1100, 1235};
        int[] dep = new int[] {1000, 1200, 1240};

        System.out.println(findPlatform(arr,dep,3));
    }
}

