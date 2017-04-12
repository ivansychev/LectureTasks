package Srez1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ivans on 12/04/2017.
 */
public class DisplayNumThread implements Runnable {

    private NumStore numStore;

    public DisplayNumThread(NumStore numStore) {
        this.numStore = numStore;
    }

    @Override
    public void run() {
        while (!numStore.isRepeated5Times())
        {
            while (!numStore.isSuspendDisplayer()) {
                synchronized (numStore.getLock()) {
                    for (ConcurrentHashMap.Entry<Integer, Integer> entry : numStore.getNumStore().entrySet()) {
                        if (entry.getValue() > 4) {
                            System.out.println("Number " + entry.getKey() + " were generated " + entry.getValue() + " times");
                            numStore.setRepeated5Times(true);
                        }
                    }

                    System.out.println(numStore.getNumStore());
                    numStore.getLock().notify();

                    try {
                        numStore.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
