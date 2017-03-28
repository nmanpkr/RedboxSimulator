import java.util.Random;
/**
 * Random number generator.
 * 
 * @author Alex Christofides
 * @version N/A
 */
public class Randomizer
{
    private static Random rand = new Random();
    /**
     * Constructor for objects of class Randomizer.
     */
    public Randomizer()
    {
    }

    /**
     * returns random value zero to n (exclusive).
     */
    public static int getRand(int n) {
        return rand.nextInt(n);
    }
}
