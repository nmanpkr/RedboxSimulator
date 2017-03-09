/**
 * Event class for storing events that happen throughout the simulation
 * 
 * @author Patrick Richeal, Emily Provine, Alex Christofides
 * @version 3/2/2017
 */
public class Event
{
    //General fields
    private EventType type;
    private int creationTime;
    
    //Fields for movie rental/return event
    private Movie movie;
    private String uniqueId;
    private int rentalPeriod;

    /**
     * Construtor for accepting no parameters
     */
    public Event()
    {
        this.type = null;
        this.creationTime = Clock.getTick();
        
        this.movie = null;
        this.uniqueId = "";
        this.rentalPeriod = 0;
    }

    /**Event
     * Constructor for accepting either RENTAL or RETURN events
     * 
     * @param type the type of event
     * @param movie the movie that is being rented or returned
     */
    public Event(EventType type, Movie movie)
    {
        this.type = type;
        this.creationTime = Clock.getTick();
        
        this.movie = movie;
        this.uniqueId = "";
        this.rentalPeriod = 0;
    }
    
    /**
     * Constructor for accepting CUSTOMER CREATE events
     * 
     * @param type the type of event
     */
    public Event(EventType type)
    {
        this.type = type;
        this.creationTime = Clock.getTick();
        
        this.movie = null;
        this.uniqueId = "";
        this.rentalPeriod = 0;
    }
    
    /**
     * Get the type of this event
     * 
     * @return the type of the event
     */
    public EventType getType()
    {
        return this.type;
    }
    
    /**
     * Get the movie that is stored in this event
     * 
     * @return the movie that is stored in this event
     */
    public Movie getMovie()
    {
        return this.movie;
    }
    
    /**
     * Get the creation time of this event
     * 
     * @return the creation time of this event
     */
    public int getCreationTime()
    {
        return this.creationTime;
    }
    
    /**
     * Get if the movie has been paired with a corresponding return yet
     */
    public String getUniqueId()
    {
        return this.uniqueId;
    }
    
    /**
     * Set this events unique id
     * 
     * @param uniqueId the unique id to set to
     */
    public void setUniqueId(String uniqueId)
    {
        this.uniqueId = uniqueId;
    }
    
    /**
     * Set this event's rental period
     * 
     * @param num the length of time to set the rental period to
     */
    public void setRentalPeriod(int num)
    {
        this.rentalPeriod = num;
    }
    
    /**
     * Get this event's rental period
     * 
     * @return the rentalPeriod field
     */
    public int getRentalPeriod()
    {
        return this.rentalPeriod;
    }
}

