package javaConcurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class MapsImp {

    public static void main(String[] args) {
        Map<String, Integer> mp = Collections.synchronizedMap(new HashMap<>());
        Map<String, Integer> mp2 = new ConcurrentHashMap<>();
        ExecutorService exc = Executors.newFixedThreadPool(10);

        Future<String> submit = exc.submit(() -> "123");


        mp.put("1",1);
        mp.put("2",2);
        mp.put("3",3);
        mp.put("4",4);
        mp.put("5",5);

        mp2.put("1",1);
        mp2.put("2",2);
        mp2.put("3",3);
        mp2.put("4",4);
        mp2.put("5",5);
        new Thread( new ThreadRunner(mp)).start();
        new Thread( new ThreadRunner(mp2)).start();

        for (Map.Entry<String, Integer> x : mp2.entrySet()) {
            System.out.println(x.getKey() + x.getValue());
        }
        synchronized (mp) {
            for (Map.Entry<String, Integer> x : mp.entrySet()) {
                System.out.println(x.getKey() + x.getValue());
            }
        }

    }
}


class ThreadRunner implements Runnable {
    private final Map<String, Integer> mp;
    ThreadRunner( Map<String, Integer> mp) {
        this.mp = mp;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            mp.put(String.valueOf(i),i);
        }
    }
}
