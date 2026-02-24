import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Dynamic Array is like a list that is backed by an array. It allows adding, removing, and accessing elements in a way similar to an ArrayList.
 *
 * @param <T> The generic class T can hold any object type such as Integer, String, etc. 
 * @author Michelle Jiang
 */
public class DynamicArray<T> implements Iterable<T> {
    // The underlying array that holds the elements of the DynamicArray. 
    T[] data; 
    // The number of elements currently in the DynamicArray. 
    int size; 

    // Constructs an empty DynamicArray with an initial capacity of 10.
    public DynamicArray() {
        this(10); 
    }

    // Constructs an empty DynamicArray with the given initial capacity.
    public DynamicArray(int capacity) {
        this.data = this.makeArray(capacity); 
        this.size = 0; 
    }

    // Constructs a new DynamicArray that is a copy of the given DynamicArray.
    public DynamicArray(DynamicArray<T> sourceArray) {
        this.data = this.makeArray(sourceArray.data.length);
        for (int i=0; i<sourceArray.size; i++) {
            this.data[i] = sourceArray.data[i];
        }
        this.size = sourceArray.size; 
    }
    /**
     * Sets the value at the given index
     * @param index the index whose value is changed
     * @param value the value to change the index to 
     * @return the item that was previously at this position
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    public T set(int index, T value) {
        checkIndex(index);
        T returnValue = this.data[index];
        this.data[index] = value; 
        return returnValue;
    }

    /**
     * Adds element to existing list. Note: If the element type isn't the same as the list type, the code will not compile. 
     * @param index of where the new element should be added
     * @param value the element to be added to the ListADT object
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    public void add(int index, T value) {
        if (index < 0 || index > this.size()) { 
            throw new IndexOutOfBoundsException();
        } else {
            if (size == this.data.length) {
                T[] dataCopy = this.makeArray(size*2+1);
                for (int i=0; i<size; i++) {
                    dataCopy[i] = this.data[i];
                }
                data = dataCopy;
            }
            for (int i=this.size()-1; i>=index; i--) {
                this.data[i+1] = this.data[i];
            }
            this.data[index] = value;
            size += 1; 
        }
    }

    /**
     * Adds element at end of list. 
     * @param value the element to be added to the ListADT object
     */
    public void add(T value) { 
        this.add(size, value);
    }

    /**
     * Queries number of elements in list. If empty, returns zero. 
     * @return size of list. 
     */
    public int size() {
        return this.size; 
    }

    /**
     * Tests if a list is empty or not. 
     * @return true if empty, false if has elements
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Converts the DynamicArray to a string.
     * @return DynamicArray in String type
     */
    public String toString() {
        String returnString = "["; 
        for (int i=0; i<this.size(); i++) {
            returnString += String.valueOf(this.data[i]);
            if (i<this.size-1) {
                returnString += ", ";
            }
        }
        returnString += "]";
        return returnString;
    }

    /**
     * Accesses element at a given index. 
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return value at specified index
     */
    public T get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    /**
     * Removes item from list at given index. 
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return the element at the index specified
     */
    public T remove(int index) {
        checkIndex(index);
        T returnValue = this.data[index];
        this.data[index] = null;
        for (int i=index+1; i<size; i++) {
            this.data[i-1] = this.data[i];
        }
        size -= 1; 
        return returnValue;
    }

    /**
     * Appends the elements of the given array to the end of this array, and returns a new DynamicArray containing the result.
     * @param addArray the array to be appended to this array
     * @return a new DynamicArray containing the elements of this array followed by the elements of addArray
     */
    public DynamicArray<T> append(DynamicArray<T> addArray) {
        DynamicArray<T> newArray = new DynamicArray<T>(addArray.size+this.size());
        for (int i=0; i<this.size(); i++) {
            newArray.data[i] = this.data[i];
        }
        for (int i=0; i<addArray.size; i++) {
            newArray.data[this.size()+i] = addArray.data[i];
        }
        newArray.size = this.size + addArray.size;
        return newArray;
    }

    /**
     * Adds the elements of the given array to the index of this array, and returns a new DynamicArray containing the result.
     * @param index the index at which to insert the elements of addArray
     * @param addArray the array to be added to the end of this array
     * @return a new DynamicArray containing the elements of this array with the elements of addArray inserted at the specified index
     */
    public DynamicArray<T> addAll(int index, DynamicArray<T> addArray) {
        if (index < 0 || index > this.size) {
        throw new IndexOutOfBoundsException();
        }
        DynamicArray<T> newArray = new DynamicArray<T>(addArray.size+this.size());
 
        for (int i=0; i<index; i++) {
            newArray.data[i] = this.data[i];
        }
    
        for (int i=0; i<addArray.size; i++) {
                newArray.data[i+index] = addArray.data[i];
            }
        
        for (int i=index; i<this.size(); i++) {
            newArray.data[i+addArray.size] = this.data[i];
        }

        newArray.size = this.size + addArray.size;
        return newArray;
    }

    /**
     * Checks if the given index is valid for accessing or modifying the list. If the index is out of bounds, an IndexOutOfBoundsException is thrown.
     * @param index the index to check
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Creates a new generic array of the given capacity.
     * <p>
     * Java does not allow direct creation of generic arrays. This helper method
     * safely encapsulates the required cast and suppresses the expected unchecked
     * cast warning.
     *
     * @param capacity the desired length of the array
     * @return a new array of type T[] with the given capacity
     */    
    @SuppressWarnings("unchecked")
    private T[] makeArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    /**
     * Returns a new DynamicArray containing the elements of this array from the given index to the end of the array. The original array should not be modified.
     * @param index the index from which to start copying elements
     * @return a new DynamicArray containing the elements of this array from the given index to the end of the array
     */
    public DynamicArray<T> splitCopy(int index) { 
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == this.size) {
            return new DynamicArray<T>(0);
        }
        DynamicArray<T> newArray = new DynamicArray<T>(this.size - index);
        for (int i=index; i<this.size; i++) {
            newArray.data[i-index] = this.data[i];
        }
        newArray.size = this.size - index;
        return newArray;
    }

    /**
     * Returns a new DynamicArray containing the elements of this array from the given index to the end of the array. The original array is modified to remove these elements.
     * @param index the index from which to start transferring elements
     * @return a new DynamicArray containing the elements of this array from the given index to the end of the array
     */
    public DynamicArray<T> splitTransfer(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == this.size) {
            return new DynamicArray<T>(0);
        }
        if (index == 0) {
            DynamicArray<T> newArray = new DynamicArray<T>(this.size);
            for (int i=0; i<this.size; i++) {
                newArray.data[i] = this.data[i];
                this.data[i] = null;
            }
            newArray.size = this.size;
            this.size = 0;
            return newArray;
        }
        DynamicArray<T> newArray = new DynamicArray<T>(this.size - index);
        for (int i=index; i<this.size; i++) {
            newArray.data[i-index] = this.data[i];
            this.data[i] = null;
        }
        newArray.size = this.size - index;
        this.size = index;
        return newArray;
    }

    /**
     * Returns an iterator for the list. The iterator should iterate through the elements of the list in order from first to last.
     * @return an iterator for the list
     */
    public Iterator<T> iterator() {
    return new DynamicArrayIterator();
    }
    
    /**
     * Private inner class to implement the iterator for the DynamicArray. The iterator should iterate through the elements of the array in order from index 0 to size-1.
     */
    private class DynamicArrayIterator implements Iterator<T> {
        private int currentIndex;
        
        /**
         * Constructor for DynamicArrayIterator.
         */
        public DynamicArrayIterator() {
            this.currentIndex = 0;
        }

        /**
         * Returns true if there are more elements to iterate through, false otherwise.
         * @return true if there are more elements to iterate through, false otherwise
         */
        public boolean hasNext() {
            return this.currentIndex < DynamicArray.this.size;
        }

        /**
         * Returns the next element in the iteration and advances the iterator. If there are no more elements to iterate through, throws a NoSuchElementException.
         * @return the next element in the iteration
         */
        public T next() {
            if (this.hasNext()) {
                T data = DynamicArray.this.data[this.currentIndex];
                this.currentIndex++;
                return data;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
