package Timer;

import sun.awt.windows.ThemeReader;

/**
 * Created by ivans on 06/04/2017.
 */
public class MessageNotifier implements Runnable {

    private Object lock;

    public MessageNotifier(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            while(TimeNotifier.isIt_5) {
                synchronized (lock) {
                    try {
                        TimeNotifier.isIt_5 = false;
                        System.out.println("Timer.MessageNotifier says Hi!");
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
