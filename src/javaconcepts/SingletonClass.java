package javaconcepts;

class Singleton1{
    private static Singleton1 instance = new Singleton1();

    private Singleton1(){
        //write your code here . . .
    }

    public static Singleton1 getInstance(){
        return instance;
    }
}


// thread safe initialization
 class Singleton{
    private static Singleton instance ;

    private Singleton(){
        //write your code here
    }

    //Note the synchronized keyword that makes this implementation thread safe
    public static synchronized Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}



//Double-Checked Locking Thread safe implementation
public class SingletonClass implements Cloneable {
    private static SingletonClass singletonClass;
    private SingletonClass() {
        if (singletonClass !=null)
            throw new RuntimeException("asdsad");
    };

    public static   SingletonClass getInstance() {
       if (singletonClass == null) {
           synchronized(SingletonClass.class) {
               if (singletonClass == null) {
                   singletonClass = new SingletonClass();
               }
           }
       }
       return singletonClass;
    }

    @Override
    public SingletonClass clone() {
        try {
            SingletonClass clone = (SingletonClass) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


class App {
    void display() {

        SingletonClass.getInstance();
    }
}


// https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/


