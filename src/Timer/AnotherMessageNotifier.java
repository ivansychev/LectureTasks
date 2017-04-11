package Timer;

/**
 * Created by ivans on 06/04/2017.
 */
public class AnotherMessageNotifier implements Runnable{

    private Object lock;

    public AnotherMessageNotifier(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            while(TimeNotifier.isIt_7) {
                synchronized (lock) {
                    try {
                        TimeNotifier.isIt_7 = false;
                        System.out.println("Timer.AnotherMessageNotifier says Hi!");
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
