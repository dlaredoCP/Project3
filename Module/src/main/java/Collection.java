import java.util.Arrays;
import java.util.NoSuchElementException;

public class Collection<T extends Comparable<T>> {
    private int liveCount;
    private T[] array;

    @SuppressWarnings("unchecked")
    public Collection() {
        this.array = (T[]) new Comparable[2];
        this.liveCount = 0;
    }
    /** Returns true if the collection is empty, false otherwise */
    public boolean isEmpty(){
        return liveCount==0;
    }

    /** Returns the number of elements in the list represented by the object */
    public int length() {
        return liveCount;
    }

    public T get(int index){
        if (index>liveCount-1 || index<0){
            throw new IllegalArgumentException();
        } else {
            return array[index];
        }
    }

    @SuppressWarnings("unchecked")
    /** Accepts an element and adds it to the end of a list */
    public void add (T newVal){
        if (liveCount == array.length-1){
            T[] newArr = (T[]) new Comparable[array.length*2];
            for (int x = 0; x < array.length-1; x++) {
                newArr[x] = array[x];
            }
            newArr[liveCount] = newVal;
            array = newArr;
            liveCount++;
            insertionSort();
        } else {
            array[liveCount] = newVal;
            liveCount++;
            insertionSort();
        }
    }

    @SuppressWarnings("unchecked")
    /** Accepts an index, removes an element at a given index, and returns the element */
    public T remove(int index){
        if (index > array.length-1 || index < 0){
            throw new NoSuchElementException();
        } else {
            T removable = array[index];
            T[] replace = (T[]) new Comparable[array.length];
            for (int a = 0; a<index; a++){
                replace[a] = array[a];
            }
            for (int b = index+1; b<length(); b++){
                replace[b-1] = array[b];
            }
            array = replace;
            liveCount--;
            return removable;
        }
    }

    public void insertionSort(){
        T hold;
        for (int x=1; x<length(); x++){
            for (int i=x; i>0 && array[i].compareTo(array[i-1])<0; i--){
                hold = array[i];
                array[i] = array[i-1];
                array[i-1] = hold;
            }
        }
    }

}
