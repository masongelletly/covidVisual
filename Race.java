package prj5;

import java.text.DecimalFormat;

/**
 * A class to represent the races utilized
 * within the CovidData project
 * 
 * @author masongelletly
 * @version 4.22.21
 */
public class Race 
{
    // name of the race
    private String name;
    
    // death statistic
    private int death;
    
    // cases statistic
    private int cases;
    
    /**
     * Constructor for the race class, intializes 
     * statistic fields
     * 
     * @param paramName : name of the race
     * @param paramDeath : death statistic
     * @param paramCases : cases statistic
     */
    public Race(String paramName, int paramDeath, int paramCases)
    {
        name = paramName;
        death = paramDeath;
        cases = paramCases;
    }
    
    /**
     * Getter method for the name of the race
     * 
     * @return : the name of the race
     */
    public String name()
    {
        return name;
    }
    
    /**
     * Getter method for the number of deaths
     * 
     * @return : the number of deaths
     */
    public int death()
    {
        return death;
    }
    
    /**
     * Calculates and returns the cfr statistic
     * 
     * @return cfr : the cfr statistic, -1 if N/A
     */
    public double doubleCfr()
    {
        // checks for n/a values
        if (death == -1 || cases == -1)
        {
            return -1;
        }
        
        // create double alibis for calculation
        double dubDeath = death;
        double dubCases = cases;
        
        // formula for cfr 
        return (dubDeath / dubCases) * 100;
    }
    
    /**
     * Calculates and returns the cfr while
     * accounting for NA (-1) values
     * 
     * @return the string representation of race cfr
     */
    public String cfr()
    {
        if (doubleCfr() == -1)
        {
            return "NA";
        }        
        else 
        {
            return String.valueOf(doubleCfr());
        }
    }
    /**
     * Returns the String representation of the race 
     * class and her traits
     * 
     * format = asian: 5407 cases, 4.7% CFR
     * 
     * @return : String representation of Race
     */
    public String toString()
    {
        // creates object for concatenation
        StringBuilder sb = new StringBuilder();
        
        // accounts for NA
        if (doubleCfr() == -1)
        {
            return "NA";
        }
        
        // adds cfr portion (rounded to one digit)
        DecimalFormat oneDigi = new DecimalFormat("###.#");
        sb.append(oneDigi.format(doubleCfr()));
        sb.append("% CFR");
        
        // return concatenated string
        return sb.toString();
    }
}
