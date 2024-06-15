package interview.blackrock;

public class ArrayList<T> {
    private Object[] arr;
    private int capacity;
    private int size;

    ArrayList(int capacity) {
        // if (capacity == 10)
//            capacity = 10;
//        }
        this.capacity = capacity;
        arr = new Object[this.capacity];
        size = -1;
    }
    public int getSize() {
        return size;
    }
    public void add(int x) {
        if (capacity == size) {
            capacity =arr.length *2;
            Object[] newArr = new Object[capacity];
            for (int i=0;i<arr.length;i++) {
                newArr[i] = arr[i];
            }
            newArr[++size]= x;
            arr = newArr;
        }
        else {
            arr[++size] = x;
        }
    }

    public T get(int idx) {
        return arr[idx] as T;
    }
}
