/**
 * File Name: ListADT.java
 * Author: Michelle Jiang 
 * Date Created: 2026-01-30
 * Purpose: This interface is an Abstract Data Type for the List type. The interface would guide a user on how a ListADT object will be created with methods, exceptions and return types. A List is an ordered sequence of elemnts that allows elements to be accessed, inserted, and removed based on their order in the sequence.
 * Creation of Object: A ListADT object represents an empty ordered sequence of elements of a specified type. Immediately after construction, the list contains no elements (a size of zero), while remaining in a valid state for future insertions.
 * 
 */
interface ListADT<T> { 

    /**
     * Sets the value at the given index
     * @param index the index whose value is changed
     * @param value the value to change the index to 
     * @return the item that was previously at this position
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    T set(int index, T value); 

    /**
     * Adds element to existing list. Note: If the element type isn't the same as the list type, the code will not compile. 
     * @param index of where the new element should be added
     * @param value the element to be added to the ListADT object
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    void add(int index, T value); 

    /**
     * Queries number of elements in list. If empty, returns zero. 
     * @return size of list. 
     */
    int size(); 

    /**
     * Tests if a list is empty or not. 
     * @return true if empty, false if has elements
     */
    boolean isEmpty(); 

    /**
     * Accesses element at a given index. 
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return value at specified index
     */
    T get(int index); 

    /**
     * Removes item from list at given index. 
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return the element at the index specified
     */
    T remove(int index);
}