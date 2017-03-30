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
    private double cost;
    
    //Fields for customer create events
    private Customer customer;

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
        this.cost = 0;
        
        this.customer = null;
    }

    /**Event
     * Constructor for accepting either RENTAL or RETURN events
     * 
     * @param type the type of event
     * @param movie the movie that is being rented or returned
     */
    public Event(EventType type, Movie movie, Customer customer)
    {
        this.type = type;
        this.creationTime = Clock.getTick();
        
        this.movie = movie;
        this.uniqueId = "";
        this.rentalPeriod = 0;
        this.cost = 0;
        
        this.customer = customer;
    }
    
    /**
     * Constructor for accepting CUSTOMER CREATE events
     * 
     * @param type the type of event
     */
    public Event(EventType type, Customer customer)
    {
        this.type = type;
        this.creationTime = Clock.getTick();
        
        this.movie = null;
        this.uniqueId = "";
        this.rentalPeriod = 0;
        
        this.customer = customer;
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
     * Get the customer that is stored in this event
     * 
     * @return the customer that is stored in this event
     */
    public Customer getCustomer()
    {
        return this.customer;
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
     * With the rental period, find the cost for the movie
     * 
     * @param num the length of time to set the rental period to
     */
    public void setRentalPeriod(int num)
    {
        this.rentalPeriod = num;
        //Round up to the next day, then multiply for $1.50 per day
        cost = Math.ceil(rentalPeriod) * 1.5;
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
    
    /**
     * Get the cost of this rental
     * 
     * @return the cost field
     */
    public double getCost()
    {
        return this.cost;
    }
}

