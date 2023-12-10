
import java.util.Arrays;
import java.util.Collection;


public class MyArrayList<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private T[] array;

    public MyArrayList() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[DEFAULT_CAPACITY];

    }

    public MyArrayList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public MyArrayList (Collection <? extends T> collection) {
        this.size = 0;
        this.capacity = collection.size() + 10;
        this.array = (T[]) new Object[capacity];

        for (T value: collection) {
            add(value);
        }
    }

    public MyArrayList (MyArrayList<? extends T> myArrayList) {
        this.size = 0;
        this.capacity = myArrayList.size + 10;
        this.array = (T[]) new Object[capacity];

        for (T value: myArrayList.array) {
            add(value);
        }
    }

    public int size () {
        return size;
    }

    public boolean add(T value) {

        if (capacity - 1 == size) {
            capacity += 20;
            array = Arrays.copyOf(array, capacity);
        }

        array[size++] = value;
        return true;
    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public boolean addAll(Collection <? extends T> collections) {
        for (T value : collections) {
            add(value);
        }
        return true;
    }

    public boolean addAll(MyArrayList <? extends T> myList) {
        for (int i = 0; i < myList.size; i++) {
            add(myList.get(i));
        }
        return true;
    }

    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {

                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}