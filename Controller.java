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
    private final int MAX_TICKS = 1001;
    /**
     * Enstantiates all of the objects used in the project
     */
    public Controller()
    {
        actors = new ArrayList<Actor>();
        RedBox mybox = new RedBox();
        CustomerSource source = new CustomerSource(this, mybox);
        Randomizer randomizer = new Randomizer();
        stat = new Stat();
        
        actors.add(source);

    }
    /**
     *  Starts the simulation
     */
    public void run()
    {
        for(int t=0; t< MAX_TICKS; t++) {
            for (int i = 0; i < actors.size(); i++) {
                actors.get(i).act();
            }
            
            if (t % 10 == 0) {
                Stat.printLog();
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
