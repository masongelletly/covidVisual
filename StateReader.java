package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that parses a given file and returns
 * a DLList object with the found information
 * 
 * @author masongelletly
 *
 */
public class StateReader
{
    /**
     * Constructor for the StateReader class that takes
     * parameterized file name and constructs GUI
     * 
     * @param fileName
     * @throws FileNotFoundException 
     */
    public StateReader(String fileName) throws FileNotFoundException
    {
        new GUIWindow(this.readInputFile(fileName));
    }
    
    /**
     * Method that parses through the parametized file
     * 
     * @return parsed : the DLList representation of the file
     * @throws FileNotFoundException : invalid fileName
     */
    public DLList<State> readInputFile(String fileName) throws FileNotFoundException
    {
        // initializes the returned list and race
        DLList<State> state = new DLList<State>();
        
        // scanner object construct for file
        Scanner file = new Scanner(new File(fileName));
        
        // advances passed header 
        file.nextLine();
     
        // creates a state object with all necessary info
        // Race(name, death, cases)
        // State(DLList<Race>, name)
        // state, cases white, black, latinx, asian, other, deaths white, black, latinx, asian, other
        
        String[] info = file.nextLine().split(", *");  
        int index = 0;
        for (String str : info)
        {
            if (str.equals("NA"))
            {
                info[index] = "-1";
            }
            index++;
        }
        
        DLList<Race> dcRace = new DLList<Race>();
        
        Race dcWhite = new Race("white", Integer.valueOf(info[6]), Integer.valueOf(info[1]));
        dcRace.add(dcWhite);
        
        Race dcBlack = new Race("black", Integer.valueOf(info[7]), Integer.valueOf(info[2]));
        dcRace.add(dcBlack);
        
        Race dcLatinx = new Race("latinx", Integer.valueOf(info[8]), Integer.valueOf(info[3]));
        dcRace.add(dcLatinx);
        
        Race dcAsian = new Race("asian", Integer.valueOf(info[9]), Integer.valueOf(info[4]));
        dcRace.add(dcAsian);
        
        Race dcOther = new Race("other", Integer.valueOf(info[10]), Integer.valueOf(info[5]));
        dcRace.add(dcOther);
        
        // create state object with information and add to list
        State dc = new State(dcRace, "dc");
        state.add(dc);
        
        // new line prep ---------------------------------------------------------------
        info = file.nextLine().split(", *");
        index = 0;
        for (String str : info)
        {
            if (str.equals("NA"))
            {
                info[index] = "-1";
            }
            index++;
        }
        
        DLList<Race> gaRace = new DLList<Race>();
        Race gaWhite = new Race("white", Integer.valueOf(info[6]), Integer.valueOf(info[1]));
        gaRace.add(gaWhite);
        
        Race gaBlack = new Race("black", Integer.valueOf(info[7]), Integer.valueOf(info[2]));
        gaRace.add(gaBlack);
        
        Race gaLatinx = new Race("latinx", Integer.valueOf(info[8]), Integer.valueOf(info[3]));
        gaRace.add(gaLatinx);
        
        Race gaAsian = new Race("asian", Integer.valueOf(info[9]), Integer.valueOf(info[4]));
        gaRace.add(gaAsian);
        
        Race gaOther = new Race("other", Integer.valueOf(info[10]), Integer.valueOf(info[5]));
        gaRace.add(gaOther);
        
        // create state object with information and add to list
        State ga = new State(gaRace, "ga");
        state.add(ga);
        
        // new line prep ---------------------------------------------------------------
        info = file.nextLine().split(", *");
        index = 0;
        for (String str : info)
        {
            if (str.equals("NA"))
            {
                info[index] = "-1";
            }
            index++;
        }
        
        DLList<Race> mdRace = new DLList<Race>();
        Race mdWhite = new Race("white", Integer.valueOf(info[6]), Integer.valueOf(info[1]));
        mdRace.add(mdWhite);
        
        Race mdBlack = new Race("black", Integer.valueOf(info[7]), Integer.valueOf(info[2]));
        mdRace.add(mdBlack);
        
        Race mdLatinx = new Race("latinx", Integer.valueOf(info[8]), Integer.valueOf(info[3]));
        mdRace.add(mdLatinx);
        
        Race mdAsian = new Race("asian", Integer.valueOf(info[9]), Integer.valueOf(info[4]));
        mdRace.add(mdAsian);
        
        Race mdOther = new Race("other", Integer.valueOf(info[10]), Integer.valueOf(info[5]));
        mdRace.add(mdOther);
        
        // create state object with information and add to list
        State md = new State(mdRace, "md");
        state.add(md);
        
        // new line prep ---------------------------------------------------------------
        info = file.nextLine().split(", *");
        index = 0;
        for (String str : info)
        {
            if (str.equals("NA"))
            {
                info[index] = "-1";
            }
            index++;
        }
        
        DLList<Race> ncRace = new DLList<Race>();
        Race ncWhite = new Race("white", Integer.valueOf(info[6]), Integer.valueOf(info[1]));
        ncRace.add(ncWhite);
        
        Race ncBlack = new Race("black", Integer.valueOf(info[7]), Integer.valueOf(info[2]));
        ncRace.add(ncBlack);
        
        Race ncLatinx = new Race("latinx", Integer.valueOf(info[8]), Integer.valueOf(info[3]));
        ncRace.add(ncLatinx);
        
        Race ncAsian = new Race("asian", Integer.valueOf(info[9]), Integer.valueOf(info[4]));
        ncRace.add(ncAsian);
        
        Race ncOther = new Race("other", Integer.valueOf(info[10]), Integer.valueOf(info[5]));
        ncRace.add(ncOther);
        
        // create state object with information and add to list
        State nc = new State(ncRace, "nc");
        state.add(nc);
        
        // new line prep ---------------------------------------------------------------
        info = file.nextLine().split(", *");
        index = 0;
        for (String str : info)
        {
            if (str.equals("NA"))
            {
                info[index] = "-1";
            }
            index++;
        }
        
        DLList<Race> tnRace = new DLList<Race>();
        Race tnWhite = new Race("white", Integer.valueOf(info[6]), Integer.valueOf(info[1]));
        tnRace.add(tnWhite);
        
        Race tnBlack = new Race("black", Integer.valueOf(info[7]), Integer.valueOf(info[2]));
        tnRace.add(tnBlack);
        
        Race tnLatinx = new Race("latinx", Integer.valueOf(info[8]), Integer.valueOf(info[3]));
        tnRace.add(tnLatinx);
        
        Race tnAsian = new Race("asian", Integer.valueOf(info[9]), Integer.valueOf(info[4]));
        tnRace.add(tnAsian);
        
        Race tnOther = new Race("other", Integer.valueOf(info[10]), Integer.valueOf(info[5]));
        tnRace.add(tnOther);
        
        // create state object with information and add to list
        State tn = new State(tnRace, "tn");
        state.add(tn);
        
        // new line prep ---------------------------------------------------------------
        info = file.nextLine().split(", *");
        index = 0;
        for (String str : info)
        {
            if (str.equals("NA"))
            {
                info[index] = "-1";
            }
            index++;
        }
        
        DLList<Race> vaRace = new DLList<Race>();
        Race vaWhite = new Race("white", Integer.valueOf(info[6]), Integer.valueOf(info[1]));
        vaRace.add(vaWhite);
        
        Race vaBlack = new Race("black", Integer.valueOf(info[7]), Integer.valueOf(info[2]));
        vaRace.add(vaBlack);
        
        Race vaLatinx = new Race("latinx", Integer.valueOf(info[8]), Integer.valueOf(info[3]));
        vaRace.add(vaLatinx);
        
        Race vaAsian = new Race("asian", Integer.valueOf(info[9]), Integer.valueOf(info[4]));
        vaRace.add(vaAsian);
        
        Race vaOther = new Race("other", Integer.valueOf(info[10]), Integer.valueOf(info[5]));
        vaRace.add(vaOther);
        
        // create state object with information and add to list
        State va = new State(vaRace, "va");
        state.add(va);
        
        // return found value
        return state;
    }
}
