
/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock
{
    // instance variables - replace the example below with your own
    private static int tick;

    /**
     * Constructor for objects of class Clock
     */
    public Clock()
    {
        // initialise instance variables
        tick = 0;
    }
    
    public void clockTick()
    {
        tick++;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int getTick()
    {
        // put your code here
        return tick;
    }
}
