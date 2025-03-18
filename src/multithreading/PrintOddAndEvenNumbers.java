package multithreading;

public class PrintOddAndEvenNumbers {
      int counter =1;
      int max = 20;

      void printOdd() {
         while (counter < max) {
            if (counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
             System.out.println(counter++);
            notify();
         }
     }


    void printEven() {
        while (counter < max) {
            if (counter % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(counter++);
            notify();
        }
    }
}

class Trial {
    public static void main(String[] args) {
        PrintOddAndEvenNumbers p = new PrintOddAndEvenNumbers();
    }
}

// 3411, 3412, 3413, 3414