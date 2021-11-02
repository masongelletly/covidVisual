package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A test class for class DLList to make certain that it
 * is working as intended
 * 
 * Tests DLList, Iterator
 * 
 * Uses String type for testing purposes
 * 
 * @author masongelletly
 * @version 4.21.21
 */
public class DLListTest extends student.TestCase
{
    // DLList field
    private DLList<String> list;
   
    // iterator field
    private Iterator<String> iterator;
    
    // boolean for testing exceptions
    private boolean testException;
    
    /**
     * Ran before every test class, initializes fields
     */
    public void setUp()
    {
        list = new DLList<String>();
        iterator = list.iterator();
    }
    
    /**
     * To make certain size() and 
     * getNodeAtIndex() work as intended
     */
    public void testSizeNodeInd()
    {
        // empty list
        assertEquals(list.size(), 0);
        
        // non-empty list
        list.add("first");
        assertEquals(list.size(), 1);
        
        // invalid node index negative
        try
        {
            list.getNodeAtIndex(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);
        
        testException = false;
        // invalid node index negative
        try
        {
            list.getNodeAtIndex(999);
        }
        catch (IndexOutOfBoundsException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);
    }
    
    /**
     * To make certain isEmpty() works as intended
     */
    public void testEmpty()
    {
        // empty case
        assertTrue(list.isEmpty());
        
        // non-empty case
        list.add("no longer empty");
        assertFalse(list.isEmpty());
    }
    
    /**
     * To make certain contains() works as intended
     */
    public void testContains()
    {
        // null case
        assertFalse(list.contains(null));
        
        // empty case
        assertFalse(list.contains("none"));
        
        // non-empty not found
        list.add("first");
        assertFalse(list.contains("none"));
        
        // non-empty found
        assertTrue(list.contains("first"));
    }
    
    /**
     * To make certain both add methods work as intended
     */
    public void testAdds()
    {
        // invalid node index negative
        try
        {
            list.add(-1, "invalid");
        }
        catch (IndexOutOfBoundsException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);
        
        testException = false;
        // invalid node index negative
        try
        {
            list.add(999, "invalid");
        }
        catch (IndexOutOfBoundsException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);

        // add no index 
        list.add("first");
        assertEquals(list.size(), 1);
        
        // add with index 
        list.add(1, "second");
        assertEquals(list.size(), 2);
        
        // add with index (tail)
        list.add(2, "third");
        assertEquals(list.size(), 3);       
    }
    
    /**
     * To make certain both remove methods work as intended
     */
    public void testRemoves()
    {
        // invalid index exception
        try
        {
            list.remove(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);
        
        // add for testing
        list.add("first");
        list.add("second");
        list.add("third");      
        assertEquals(list.size(), 3);
        
        // remove with index 
        assertTrue(list.remove(0));
        assertEquals(list.size(), 2);
        
        // remove with value
        assertTrue(list.remove("second"));
        assertEquals(list.size(), 1); 
    }
    
    // ------------- Iterator testing -----------------
    /**
     * To make certain hasNext() works as intended
     */
    public void testHasNext()
    {
        // false case
        assertFalse(iterator.hasNext());
        
        // true case
        list.add("first");
        assertTrue(iterator.hasNext());
    }
    
    /**
     * To make certain next() works as intended
     */
    public void testNext()
    {
        // invalid exception (empty list)
        try
        {
            iterator.next();
        }
        catch (NoSuchElementException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);
        
        // base case
        list.add("first");
        assertEquals("first", iterator.next());
    }
    
    /**
     * To make certain remove() works as intended
     */
    public void testRemove()
    {
        // invalid call (not ready)
        try
        {
            iterator.remove();
        }
        catch (IllegalStateException e)
        {
            // is true if caught
            testException = true;
        }
        assertTrue(testException);
        
        // base call 
        list.add("first");
        iterator.next();
        
        iterator.remove();
        assertEquals(0, list.size());
    }
}
