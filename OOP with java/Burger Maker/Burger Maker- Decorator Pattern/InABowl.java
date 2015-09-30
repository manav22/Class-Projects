
/**
 * Write a description of class InABowl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InABowl extends PlainBurger
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class InABowl
     */
    public InABowl(String protein, String size)
    {
        // initialise instance variables
        super(protein, size);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double cost()
    {
        // put your code here
        System.out.println("In a bowl burger cost");
       return (super.getCost() + 1.00);
    }
}
