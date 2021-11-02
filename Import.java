package prj5;

import java.io.FileNotFoundException;

/**
 * Where the CovidData program takes place
 * 
 * @author masongelletly
 * @version 4.23.21
 */
public class Input 
{
    /**
     * The main method of the project
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) 
        throws FileNotFoundException
    {
        if (args.length >= 1)
        {
            new StateReader(args[0]);
        }
        //new StateReader("Cases_and_Deaths_CRDT_NEW.csv");
    }       
}
