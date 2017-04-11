package Semophore;

/**
 * Created by ivans on 07/04/2017.
 */
public class Kvadrator implements Runnable{
    @Override
    public void run() {
        synchronized (Consumer.lock2) {
            for (int x : Consumer.arr_cubes) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Kvadrator: " + Consumer.met(sq(x), 0, 0));
            }
        }
    }
    public int sq(int x) {return x*x;}
}
