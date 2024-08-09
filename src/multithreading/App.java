package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {


    public static void main(String[] args) {

        Thread t = new Thread(() -> {System.out.println("hi");} );
        Thread t2 = new Apple();
        Thread t3 = Thread.startVirtualThread(new Apple2());
        List<Integer> x = new ArrayList<>(Arrays.asList(1,2,5,4,5,6,12,4));
        Thread t1 = new Thread(() ->  {
            try {
                for (int i = 0; i < 10000; i++) {
                    x.add(i,10000);
                    System.out.println("thread1");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getLocalizedMessage());
            }
        } );

        Thread t21 = new Thread(() ->  {
            for (Integer integer : x) {
                System.out.println(integer);
            }
        } );
        t21.start();
        t1.start();

    }
}
class Apple extends Thread {
    @Override
    public void run() {
        super.run();
    }

    Apple() {
        super();
    }
}

class Apple2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("");

        }
    }
}
