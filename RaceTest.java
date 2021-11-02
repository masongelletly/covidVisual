package prj5;

/**
 * A test class for the Race class to make certain 
 * all method are working properly
 * 
 * @author masongelletly
 * @version 4.22.21
 */
public class RaceTest extends student.TestCase
{
    // Race fields (deaths, cases)
    private Race race = new Race("asian", 10, 23);
    
    // N/A race objects
    private Race naLeft = new Race("", 0, 30);
    private Race naRight = new Race("", 30, 0);
    private Race naBoth = new Race("", 0, 0);
    
    /**
     * Testing the methods name() and cfr() to make
     * certain they are working properly
     */
    public void testNameCFR()
    {
        // testing name()
        assertEquals(race.name(), "asian");
        
        // testing cfr()
        assertEquals(race.doubleCfr(), 43.5, 0.1);
    }
    
    /**
     * To make certain toString() works as intended
     */
    public void testToString()
    {
        assertEquals(race.toString(),
            "43.5% CFR");
    }
}
