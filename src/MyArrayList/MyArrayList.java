package MyArrayList;

import MyArrayList.AnsiEscapeCodes;

import static MyArrayList.AnsiEscapeCodes.*;

class MyArrayList<T extends Number> {
    private T arr[];
    private int capacity = 5;
    private int nElems = -1;

    public MyArrayList() {
        this.arr = (T[]) new Number[capacity];
    }

    //возвращает размер массива
    public long size() {
        return nElems+1;
    }

    public void setLength(int length) {
        this.nElems = length;
    }

    //добавляет в конец массива
    public void add(T t)
    {
        System.out.println(ANSI_BLUE + "Method: add("+t+")" + ANSI_RESET);

        if(nElems + 1>capacity-1)
        {
            increaseCapacity();
            arrayCopy();
            arr[++nElems]=t;
        }
        else arr[++nElems]=t;
        System.out.println("Array: ["+printArray()+"]");
    }
    public <T extends Number> T find(T t)
    {
        return t;
    }

    //увеличение capacity
    public void increaseCapacity()
    {
        System.out.println(ANSI_YELLOW + "Warning! Limit capacity reached! Current capacity: " + capacity + ". New capacity: " + ((capacity*3)/2+1) + ANSI_RESET);
        this.capacity = (capacity*3)/2+1;
    }

    //скопировать в новый массив
    public void arrayCopy()
    {
        T newArray[] = (T[]) new Number[capacity];
        for(int i=0; i<=nElems; i++)
        {
            newArray[i] = arr[i];
        }
        this.arr = newArray;
    }
    //удаляет элемент по значению
    public void delete(T t)
    {
        System.out.println(ANSI_BLUE + "Method: delete("+t+")" + ANSI_RESET);
        for(int i=0; i<nElems; i++)
        {
            if(arr[i]==t)
            {
                for(int j=i; j<nElems; j++)
                {
                    arr[j] = arr[j+1];
                }
                --nElems;
                break;
            }
        }
        System.out.println("Array: ["+printArray()+"]");
    }
    public String printArray()
    {
        String s = "";
        for(int i = 0;i<=nElems; i++)
        {
            if(i!=nElems)s += arr[i] + ",";
            else s+=arr[i];
        }
        return s;
    }
}