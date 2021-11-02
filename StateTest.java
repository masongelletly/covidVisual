package prj5;

/**
 * To make certain the State class is working as intended
 * 
 * @author masongelletly
 * @version 4.23.21
 */
public class StateTest extends student.TestCase
{
    // fields for state
    private State state;
    
    // fields for race
    private Race white;
    private Race black;
    private Race latin;
    private Race asian; 
    private Race other;
    
    /**
     * Run before every test, initializes fields
     */
    public void setUp()
    {
        // race initialization
        DLList<Race> race;
        
        // races for list of races for state
        white = new Race("white", 100, 100);
        black = new Race("black", 100, 40);
        latin = new Race("latin", 100, 60);
        asian = new Race("asian", 100, 80);
        other = new Race("other", 100, 100);       
        
        // initialize race and add values
        race = new DLList<Race>();
        race.add(white);
        race.add(black);
        race.add(latin);
        race.add(asian);
        race.add(other);
        
        // initialize state for testing
        state = new State(race, "stateName");
    }
    
    /**
     * Make certain getSortedAlpha() is working as intended
     */
    public void testAlpha()
    {
        // call method
        DLList<Race> alpha = state.getSortedAlpha();
        
        // assert proper order occurs
        assertEquals(alpha.getNodeAtIndex(0).data(), asian);
        assertEquals(alpha.getNodeAtIndex(1).data(), black);
        assertEquals(alpha.getNodeAtIndex(2).data(), latin);
        assertEquals(alpha.getNodeAtIndex(3).data(), other);
        assertEquals(alpha.getNodeAtIndex(4).data(), white);
    }
    
    /**
     * Make certain getSortedCFR() is working as intended
     */
    public void testCFR()
    {
        // call method
        DLList<Race> cfr = state.getSortedCFR();

        // assert values created
        assertEquals(cfr.getNodeAtIndex(2).data(), asian);
        assertEquals(cfr.getNodeAtIndex(3).data(), latin);
        assertEquals(cfr.getNodeAtIndex(4).data(), black);
    }
    
    /**
     * Test name() and toString() methods working as intended
     */
    public void testNameString()
    {
        // name() testing
        assertEquals(state.name(), "stateName");
        
        // toString() testing
        // CFR numbers skewed due to simplified data insertion in setUp
        assertEquals(state.toString(), "100% CFR\n"
            + "250% CFR\n"
            + "166.7% CFR\n"
            + "125% CFR\n"
            + "100% CFR");        
    }
}
