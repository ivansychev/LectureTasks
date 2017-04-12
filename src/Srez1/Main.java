package Srez1;

import java.util.Random;

/**
 * Created by ivans on 12/04/2017.
 */
public class Main {
    public static void main (String args[])
    {
        NumStore numStore = new NumStore();
        RandNumThread randNumThread = new RandNumThread(numStore);
        DisplayNumThread displayNumThread = new DisplayNumThread(numStore);

        new Thread(randNumThread).start();
        new Thread(displayNumThread).start();
    }
}
