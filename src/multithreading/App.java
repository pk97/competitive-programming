package multithreading;

import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {

        Thread t = new Thread(() -> {System.out.println("hi");} );
        Thread t2 = new Apple();
        Thread t3 = Thread.startVirtualThread(new Apple2());
        t.start();

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
