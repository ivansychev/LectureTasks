package Timer;

import java.util.concurrent.TimeUnit;

/**
 * Created by ivans on 06/04/2017.
 */
public class TimeNotifier implements Runnable {

    private final Object lock = new Object();
    private final Object lock2 = new Object();

    static volatile boolean isIt_5 = false;
    static volatile boolean isIt_7 = false;

    private long startTime;
    private long elapsedTime;
    private MessageNotifier messageNotifier;
    private AnotherMessageNotifier anotherMessageNotifier;


    public TimeNotifier() {

        this.startTime = System.nanoTime();
        this.messageNotifier = new MessageNotifier(lock);
        this.anotherMessageNotifier = new AnotherMessageNotifier(lock2);
    }

    @Override
    public void run() {
        new Thread(messageNotifier).start();
        new Thread(anotherMessageNotifier).start();

        while (true) {
            synchronized (lock) {
                informMessageNotifier5(this.elapsedTime);
                synchronized (lock2) {
                    informMessageNotifier7(this.elapsedTime);
                    try {
                        Thread.sleep(1000);
                        countFormattedTime(this.startTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public void countFormattedTime(long startTime)
    {
        long endTime = System.nanoTime();
        this.elapsedTime = endTime - startTime;

        String formattedTime = TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + " sec";
        System.out.println("Elapsed time: " + formattedTime);
    }

    public void informMessageNotifier5(long secondsElapsed)
    {
        if(TimeUnit.NANOSECONDS.toSeconds(secondsElapsed)!=0&&TimeUnit.NANOSECONDS.toSeconds(secondsElapsed)%5==0)
        {
            lock.notify();
            isIt_5 = true;
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void informMessageNotifier7(long secondsElapsed)
    {
        if(TimeUnit.NANOSECONDS.toSeconds(secondsElapsed)!=0&&TimeUnit.NANOSECONDS.toSeconds(secondsElapsed)%7==0)
        {
            lock2.notify();
            isIt_7 = true;
            try {
                lock2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
