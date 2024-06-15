package multithreading;

import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {

        Thread t = new Thread(() -> {System.out.println("hi");} );
        Thread t2 = new Apple();
        t.start();

        List<Integer> l1 = new ArrayList<>();
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
