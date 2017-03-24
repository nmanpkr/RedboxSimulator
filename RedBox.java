import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class RedBox here.
 * 
 * @author (Jeffrey Podwats) 
 * @version (a version number or a date)
 */
public class RedBox
{
    private ArrayList<Movie> myBox;
    /**
     * Constructor for objects of class RedBox
     */
    public RedBox() //throws Exception
    {
        myBox = new ArrayList<>();
        fillRedBox();
    }

     
    public void fillRedBox()
    {
     
        try{
            File file = new File("movies.txt");
            BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
            String line = br.readLine();
            
            while(line!=null){
                myBox.add(new Movie(line));
                line = br.readLine();
            }
            br.close();
        }
        catch(Exception e)
       {}
        
        for(int i=0; i<myBox.size(); i++)
        {
            System.out.println(myBox.get(i));
        }
    }
}
