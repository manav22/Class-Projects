
/**
 * Write a description of class CheeseDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheeseDecorator extends BurgerDecorator
{
    // instance variables - replace the example below with your own
   

    int i = 0;
    Burger tempBurger;
    public CheeseDecorator(Burger tempBurger)
    {
        // initialise instance variables
        this.tempBurger = tempBurger;
    }

  
    public String getDescription()
    {
        return tempBurger.getDescription() + "adding Cheese";
    }
    
    public double getCost()
    {
        
        if (i==0)
        {
            i++;
        return tempBurger.getCost();
        
    }
        else
        {
            i++;
        return (tempBurger.getCost() + 1.00);
    }
       
        
    }
}
