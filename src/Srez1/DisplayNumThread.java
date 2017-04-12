package Srez1;

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
                synchronized (numStore.getLock()) {
                    if(!numStore.isSuspendDisplayer())
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
