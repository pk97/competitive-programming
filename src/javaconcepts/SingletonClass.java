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
public class SingletonClass {
    private static SingletonClass singletonClass;
    private SingletonClass() {
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

}


class App {
    void display() {

        SingletonClass.getInstance();
    }
}


