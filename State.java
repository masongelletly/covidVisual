package prj5;

import java.util.Iterator;

/**
 * A class to represent the states utilized within the 
 * CovidData project
 * 
 * @author masongelletly
 * @version 4.22.21
 */
public class State 
{
    // DLList fields
    private DLList<Race> norm;
    
    // trait
    private String name;
    
    // sorts
    private DLList<Race> alpha;
    private DLList<Race> cfr;
    
    /**
     * Default constructor utilizing a parametized 
     * DLList using Race objects. Initializes name
     * 
     * @param race : list of Race objects
     * @param paramName : the name of the state
     */
    public State(DLList<Race> race, String paramName)
    {
        // initialize name
        name = paramName;   
        
        // initialize normal list, alpha and cfr sorted lists
        norm = race;
        alpha = race.sortAlpha(norm);
        cfr = race.sortByCFR(norm);        
    }
    
    /**
     * Returns the sorted race list in alphabetical terms
     * 
     * @return the sorted alphabetical list
     */
    public DLList<Race> getSortedAlpha()
    {
        return alpha;
    }
    
    /**
     * Returns the sorted race list in cfr terms
     * 
     * @return the sorted cfr list
     */
    public DLList<Race> getSortedCFR()
    {
        return cfr;
    }
    
    /**
     * Returns the name of the State
     * 
     * @return the name of the state
     */
    public String name()
    {
        return name;
    }
    
    /**
     * Returns the String representation of the state
     * class and her traits
     * 
     * asian: 5407 cases, 4.7% CFR
     * black: 179563 cases, 7.4% CFR
     * latinx: 97118 cases, 2.3% CFR
     * other: 108784 cases, 0.2% CFR
     * white: 70678 cases, 2.7% CFR
     *  
     * @return : String representation of State
     */
    public String toString()
    {
        // StringBuilder object
        StringBuilder sb = new StringBuilder();
        
        // iterate through list object
        Iterator<Race> iter = norm.iterator();
        
        // iterate through list
        while (iter.hasNext())
        {
            // calling toString of race
            sb.append(iter.next().toString());
            
            if (iter.hasNext())
            {
                sb.append("\n");
            }
        }
        
        // return concatenated string
        return sb.toString();
    }
}
