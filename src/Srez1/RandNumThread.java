package Srez1;

import java.util.Random;

/**
 * Created by ivans on 12/04/2017.
 */
public class RandNumThread implements Runnable {

    private NumStore numStore;
    private long counter = 0;

    public RandNumThread(NumStore numStore) {
        this.numStore = numStore;
    }

    @Override
    public void run() {
        while (!numStore.isRepeated5Times())
        {
            synchronized (numStore.getLock())
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int arr[] = null;
                //String s = "[";
                int randomNum;
                for(int j = 0; j<5; j++)
                {
                    arr = new int[5];
                    randomNum = new Random().nextInt(100);
                    arr[j] = randomNum;
                    int prevVal = numStore.getNumStore().get(randomNum);
                    numStore.getNumStore().put(randomNum,++prevVal);
                    System.out.print(randomNum + " ");
                }
                System.out.println();

                if(++counter%5==0)
                {
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
