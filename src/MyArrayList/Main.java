package MyArrayList;

/**
 * Created by ivans on 04/04/2017.
 */
public class Main {
    public static void main(String args[])
    {
       MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.delete(4);
        myArrayList.printArray();
    }
}

