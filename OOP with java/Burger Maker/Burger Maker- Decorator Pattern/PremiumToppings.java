
/**
 * Write a description of class PremiumToppings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PremiumToppings extends BurgerDecorator
{
    // instance

    Burger tempBurger;
    public PremiumToppings(Burger tempBurger)
    {
        this.tempBurger = tempBurger;
    }

  
    public String getDescription()
    {
        return tempBurger.getDescription() + "adding Sauce";
    }
    
    public double getCost()
    {
           
        return(tempBurger.getCost() + 1.50);
    }
       
        
    
}

