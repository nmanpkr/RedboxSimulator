import java.util.ArrayList;
/**
 * This is the main controller of the Redbox simulator. It 
 * 
 * @author Kiernan McCormick, Bryan P
 * @version Skeleton
 */
public class Controller
{
    private ArrayList<Actor> actors;
    private Stat stat;
    private final int MAX_TICKS = 1000;
    /**
     * Enstantiates all of the objects used in the project
     */
    public Controller()
    {
        actors = new ArrayList<Actor>();
        CustomerSource source = new CustomerSource(this);
        RedBox myBox = new RedBox();
        stat = new Stat();
        
        actors.add(source);

    }
    /**
     * Takes one step/tick of the simulation
     */
    public void run()
    {
        for(int t=0; t< MAX_TICKS; t++) {
            for(Actor actor : actors){
                actor.act();
            }
            Clock.clockTick();
        }
    }
    
    /**
     * Called by CustomerSource on creation of a new customer.
     * Adds customer to the list of actors.
     */
    public void actorAdd(Actor a)
    {
        actors.add(a);
    }
}
