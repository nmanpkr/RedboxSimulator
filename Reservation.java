import java.util.ArrayList;
import java.util.Iterator;
/**
 * Keeps track of reservations for any customer
 * 
 * @author (Matt) 
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
        reservations = new ArrayList<Movie>();
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
    public void addMovie(Movie movie, Customer customer)
    {
        customer.getReservations().add(movie);
    }

    /**
     * Iterates through the reservations of a customer and removes any movie that matches the searched movie
     */
    public static void removeMovie(Movie search, Customer customer)
    {
        for(Iterator<Movie> it = customer.getReservations().iterator(); it.hasNext(); )
        {
            it.next();
            if(it.equals(search))
            {
                it.remove();
            }
        }
    }
}