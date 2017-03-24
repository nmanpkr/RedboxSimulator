import java.util.Random;
/**
 * Random number generator.
 * 
 * @author Alex Christofides
 * @version N/A
 */
public class Randomizer
{
    private Random rand;
    /**
     * Constructor for objects of class Randomizer.
     */
    public Randomizer()
    {
        rand = new Random();
    }
    
     /**
     * returns random value zero to n (exclusive).
     */
    public int getRand(int n) {
        return rand.nextInt(n) ;
    }
}
