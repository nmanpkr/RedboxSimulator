import java.util.List;
/**
 * This is the main controller of the Redbox simulator. It 
 * 
 * @author Kiernan McCormick, Brian P, Brain S
 * @version Skeleton
 */
public class Controller
{
    private List<Customer> actor; // Will be a list of all actors, since customer is the only actor, the list will be of customer
    /**
     * Enstantiates all of the objects used in the project
     */
    public Controller()
    {
        actor = new List<Customer>();
        Customer customer = new Customer();
        actor.add(customer);
        Reservation reserve = new Reservation();
        Event events = new Event();
        
        Clock timer = new Clock(); 
    }
    /**
     * Takes one step/tick of the simulation
     */
    public void step()
    {
        for(Actor actor : actors ){
            actor.act();
        }
        Clock.clockTick();
    }
}
