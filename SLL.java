import org.w3c.dom.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to implement a singly linked list
 *
 * @author Michelle Jiang
 * @version Spring 2026
 */


class SLL<T> implements Iterable<T> {

    /**
     * The head of the list. If the list is empty, head is null.
     */
    public NodeSL<T> head; 
    /**
     * The size of the list. If the list is empty, size is 0.
     */
    public int size; 

    /**
     * Constructor to create an empty list. Sets head to null and size to 0.
     */
    public SLL() {
        this.head = null;
        this.size = 0;
    }

    /** Copy Constructor 
     * @param other the SLL to be copied
    */
    public SLL(SLL<T> other) { 
        if (other.head == null) {
            this.head = null;
            this.size = 0;
            return; 
        }
        this.head = new NodeSL<T>(other.head.getData(), null);
        NodeSL<T> currentNode = this.head;
        NodeSL<T> otherNode = other.head.getNext();
        while (otherNode != null) {
            currentNode.setNext(new NodeSL<T>(otherNode.getData(), null));
            currentNode = currentNode.getNext();
            otherNode = otherNode.getNext();
        }
        this.size = other.size;
    }

    /**
     * Queries number of elements in list. If empty, returns zero. 
     * @return size of list. 
     */
    public int size() { 
        return this.size; 
    }

    /**
     * Accesses element at a given index. 
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return value at specified index
     */
    public T get(int index) { 
        return this.getNode(index).getData(); 
    }

    /**
     * Sets the value at the given index
     * @param index the index whose value is changed
     * @param value the value to change the index to 
     * @return the item that was previously at this position
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    public T set(int index, T value) {
        T prevValue = this.get(index);
        NodeSL<T> node = this.getNode(index);
        node.setData(value);
        return prevValue; 
    }

    /**
     * Adds element to existing list. Note: If the element type isn't the same as the list type, the code will not compile. 
     * @param index of where the new element should be added
     * @param value the element to be added to the ListADT object
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    public void add(int index, T value) { 
        if (index == 0) {
            this.addFirst(value);
            return;
        }

        if (index == size) {
            this.addLast(value);
            return;
        }
        NodeSL<T> prev = getNode(index - 1);
        prev.setNext(new NodeSL<T>(value, prev.getNext()));
        this.size++;
    }

    /**
     * Removes item from list at given index. 
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return the element at the index specified
     */
    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        NodeSL<T> prev = getNode(index - 1);
        NodeSL<T> target = prev.getNext();
        T data = target.getData();
        prev.setNext(target.getNext());
        size--;
        return data;
    }

    /**
     * Converts the Linked List to a string.
     * @return Linked List in String type
     */
    public String toString() {
        String returnString = "["; 
        if (this.head == null) {
            returnString += "]"; 
            return returnString;
        }
        NodeSL<T> item;
        for ( item = this.head; item.getNext() != null; item = item.getNext()) {
            returnString += item.getData() + ", ";
        }
        returnString += item.getData() + "]";
        return returnString;
    }
    
    /**
     * Tests if a list is empty or not. 
     * @return true if empty, false if has elements
     */
    public boolean isEmpty() { 
        if (this.size() == 0) { 
            return true; 
        }
        return false; 
    }

    /**
     * Helper method to get the node at a given index.
     * @param index the index to query
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     * @return the node at the index specified
     */
    public NodeSL<T> getNode(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        NodeSL<T> currentNode = this.head;
        for (int i=0; i<index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Gets the head (first element) of the list.
     * @return the head node of the list
     */
    public NodeSL<T> getHead() {
        return this.head;
    }

    /**
     * Gets the tail (last element) of the list.
     * @return the tail node of the list
     */
    public NodeSL<T> getTail() {
        if (this.head == null) { 
            return null; 
        }
        NodeSL<T> currentNode = this.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Adds element to the front of the list. Note: If the element type isn't the same as the list type, the code will not compile.
     * @param value the element to be added to the front of the ListADT object
     */
    public void addFirst(T value) {
        NodeSL<T> newHead = new NodeSL<T>(value, this.head); 
        this.head = newHead;
        this.size++;
    }

    /**
     * Adds element to the end of the list. Note: If the element type isn't the same as the list type, the code will not compile.
     * @param value the element to be added to the end of the ListADT object
     */
    public void addLast(T value) { 
        NodeSL<T> newTail = new NodeSL<T>(value, null);
        if (this.head == null) {
            this.head = newTail;
        } else {
            NodeSL<T> tail = this.getTail();
            tail.setNext(newTail);
        }
        this.size++;
    }

    /**
     * Removes the first element from the list and sets the second element as the new head. 
     * @return the original first element
     */
    public T removeFirst() { 
        if (this.head == null) { 
            throw new IllegalStateException();
        }
        T data = this.head.getData();
        this.head = this.head.getNext();
        this.size--;
        return data;
    }

    /**
     * Removes the last element from the list and sets the second last element as the new tail. 
     * @return the original last element
     */
    public T removeLast() { 
        if (this.head == null) { 
            throw new IllegalStateException();
        } else if (this.size == 1) {
            T data = this.head.getData();
            this.head = null;
            this.size--;
            return data;
        }
        NodeSL<T> newTail = this.getNode(this.size-2);
        T data = newTail.getNext().getData();
        newTail.setNext(null);
        this.size--;
        return data;
    }

    /**
     * Adds element after a given index. 
     * @param node the node after which the new element should be added
     * @param value the element to be added to the ListADT object
     */
    public void addAfter(NodeSL<T> node, T value) { 
        if (head == null) {
        head = new NodeSL<>(value, null);
        size = 1;
        return; 
        }

        if (node == null) {
            addFirst(value);
            return; 
        }
        NodeSL<T> nextNode = node.getNext();
        NodeSL<T> newNode = new NodeSL<T>(value, nextNode);
        node.setNext(newNode);
        this.size++;
    }

    /**
     * Removes all elements after a given node. 
     * @param node the node after which elements should be removed.
     * @return the element that was removed
     */
    public T removeAfter(NodeSL<T> node) { 
        if (head == null) {
            throw new IllegalStateException();
        }

        if (node == null) {
            return removeFirst();
        }

        
        NodeSL<T> target = node.getNext();
        if (target == null) { 
            throw new IllegalStateException();
        }
        node.setNext(target.getNext());
        size--;
        return target.getData();
    }

    /**
     * Splits the list into two lists at a given index. The original list should remain unchanged, and the new list should contain the elements from index to size-1. Note: If the index is out of bounds, an IndexOutOfBoundsException is thrown.
     * @param index the index at which to split the list
     * @return a new SLL containing the elements from index to size-1
     */
    public SLL<T> splitCopy(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        SLL<T> newList = new SLL<T>();
        if (index == this.size) {
            return newList;
        }
        NodeSL<T> current = getNode(index);
        newList.head = new NodeSL<T> (current.getData(), null);
        current = current.getNext();
        NodeSL<T> newTail = newList.head; 

        while (current != null) {
            NodeSL<T> newNode = new NodeSL<>(current.getData(), null);
            newTail.setNext(newNode);
            newTail = newNode;
            current = current.getNext();
        }
        newList.size = this.size - index;
        return newList; 
    }

    /**
     * Splits the list into two lists at a given index. The original list should contain the elements from index 0 to index-1, and the new list should contain the elements from index to size-1. Note: If the index is out of bounds, an IndexOutOfBoundsException is thrown.
      * @param index the index at which to split the list
      * @return a new SLL containing the elements from index to size-1
     */
    public SLL<T> splitTransfer(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        SLL<T> newList = new SLL<T>();
        if (index == 0) {
            newList.head = this.head;
            newList.size = this.size;
            this.head = null;
            this.size = 0;
            return newList;
        }
        if (index == this.size) {
            return new SLL<T>();
        }
        NodeSL<T> prev = getNode(index - 1);
        newList.head = prev.getNext();
        newList.size = this.size - index;
        prev.setNext(null);
        this.size = index;
        return newList;
    }

    /**
     * Returns an iterator for the list. The iterator should iterate through the elements of the list in order from head to tail.
     * @return an iterator for the list
     */
    public Iterator<T> iterator() {
    return new SLLIterator();
    }
    
    /**
     * Private inner class to implement the iterator for the SLL. The iterator should iterate through the elements of the list in order from head to tail.
     */
    private class SLLIterator implements Iterator<T> {
        //Current node that the iterator is at. 
        private NodeSL<T> current;

        /**
         * Constructor for SLLIterator. Initializes current to head of the list.
         */
        public SLLIterator() {
            this.current = SLL.this.head;
        }
        
        /**
         * Returns true if there are more elements to iterate through, false otherwise.
         * @return true if there are more elements to iterate through, false otherwise
         */
        public boolean hasNext() {
            return this.current != null;
        }

        /**
         * Returns the next element in the iteration and advances the iterator. If there are no more elements to iterate through, throws a NoSuchElementException.
         * @return the next element in the iteration
         */
        public T next() {
            if (this.hasNext()) {
                T data = this.current.getData();
                this.current = this.current.getNext();
                return data;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

}