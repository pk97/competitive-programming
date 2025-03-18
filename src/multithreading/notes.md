# Notes

- In Java, a thread can be created using extedning a Thread class and Runnable interface.
- Each method to create a thread has it's on advance.

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("hellow knakdsdsa ");
    }
}

class Driver {
    public static void main(String[] args) {
        new MyThread().start();
        Thread t = new MyRunnable();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("running");
    }
}

    Thread t = new Thread() {
    };

    Runnable r = new Runnable() {
        @Override
        public void run() {
            
        }
    };

    Runnable r  = () -> System.out.println("asdsad");
    
    Thread t = new Thread(r);
    t.start();

```


##IMP difference between run and start

- Always remeber to call start method but implement run method. Start method start another thread 
- and it will call the run method as soon as the CPU is empty. Calling run method directly will not create a new Thread.

- Join()
```java
class Driver {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Index: " + i);
            }
        };
        
        Thread vthread = Thread.ofVirtual().start(runnable);
        
        vthread.join();
    }
}
```

Above code created a virtual thread. With start method a new thread will execute the runnable code
But, the main thread will obviosuly terminate. To  make it wait for the the child thread we use join.

immutable class

```java
class Imutable {
    private int x;
    
    get x() {
        return x;
    }
    Imutable(int x) {
        this.x = x;
    }
    
}
```

To add a number, we can create it as follow

new Immmutable(old.getX() + 2);

```java

class Calculator {
    Immutable i;
    
    Immutable getValue() {
        return i;
    }
    public void setValue(Immutable newValue) {
        this.i = newValue;
    }
}
```
Even though Immutable is thread safe but Calculator class is not because of race condition in seValue method.
It can result in different answers. thus use synchronize keyword to make it thread safe.

### Java Memory Model

![img.png](img.png)

Internally Java Memory Model consists of Thread stacks and heap. Each thread in execution has a 
different stack space where it maintain function calls, i.e call stack. Call stack has all the local variables.
If local variable is primitive then it is declared in stack only. Local varibles can contain reference of Objects. All objects,
Integer, custom object are declared in heap. Static class methods are also in heap. an objects's member variables are also present in heap only.

![img_1.png](img_1.png)

Hardware memory model.

There might be a chance that an object present in heap is read from the RAM by 2 threads and each 
update in it's CPU's cache resulting in race condition. Thus to avoid it.

1. Synchronize keyword. - one thread at a time 
2. Volatile keyword. - reads from RAM directly and stores in RAM, not just CPU cache.



```java


public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            PoolThreadRunnable poolThreadRunnable =
                    new PoolThreadRunnable(taskQueue);

            runnables.add(poolThreadRunnable);
        }
        for(PoolThreadRunnable runnable : runnables){
            new Thread(runnable).start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.offer(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable : runnables){
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while(this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

```

