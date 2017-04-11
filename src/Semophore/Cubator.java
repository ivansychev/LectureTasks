package Semophore;

/**
 * Created by ivans on 07/04/2017.
 */
public class Cubator implements Runnable{
    @Override
    public void run() {
        synchronized (Consumer.lock1) {
            for (int x : Consumer.arr_cubes) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Cubator: " + Consumer.met(cb(x), 0, 0));
            }
        }
    }
    public int cb(int x) {return x*x*x;}
}
