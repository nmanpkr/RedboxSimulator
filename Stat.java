import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.Collections;

/**
 * Statistics class for gathering events and calculating statistics
 * 
 * @author Patrick Richeal, Emily Provine, Alex Christofides
 * @version 3/3/2017
 */
public class Stat
{
    private static ArrayList<Event> events = new ArrayList<>();

    /**
     * Method for sending an event for the following event types
     *      EventType.RENTAL
     *      EventType.RETURN
     *      
     * @param type the type of the event being sent
     * @param movie the movie that is being rented or returned
     */
    public static void sendEvent(EventType type, Movie movie)
    {
        if (type == EventType.RENTAL) {
            //Check to make sure movie isn't currently rented
            //If it is not, add it to the events list
            if (!Stat.isMovieCurrentlyRented(movie)) {
                events.add(new Event(EventType.RENTAL, movie));
            }
        } else if (type == EventType.RETURN) {
            //Check to make sure movie is actually rented
            //If it is, add it to the events list
            if (Stat.isMovieCurrentlyRented(movie)) {
                events.add(new Event(EventType.RETURN, movie));
                
                //Get the return event
                Event returnEvent = events.get(events.size() - 1);
            
                //Find this return event's corresponding rental event
                Event rentalEvent = Stat.getCorrespondingRental(returnEvent);
                
                //If we have found a corresponding rental event...
                if (rentalEvent != null) {
                    //Generate a unique ID to pair the rental event with the return event
                    String uniqueId = UUID.randomUUID().toString();
                    
                    //Set the rental and return event to the unique id
                    rentalEvent.setUniqueId(uniqueId);
                    returnEvent.setUniqueId(uniqueId);
                    
                    //Set the rental events creations time
                    returnEvent.setRentalPeriod(returnEvent.getCreationTime() - rentalEvent.getCreationTime());
                    
                    //Calculate time difference from creation of rental event and creation of corresponding return event
                    long timeDifference = returnEvent.getCreationTime() - rentalEvent.getCreationTime();
                }
            }
        }
    }
    
    /**
     * Method for sending an event for the following event types
     *      EventType.CUSTOMER_CREATE
     *      
     * @param type the type of the event being sent
     */
    public static void sendEvent(EventType type)
    {
        if (type == EventType.CUSTOMER_CREATE) {
            events.add(new Event(EventType.CUSTOMER_CREATE));
        }
    }
    
    /**
     * Check if a movie is currently rented
     * 
     * @param movie the movie to check
     * @return true if the movie is currently rented
     */
    private static boolean isMovieCurrentlyRented(Movie movie)
    {
        for (int i = events.size() - 1; i >= 0; i--) {
            Event currentEvent = events.get(i);
            if (currentEvent.getMovie() == movie) {
                if (currentEvent.getType() == EventType.RENTAL) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    /**
     * Method for searching through the current Events in the events list and
     * finding the corresponding rental to a return event
     * 
     * @param returnEvent the return event to find the corresponding rental event of
     * @return the corresponding rental event
     */
    private static Event getCorrespondingRental(Event returnEvent)
    {
        for (Event e : events) {
            if (e.getMovie() == returnEvent.getMovie() && e.getUniqueId().equals("")) {
                return e;
            }
        }
        return null;
    }
    
    /**
     * Get a list of the rental periods
     * 
     * @return an ArrayList<Long> of rental period
     */
    private static ArrayList<Long> getRentalPeriods()
    {
        ArrayList<Long> rentalPeriods = new ArrayList<>();
        for (Event e : events) {
            if (e.getType() == EventType.RETURN && e.getRentalPeriod() != 0) {
                rentalPeriods.add(e.getRentalPeriod());
            }
        }
        return rentalPeriods;
    }

    /**
     * Method for finding the total number of customers
     *
     * @return the total number of customers
     */
    public static int getTotalIndividualCustomers()
    {
        int count = 0;
        for(Event event : events)
        {
            if(event.getType() == EventType.CUSTOMER_CREATE)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Goes through the events and find the total number of 
     *  rentals to date
     *
     * @return the total number of rentals
     */
    public static int getTotalRentalsToDate()
    {
        int count = 0;
        for(Event event : events)
        {
            if(event.getType() == EventType.RENTAL)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Method for finding the number of movies currently rented
     *
     * @return the number of rented movies
     */
    public static int getTotalRentalsCurrentlyOut()
    {
        int count = 0;
        for(Event event : events)
        {
            if(event.getType() == EventType.RENTAL && event.getUniqueId() == "")
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Method for finding the average length of a rental period
     * 
     * @return the average rental period
     */
    public static long getAverageRentalPeriod()
    {
        long sum = 0;
        if (!Stat.getRentalPeriods().isEmpty()) {
            for (Long l : Stat.getRentalPeriods()) {
                sum += l;
            }
            return sum / Stat.getRentalPeriods().size();
        }
        return sum;
    }
    
    /**
     * Method for finding the shortest rental period
     * 
     * @return the shortest rental period
     */
    public static long getShortestRentalPeriod()
    {
        long shortest = 0;
        if (!Stat.getRentalPeriods().isEmpty()) {
            shortest = Stat.getRentalPeriods().get(0);
            for (Long l : Stat.getRentalPeriods()) {
                if (l < shortest) {
                    shortest = l;
                }
            }
        }
        return shortest;
    }
    
    /**
     * Method for finding the longest rental period
     * 
     * @return the longest rental period
     */
    public static long getLongestRentalPeriod()
    {
        long longest = 0;
        if (!Stat.getRentalPeriods().isEmpty()) {
            longest = Stat.getRentalPeriods().get(0);
            for (Long l : Stat.getRentalPeriods()) {
                if (l > longest) {
                    longest = l;
                }
            }
        }
        return longest;
    }
}
