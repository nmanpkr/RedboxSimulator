
/**
 * Write a description of class Movie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private String title;
    private boolean rented;

    /**
     * Constructor for objects of class Movie
     */
    public Movie(String n)
    {
        title= n;
        rented=false;
        
    }

    /**
     * returns title of movie object
     */
    public String getTitle()
    {
        return title;
    }
    
    public boolean isRented()
    {
        return (rented==true);
    }
    
    /**
     * Changes the movie from not rented to rented
     * and vice versa
     */
    public void rent()
    {
        // Will have a line to send a notification to Statistics
        // Need if statement to determine if renting or returning to change dayRented and dayReturned
        // from the clock/tick class
        if(!rented)
        {
            rented=true;
            Stat.sendMessage("RENTAL");
        }
        if(rented)
        {
            rented = false;
            Stat.sendMessage("RETURN");
        }   
    }        
}
