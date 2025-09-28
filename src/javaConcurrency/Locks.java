package javaConcurrency;


// print 1 to 10 using two threads java concurrency
public class Locks {

    private Object lock;

    private ThushreadLocal<String> x = ThreadLocal.withInitial(() -> "Hee");

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0)
                    System.out.println(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 1)
                    System.out.println(i);
            }
        });

        t1.start();
        t2.start();
    }
}

// daemon threads
