package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked list class that will be utilized
 * within the CovidData project
 * 
 * Within DLList are private classes Node and 
 * DLListIterator 
 * 
 * @author masongelletly
 * @version 4.21.21
 * 
 * @param <T> : the generic type
 */
public class DLList<T> 
{
    // the size of the list
    private int size;
    
    // leading and ending sentinel nodes
    private Node<T> head;
    private Node<T> tail;
    
    /**
     * Default constructor for the doubly linked list
     * 
     * Initializes fields and sets sentinel nodes
     */
    public DLList()
    {
        // initialize size
        size = 0;
        
        // sentinel node initialization
        head = new DLList.Node<T>(null);
        tail = new DLList.Node<T>(null);
        
        // set sentinal nodes
        head.setNext(tail);
        tail.setPrev(head);
    }
    
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() 
    {            
        return new DLListIterator<T>();
    } 
    
    /**
     * Returns the size of the list
     * 
     * @return size : the size of the array
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Checks if the list is empty
     *
     * @return true if empty : false if not empty
     */
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    /**
     * Returns if parametized entry is present in the list (data)
     * 
     * @param entry : the entry searched for
     * @return true if in list : false if not in list
     */
    public boolean contains(T entry)
    {
        // if parametized entry is null
        if (entry == null)
        {
            return false;
        }
        
        // sets current node to first node
        Node<T> curr = head;
        // counts through list to search for entry
        for (int i = 0; i <= size; i++) 
        {
            // if data is equal
            if (curr.data == entry)
            {
                return true;
            }         
            // 'decrements' current node for iteration
            curr = curr.next();
        }       
        // if not found
        return false; 
    }
    
    /**
     * Returns the node at a specified index
     * 
     * @param index : the position of the node to be found
     * @return current : the node 
     * @throws IndexOutOfBoundsException : invalid index
     */
    public Node<T> getNodeAtIndex(int index)
    {
        // checks if index is valid
        if (index < 0 || size() <= index) 
        {
            throw new IndexOutOfBoundsException();
        }
        
        // initialize node at the beginning of the list
        Node<T> current = head.next();
        // iterate towards specified index
        for (int i = 0; i < index; i++) 
        {
            current = current.next();
        }
        
        // returns node once index is reached
        return current;
    }
    
    /**
     * Adds a node at specified index with parametized data
     *
     * @param index : where node is added
     * @param data : the data of the added node
     * @throws IndexOutOfBoundsException : invalid index
     */
    public void add(int index, T data) 
    {
        // checks if index is valid
        if (index < 0 || size < index) 
        {
            throw new IndexOutOfBoundsException();
        }

        // initialize reference node curr for addition 
        Node<T> ref;
        if (index == size) 
        {
            ref = tail;
        } 
        else 
        {
            ref = getNodeAtIndex(index);
        }

        // create node with parametized data
        Node<T> addition = new Node<T>(data);      
        // insert the node into the list
        addition.setPrev(ref.previous());
        addition.setNext(ref);        
        // update list
        ref.previous().setNext(addition);
        ref.setPrev(addition);
        
        // increment size accordingly
        size++;
    }
    
    /**
     * Adds a node to the end of the list
     *
     * @param data : the data of the added node
     */
    public void add(T data)
    {
        // calls on multiparameter add with ending index
        add(size(), data);
    }
    
    /**
     * Removes a node at a specified index
     *
     * @param index : where node is removed
     * @throws IndexOutOfBoundsException : invalid index
     * @return true if removed : false will be an exception
     */
    public boolean remove(int index) 
    {
        // checks if index is valid
        if (index < 0 || size < index) 
        {
            throw new IndexOutOfBoundsException();
        }
        
        // initializes node that will be removed
        Node<T> removeNode = getNodeAtIndex(index);
        
        // set list to 'skip' over removeNode
        removeNode.previous().setNext(removeNode.next());
        removeNode.next().setPrev(removeNode.previous());
        
        // decrement size
        size--;
        return true;
    }
    
    /**
     * Removes a node based on its data (first) if already within the list
     *
     * @param removeNode : the data of the node to be removed
     * @return true if removed : false if not
     */

    public boolean remove(T removeNode)
    {
        // initializes iterating node to beginning of list
        Node<T> curr = head.next();
        // iterates through list 
        while (!curr.equals(tail)) 
        {
            // if parametized data is found
            if (curr.data().equals(removeNode)) 
            {
                // set list to 'skip' over removeNode
                curr.previous().setNext(curr.next());
                curr.next().setPrev(curr.previous());
                
                // decrement size, return true
                size--;
                return true;
            }           
            // iterate through list
            curr = curr.next();
        }
        // if not found
        return false;
        
    }

    // ----------------- Sorting Methods ----------------
    /**
     * Returns a new, sorted list based upon the 
     * alphabetics of the current list
     * 
     * @param unSort : unsorted race list
     * @return alpha : sorted race list by alpha
     */
    public DLList<Race> sortAlpha(DLList<Race> unSort)
    {
        // create return list and iterator
        DLList<Race> alpha = new DLList<Race>();
        Iterator<Race> iter = unSort.iterator();
        
        // parse with iter and grab races
        Race white = iter.next();
        Race black = iter.next();
        Race latin = iter.next();
        Race asian = iter.next();
        Race other = iter.next();
        
        // add to alpha in order of alphabetics
        alpha.add(asian);
        alpha.add(black);
        alpha.add(latin);
        alpha.add(other);
        alpha.add(white);
        
        // return new list
        return alpha;
    }    
    
    /**
     * Returns a new, sorted list based upon the calculated
     * CFR stastics (descending) of the current list
     * 
     * @param unSort: the unsorted list
     * @return cfr : the sorted list
     */
    public DLList<Race> sortByCFR(DLList<Race> unSort)
    {
        // create return list 
        DLList<Race> cfr = new DLList<Race>();
        
        // sorting begins
        // initialize race array
        Race[] race;    
        race = new Race[5];
        Iterator<Race> iter = unSort.iterator();
        
        // parse with iter and grab races
        Race white = iter.next();
        Race black = iter.next();
        Race latin = iter.next();
        Race asian = iter.next();
        Race other = iter.next();
        
        // place values in array
        race[0] = white;
        race[1] = black;
        race[2] = latin;
        race[3] = asian;
        race[4] = other;
        
        // SORTING ------------------------
        int len = race.length;       
        // iterate through race array
        for (int index = 0; index < len - 1; index++)
        {
            // finding smallest cfr
            int small = index;
            for (int j = index + 1; j < len; j++)
            {
                // check for equal, reverts to alpha
                if (race[j].cfr() == race[small].cfr()) 
                {
                    // alpha sorting
                    if (race[j].name().compareTo(race[small].name()) < 0)
                    {
                        small = j;
                    }
                }
                else if (race[j].doubleCfr() < race[small].doubleCfr())
                {
                    small = j;
                }
            }
            
            // temporary variable to swap positions
            Race temp = race[small];
            race[small] = race[index];
            race[index] = temp;
        }
        
        // add sorted values to list in order of sorted array
        for (int i = 0; i <= len - 1; i++)
        {
            cfr.add(race[i]);
        }
              
        // return new list
        return cfr;
    }
    
    // -------------------- Node Class --------------------
    /**
     * The node class that will be used within the
     * doubly linked list class 
     * 
     * @author masongelletly
     * @version 4.21.21
     * 
     * @param <T> : the generic type
     */
    static class Node<T>
    {
        // reference nodes
        private Node<T> next;
        private Node<T> previous;
        
        // data the node holds
        private T data;
        
        /**
         * Creates a node with given data
         *
         * @param paramData : the data of the node
         */
        public Node(T paramData) 
        {
            data = paramData;
        }

        /**
         * Sets the following node
         *
         * @param nextNode : the next node
         */
        public void setNext(Node<T> nextNode) 
        {
            next = nextNode;
        }

        /**
         * Sets the previous node
         *
         * @param prevNode : the previous node
         */
        public void setPrev(Node<T> prevNode) 
        {
            previous = prevNode;
        }

        /**
         * Returns the next node
         *
         * @return next : the next node
         */
        public Node<T> next() 
        {
            return next;
        }

        /**
         * Returns the previous node
         *
         * @return previous : the previous node
         */
        public Node<T> previous() 
        {
            return previous;
        }

        /**
         * Returns the data of the node
         *
         * @return data : the data of the node
         */
        public T data() 
        {
            return data;
        }
    }
    
    // ------------------ Iterator Class -------------------
    private class DLListIterator<A> implements Iterator<T> 
    {
        // if iterator is ready to remove an object
        private boolean readyRemove;
        
        // node used to iterate through the list
        private Node<T> curr;
        
        /**
         * Default constructor for the iterator
         * 
         * Initializes fields
         */
        public DLListIterator() 
        {
            readyRemove = false;
            curr = head;
        }
         
        /**
         * Returns if another node with data exists after curr
         *
         * @return true if object exists after curr : false if not
         */
        @Override
        public boolean hasNext() 
        {
            return curr.next.data != null;
        }

        /**
         * Returns the next node's data in the list
         *
         * @return data : the next node's data
         * @throws NoSuchElementException : no next value
         */
        @Override
        public T next() 
        {
            // if no next value, throw exception
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            
            // assign return value
            T data = curr.next.data();
            
            // advance curr through the list, update readyRemove
            curr = curr.next;
            readyRemove = true;
            
            // return 
            return data;
        }

        /**
         * Removes current node if next() has been called already 
         *
         * @throws IllegalStateException : not ready for removal
         */
        @Override
        public void remove() 
        {
            // not ready for removal
            if (!readyRemove)
            {
                throw new IllegalStateException();
            }
            
            // setting list to 'skip' over current node
            curr.previous.next  = curr.next;           
            curr.next.previous  = curr.previous;
            
            // update readyRemove, size
            readyRemove = false;
            size--;
        }    
    }   
}
