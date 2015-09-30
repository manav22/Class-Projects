
/**
 * Write a description of class OnBun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OnABun extends PlainBurger
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class OnBun
     */
    public OnABun(String protein, String size)
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
        System.out.println("Burger cost on a bun");
        return super.getCost();
    }
}
