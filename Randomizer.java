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
    
    public int getRand(int numberOfMovies) {
        return rand.nextInt(numberOfMovies) + 1;
    }
}