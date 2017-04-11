package Timer;

/**
 * Created by ivans on 06/04/2017.
 */

public class Main {

    public static void main(String args[])
    {
        TimeNotifier timeNotifier = new TimeNotifier();
        Thread t1 = new Thread(timeNotifier);
        t1.start();
    }
}
