package javaConcurrency;

@ThreadSafe
public class Sequence {
        private int nextvalue;

    public synchronized int getNext() {
        return nextvalue++;
    }

}
