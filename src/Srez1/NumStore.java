package Srez1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ivans on 12/04/2017.
 */
public class NumStore {
    private ConcurrentHashMap<Integer, Integer> numStore;
    private Object lock = new Object();
    private volatile boolean isRepeated5Times = false;

    public void setSuspendDisplayer(boolean suspendDisplayer) {
        this.suspendDisplayer = suspendDisplayer;
    }

    public boolean isSuspendDisplayer() {

        return suspendDisplayer;
    }

    private volatile boolean suspendDisplayer = true;

    public void setRepeated5Times(boolean repeated5Times) {
        isRepeated5Times = repeated5Times;
    }

    public boolean isRepeated5Times() {
        return isRepeated5Times;
    }


    public Object getLock() {
        return lock;
    }

    public ConcurrentHashMap<Integer, Integer> getNumStore() {
        return numStore;
    }

    public NumStore()
    {
        numStore = new ConcurrentHashMap<>();
        for(int i=0; i<100; i++)
        {
            numStore.put(i,0);
        }
    }
}
