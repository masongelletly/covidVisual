package prj5;

// imports
import java.awt.Color;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class GUIWindow 
{
    // window field & stateNum field
    private Window window;
    private int stateNum;
    
    // measurement constants
    private final int COLUMN_WIDTH = 30;
    private final int HEIGHT_RATIO = 25;
    private final int START_HEIGHT = 225;
    
    // button fields
    private Button alpha;
    private Button cfr;
    private Button quit;
    // states
    private Button dc;
    private Button ga;
    private Button md;
    private Button nc;
    private Button tn;
    private Button va;
    
    // update boolean
    private boolean sortByAlpha;
       
    // states list fields
    private DLList<State> states;
    
    /**
     * Constructor for the graphic user interface,
     * initializes graphic interface
     * 
     * @param paramStates : linked list of states
     */
    public GUIWindow(DLList<State> paramStates)
    {
        // list & int initialization
        states = paramStates;
        
        stateNum = -1;
        
        // window & boolean intialization
        window = new Window();
        window.setTitle("Covid Data Project 5");
        
        sortByAlpha = true;

        // button initialization
        alpha = new Button("Sort by Alpha");
        alpha.onClick(this, "clickedAlpha");
        window.addButton(alpha, WindowSide.NORTH);
        
        
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);
        
        cfr = new Button("Sort by CFR");
        cfr.onClick(this, "clickedCFR");
        window.addButton(cfr, WindowSide.NORTH);
        
        // states
        dc = new Button("Represent DC");
        dc.onClick(this, "clickedDC");
        window.addButton(dc, WindowSide.SOUTH);
        
        ga = new Button("Represent GA");
        ga.onClick(this, "clickedGA");
        window.addButton(ga, WindowSide.SOUTH);
        
        md = new Button("Represent MD");
        md.onClick(this, "clickedMD");
        window.addButton(md, WindowSide.SOUTH);
        
        nc = new Button("Represent NC");
        nc.onClick(this, "clickedNC");
        window.addButton(nc, WindowSide.SOUTH);
        
        tn = new Button("Represent TN");
        tn.onClick(this, "clickedTN");
        window.addButton(tn, WindowSide.SOUTH);
        
        va = new Button("Represent VA");
        va.onClick(this, "clickedVA");
        window.addButton(va, WindowSide.SOUTH); 
        
        // initial instructional text
        TextShape instruct = new TextShape(280, 140, 
            "Select a state to display", Color.black);
        instruct.setBackgroundColor(Color.white);
        window.addShape(instruct);
    }
    
    /**
     * Carries out the action that takes place once
     * the quit button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedQuit(Button button)
    {
        // exits the program
        System.exit(0);
    }
    
    /**
     * Carries out the action that takes place once
     * the cfr button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedCFR(Button button)
    {
        // update the text in cfr order
        sortByAlpha = false;
        updateText();
         
    }
    
    /**
     * Carries out the action that takes place once
     * the alpha button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedAlpha(Button button)
    {
        // update the text in alphabetical order
        sortByAlpha = true;
        updateText();
         
    }
    
    /**
     * Carries out the action that takes place once
     * the DC button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedDC(Button button)
    {
        // update the text
        stateNum = 0;
        updateText();        
    }
    
    /**
     * Carries out the action that takes place once
     * the GA button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedGA(Button button)
    {
        // update the text
        stateNum = 1;
        updateText();        
    }
    
    /**
     * Carries out the action that takes place once
     * the MD button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedMD(Button button)
    {
        stateNum = 2;
        updateText();        
    }
    
    /**
     * Carries out the action that takes place once
     * the NC button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedNC(Button button)
    {
        // update the text
        stateNum = 3;
        updateText();        
    }
    
    /**
     * Carries out the action that takes place once
     * the TN button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedTN(Button button)
    {
        // update the text
        stateNum = 4;
        updateText();        
    }
    
    /**
     * Carries out the action that takes place once
     * the VA button is clicked on
     * 
     * @param button : the button to be clicked
     */
    public void clickedVA(Button button)
    {
        // update the text
        stateNum = 5;
        updateText();         
    }
    
    /**
     * Updates text once the alpha
     * button is clicked on by sorting the
     * races based on their alphabetics
     * 
     * is the default display type
     * 
     * @param stateNum : indicates the state
     * DC - 0
     * GA - 1
     * MD - 2
     * NC - 3
     * TN - 4
     * VA - 5
     */
    private void alphaText(int stateNum)
    {
        // alpha sorted list of state index 0, creates iterator
        DLList<Race> race = states.getNodeAtIndex(stateNum).data().getSortedAlpha();
        Iterator<Race> iter = race.iterator();
        
        // sets text positions for columns based on position
        // first race -----------------------------
        Race one = iter.next();
        TextShape raceOne = new TextShape(40, 230, 
            one.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceOne);
        // first stats ---------------------------
        TextShape raceOneStat = new TextShape(30, 260, 
            one.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceOneStat);
        
        // second race --------------------------
        Race two = iter.next();
        TextShape raceTwo = new TextShape(190, 230,
            two.name(), Color.black);;
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceTwo);
        // second stats --------------------------
        TextShape raceTwoStat = new TextShape(180, 260,
            two.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceTwoStat);
        
        // third race ---------------------------
        Race three = iter.next();
        TextShape raceThree = new TextShape(340, 230,
            three.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceThree);
        // third stats --------------------------
        TextShape raceThreeStat = new TextShape(330, 260,
            three.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceThreeStat);
        
        // fourth race --------------------------
        Race four = iter.next();
        TextShape raceFour = new TextShape(490, 230,
            four.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFour);
        // fourth stats -------------------------
        TextShape raceFourStat = new TextShape(480, 260,
            four.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFourStat);
        
        // fifth race ---------------------------
        Race five = iter.next();
        TextShape raceFive = new TextShape(630, 230,
            five.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFive);
        // fifth stats --------------------------
        TextShape raceFiveStat = new TextShape(620, 260,
            five.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFiveStat);
        
        // bar graph display handling ----------
        // bar one
        Shape barOne = new Shape(48, START_HEIGHT - (int)(one.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(one.doubleCfr() * HEIGHT_RATIO));
        barOne.setBackgroundColor(Color.PINK);
        barOne.setForegroundColor(Color.PINK);
        window.addShape(barOne);
        
        // bar two 
        Shape barTwo = new Shape(195, START_HEIGHT - (int)(two.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(two.doubleCfr() * HEIGHT_RATIO));
        barTwo.setBackgroundColor(Color.PINK);
        barTwo.setForegroundColor(Color.PINK);
        window.addShape(barTwo);
        
        // bar three
        Shape barThree = new Shape(348, START_HEIGHT - (int)(three.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(three.doubleCfr() * HEIGHT_RATIO));
        barThree.setBackgroundColor(Color.PINK);
        barThree.setForegroundColor(Color.PINK);
        window.addShape(barThree);
        
        // bar four
        Shape barFour = new Shape(498, START_HEIGHT - (int)(four.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(four.doubleCfr() * HEIGHT_RATIO));
        barFour.setBackgroundColor(Color.PINK);
        barFour.setForegroundColor(Color.PINK);
        window.addShape(barFour);
        
        // bar five
        Shape barFive = new Shape(637, START_HEIGHT - (int)(five.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(five.doubleCfr() * HEIGHT_RATIO));
        barFive.setBackgroundColor(Color.PINK);
        barFive.setForegroundColor(Color.PINK);
        window.addShape(barFive);
    }
    
    /**
     * Updates text once the cfr
     * button is clicked on by sorting the
     * races based on their cfr values
     * 
     * @param stateNum : indicates the state
     * DC - 0
     * GA - 1
     * MD - 2
     * NC - 3
     * TN - 4
     * VA - 5
     */
    private void cfrText(int stateNum)
    {        
        // cfr sorted list of state index 0, creates iterator
        DLList<Race> race = states.getNodeAtIndex(stateNum).data().getSortedCFR();
        Iterator<Race> iter = race.iterator();
        
        // sets text positions for columns based on position
        // first race -----------------------------
        Race one = iter.next();
        TextShape raceOne = new TextShape(40, 230, 
            one.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceOne);
        // first stats ---------------------------
        TextShape raceOneStat = new TextShape(30, 260, 
            one.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceOneStat);
        
        // second race --------------------------
        Race two = iter.next();
        TextShape raceTwo = new TextShape(190, 230,
            two.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceTwo);
        // second stats --------------------------
        TextShape raceTwoStat = new TextShape(180, 260,
            two.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceTwoStat);
        
        // third race ---------------------------
        Race three = iter.next();
        TextShape raceThree = new TextShape(340, 230,
            three.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceThree);
        // third stats --------------------------
        TextShape raceThreeStat = new TextShape(330, 260,
            three.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceThreeStat);
        
        // fourth race --------------------------
        Race four = iter.next();
        TextShape raceFour = new TextShape(490, 230,
            four.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFour);
        // fourth stats -------------------------
        TextShape raceFourStat = new TextShape(480, 260,
            four.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFourStat);
        
        // fifth race ---------------------------
        Race five = iter.next();
        TextShape raceFive = new TextShape(630, 230,
            five.name(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFive);
        // fifth stats --------------------------
        TextShape raceFiveStat = new TextShape(620, 260,
            five.toString(), Color.black);
        raceOne.setBackgroundColor(Color.white);
        window.addShape(raceFiveStat);
        
        // bar graph display handling ----------
        // bar one
        Shape barOne = new Shape(48, START_HEIGHT - (int)(one.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(one.doubleCfr() * HEIGHT_RATIO));
        barOne.setBackgroundColor(Color.PINK);
        barOne.setForegroundColor(Color.PINK);
        window.addShape(barOne);
        
        // bar two 
        Shape barTwo = new Shape(195, START_HEIGHT - (int)(two.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(two.doubleCfr() * HEIGHT_RATIO));
        barTwo.setBackgroundColor(Color.PINK);
        barTwo.setForegroundColor(Color.PINK);
        window.addShape(barTwo);
        
        // bar three
        Shape barThree = new Shape(348, START_HEIGHT - (int)(three.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(three.doubleCfr() * HEIGHT_RATIO));
        barThree.setBackgroundColor(Color.PINK);
        barThree.setForegroundColor(Color.PINK);
        window.addShape(barThree);
        
        // bar four
        Shape barFour = new Shape(498, START_HEIGHT - (int)(four.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(four.doubleCfr() * HEIGHT_RATIO));
        barFour.setBackgroundColor(Color.PINK);
        barFour.setForegroundColor(Color.PINK);
        window.addShape(barFour);
        
        // bar five
        Shape barFive = new Shape(637, START_HEIGHT - (int)(five.doubleCfr(
            ) * HEIGHT_RATIO), COLUMN_WIDTH,
            (int)(five.doubleCfr() * HEIGHT_RATIO));
        barFive.setBackgroundColor(Color.PINK);
        barFive.setForegroundColor(Color.PINK);
        window.addShape(barFive);
    }
    
    /**
     * Helper method to update the text of
     * the project 5 gui
     */
    private void updateText()
    {
        // remove all previous shapes
        window.removeAllShapes();
        
        // update based on boolean field
        if (sortByAlpha)
        {
            alphaText(stateNum);
        }
        else
        {
            cfrText(stateNum);
        }
        
        // updates header 
        TextShape header = new TextShape(280, 20,
            states.getNodeAtIndex(stateNum).data().name()
            + " case fatality ratio by race", Color.black);
        header.setBackgroundColor(Color.white);
        window.addShape(header);
    }
}
