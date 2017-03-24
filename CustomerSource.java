
/**
 * Write a description of class CustomerSource here.
 * 
 * @author (Matt Slossar) 
 * @version (3/24/17)
 */
public class CustomerSource
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
        if(tick < 10)
        {
            createCustomer(name);
        }
        else if(tick%5 == 0)
        {
            createCustomer(name);
        }
    }
    
    /**
     * Creates the actual customer
     */
    private void createCustomer(String name)
    {
        controller.actorAdd(new Customer("Frank Reynolds", redBox));
    }
}
