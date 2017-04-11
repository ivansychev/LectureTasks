package Semophore;

/**
 * Created by ivans on 07/04/2017.
 */
public class Main {
    public static void main(String args[])
    {
        Consumer.fillArrs();

        Thread cubator_t = new Thread(new Cubator());
        Thread kvadrator_t = new Thread(new Kvadrator());
        Thread simpler_t = new Thread(new Simplier());

        cubator_t.start();
        kvadrator_t.start();
        simpler_t.start();
    }
}
