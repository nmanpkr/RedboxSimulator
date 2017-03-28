
/**
 * Write a description of class CustomerSource here.
 * 
 * @author (Matt Slossar) 
 * @version (3/24/17)
 */
public class CustomerSource implements Actor
{
    // instance variables - replace the example below with your own
    private Controller controller;
    private RedBox redBox;

    /**
     * Constructor for objects of class CustomerSource
     */
    public CustomerSource(Controller controller, RedBox redBox)
    {
        this.controller = controller;
        this.redBox = redBox;
    }

    /**
     * Creates new customers every 5 ticks
     * 
     */
    public void act()
    {
        if(Clock.getTick()%5 == 0 && Clock.getTick()> 10)
        {
            createCustomer();
        }
    }

    /**
     * Creates the actual customer
     */
    private void createCustomer()
    {
        controller.actorAdd(new Customer("Frank Reynolds", redBox));
    }
    
    public void createInitial()
    {
        for(int i = 0; i < 11; i++)
        {
            createCustomer();
        }
    }
}
