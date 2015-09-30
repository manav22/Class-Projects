
/**
 * Write a description of class PlainBurger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlainBurger extends Burger
{
    // instance variables - replace the example below with your own
    String protein;
    String size;
   
    /**
     * Constructor for objects of class PlainBurger
     */
    public PlainBurger(String protein, String size)
    {
        // initialise instance variables
        this.protein = protein;
        this.size = size;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getDescription()
    {
        // put your code here
        if(size == "small")
        return "1/3 lbs";
        else if(size == "medium")
        return "2/3 lbs";
        else if(size == "large")
        return "1 lb";
        else
        return "not a valid size";
    }
    
    public double getCost()
    {
        double cost = 0;
        if(size == "small")
        {
            cost += 9.50;
        }
        else if(size == "medium")
        {
            cost += 11.50;
        }
        else if(size == "large")
        {
            cost += 15.50;
        }
            return cost;
    }
}