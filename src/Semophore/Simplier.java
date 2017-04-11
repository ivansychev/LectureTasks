package Semophore;

/**
 * Created by ivans on 07/04/2017.
 */
public class Simplier implements Runnable {
    @Override
    public void run() {
        synchronized (Consumer.lock3) {
            for (int x : Consumer.arr_cubes) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Simpler: " + Consumer.met(x, 0, 0));
            }
        }
    }
}
