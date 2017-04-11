package Semophore;

import java.util.Random;

/**
 * Created by ivans on 07/04/2017.
 */
public class Consumer {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static final Object lock3 = new Object();

    static int[] arr_cubes = new int[100];
    static int[] arr_squaeres  = new int[100];
    static int[] arr_simples  = new int[100];

    public static void fillArrs()
    {
        for(int i=0; i<100; i++)
            arr_cubes[i]=new Random().nextInt((100 - 1) + 1) + 1;
        for(int i=0; i<100; i++)
            arr_squaeres[i]=new Random().nextInt((100 - 1) + 1) + 1;
        for(int i=0; i<100; i++)
            arr_simples[i]=new Random().nextInt((100 - 1) + 1) + 1;
    }


    public static int met(int a3, int b2, int c)
    {
            return a3 + b2 + c;
    }
}
