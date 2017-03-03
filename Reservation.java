import java.util.ArrayList;
import java.util.Iterator;
/**
 * Keeps track of reservations for any customer
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reservation
{
    private ArrayList<Movie> reservations;

    /**
     * Constructor for objects of class Reservation
     */
    public Reservation()
    {
        reservations = new ArrayList<Moive>();
    }

    /**
     * Returns the collection of Movies that make up the Reservations
     */
    public ArrayList<Movie> getReservations()
    {
        return reservations;
    }

    /**
     * Adds a new movie to the reservations
     * 
     * @param movie The movie that is being added
     */
    public static void addMovie(Movie movie)
    {
        reservations.add(movie);
    }
    
    /**
     * Iterates through the reservations of a customer and removes any movie that matches the searched movie
     */
    public static void removeMovie(Movie search, Customer customer)
    {
        for(Iterator<Movie> it = customer.getResrvations().iterator(); it.hasNext(); )
        {
            it.next();
            if(it.equals(search))
            {
                it.remove();
            }
        }
    }
    
    /**
     * Goal of this method is to check if a movie is avaiable in a customer's reservations and if it is, it rents it.
     * 
     * @param customer The customer whose reservations are being checked
     */
    public static void act(Customer customer) //We need to figure out if the customers are going to be in a collection, or how we can access them from memory
    {
        if(!customer.getReservations().get(0).getRented())
        {
            reservations.get(0).rent();
        }
    }
}