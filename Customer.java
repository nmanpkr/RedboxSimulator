import java.util.ArrayList;
import java.util.Random;
/**
 * Customer class for the redbox machine
 * 
 * @author Ryan Gamble and Rich Draper
 * @version 3/3/2017
 */
public class Customer
{
    private String name;
    private ArrayList<Movie> moviesRented;
    private ArrayList<Movie> reserved;
    private Random rand = new Random(); 
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name){
        this.name = name;
        moviesRented = new ArrayList<>();
        reserved = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<Movie> moviesRented(){
        return moviesRented;
    }
    public void act(){
        int n = rand.nextInt(50) + 1; //Randomly generates a number to determine if we will rent/return
        int movieListNum = rand.nextInt(10) + 1; //Randomly generates a number to pick from a list that needs to be created that holds all of the movies
        if(this.getReservations().size() > 0){
            reserved.get(0).rent();
            reserved.remove(0);
        }
        if(n > 0 && n < 6){
            if(mybox.get(movieListNum)!= rented){
                mybox.get(movieListNum).rent();
                mybbx.get(movieListNum).isRented();
                moviesRented.add(movieList.get(movieListNum));
            }else{
                reserved.add(mybox.get(movieListNum));
            }
        }
        else if(n > 5 && n < 11){
            if(moviesRented.size() > 0 ){
                Movie.rent(mybox.get(movieListNum));
                moviesRented.add(mybox.get(movieListNum));
            }
        }
        //if it doesn't get 1-10 than it will do nothing and move on to the next tick
    }
    public ArrayList<Movie> getReservations(){
        return reserved;
    }
}
