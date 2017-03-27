import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class NameGenerator here.
 * 
 * @author Emily Provine
 * @version 3.24.17
 */
public class NameGenerator
{
    private ArrayList<String> firstNames;
    private ArrayList<String> lastNames;
    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator()
    {
        firstNames = new ArrayList<String>();
        lastNames = new ArrayList<String>();
        try {
            fillNames();
        }
        catch (Exception e)
        {}
    }

    public void fillNames() throws Exception
    {
        File names = new File("FirstNames.txt");
        Scanner scan1 = new Scanner(names);
        while (scan1.hasNextLine())
        {
            firstNames.add(scan1.nextLine());
        }
        names = new File("LastNames.txt");
        Scanner scan2 = new Scanner(names);
        while (scan2.hasNextLine())
        {
            lastNames.add(scan2.nextLine());
        }
    }
    
    public String generateName()
    {
        Randomizer randomizer = new Randomizer();
        String firstName = firstNames.get(randomizer.getRand(100));
        String lastName = lastNames.get(randomizer.getRand(60));
        return firstName + " " + lastName;
    }
}
