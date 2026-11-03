import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Collection<T>{
    private int liveCount;
    private T[] array;

    @SuppressWarnings("unchecked")
    public Collection() {
        this.array = (T[]) new Object[1];
        this.liveCount = 0;
    }

    public boolean isEmpty(){
        return liveCount==0;
    }

    /** Returns the number of elements in the list represented by the object */
    public int length() {
        return liveCount;
    }

    @SuppressWarnings("unchecked")
    /** Accepts an element and adds it to the end of a list */
    public void add(T newVal){
        if (isEmpty()){
            array[0] = newVal;
            liveCount++;
        } else {
            if (length() == array.length-1){
                T[] newArr = (T[]) new Object[array.length*2];
                for (int x = 0; x < array.length-1; x++) {
                    newArr[x] = array[x];
                }
                array = newArr;
                Arrays.sort(array);
                liveCount++;
            } else {
                array[length()] = newVal;
                Arrays.sort(array);
                liveCount++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    /** Accepts an index, removes an element at a given index, and returns the element */
    public T remove(int index){
        if (index > array.length-1 || index < 0){
            throw new NoSuchElementException();
        } else {
            T removeable = array[index];
            T[] replace = (T[]) new Object[array.length-1];
            System.arraycopy(array, 0, replace, 0, index-1);
            System.arraycopy(array, index+1, replace, index, length()-index-1);
            array = replace;
            liveCount--;
            return removeable;
        }
    }

    /** Returns the smallest element in the collection */
    public T findSmallest(){
        return null;
    }
}
