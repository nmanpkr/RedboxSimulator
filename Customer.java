import java.util.ArrayList;
import java.util.Random;
/**
 * Customer class for the redbox machine
 * 
 * @author Ryan Gamble and Rich Draper
 * @version 3/3/2017
 */
public class Customer implements Actor
{
    //declaration of variables
    private String name;
    private ArrayList<Movie> moviesRented;
    private ArrayList<Movie> reserved;
    private RedBox myBox;
    private Random rand = new Random(); 
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name, RedBox myBox){
        //instantiating variables
        this.name = name;
        this.myBox=myBox;
        moviesRented = new ArrayList<>();
        reserved = new ArrayList<>();
    }

    public String getName(){
        return name; //used to return customer's name
    }

    public ArrayList<Movie> moviesRented(){
        return moviesRented; //returns the movieRented list
    }

    public void act(){
        int n = Randomizer.getRand(10); //Randomly generates a number to determine if we will rent/return
        int movieListNum = Randomizer.getRand(50); //Randomly generates a number to pick from a list that needs to be created that holds all of the movies
        if(this.getReservations().size() > 0){
            reserved.get(0).rent(this);
            reserved.remove(0);
        }
        
        if(n > 0 && n < 6){
            if(myBox.getRedBox().get(movieListNum).isRented()!= true){
                myBox.getRedBox().get(movieListNum).rent(this);
                myBox.getRedBox().get(movieListNum).isRented();
                moviesRented.add(myBox.getRedBox().get(movieListNum));
            }else{
                reserved.add(myBox.getRedBox().get(movieListNum));
            }
        }
        else if(n > 5 && n < 11){
            if(moviesRented.size() > 0 ){
                myBox.getRedBox().get(movieListNum).rent(this);
                moviesRented.add(myBox.getRedBox().get(movieListNum));
            }
        }
        //if it doesn't get 1-10 than it will do nothing and move on to the next tick
    }

    public ArrayList<Movie> getReservations(){
        return reserved; //returns this customer's list of reservations
    }
}
