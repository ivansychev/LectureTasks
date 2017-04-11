package LockExample;

/**
 * Created by ivans on 07/04/2017.
 */
public class LockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            foo1();
        }
    });
    public Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            foo2();
        }
    });


    public void foo1()
    {
        synchronized (lock1)
        {
            System.out.println("In Lock 1!!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting for thread2");
            foo2();
            System.out.println("Done waiting for thread2");
        }
    }
    public void foo2()
    {
        synchronized (lock2)
        {
            System.out.println("In Lock 2!!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting for thread1");
            foo1();
            System.out.println("Done waiting for thread1");
        }
    }

    public static void main(String args[])
    {
        LockEx lockEx = new LockEx();
        lockEx.thread1.start();
        lockEx.thread2.start();
    }
}
