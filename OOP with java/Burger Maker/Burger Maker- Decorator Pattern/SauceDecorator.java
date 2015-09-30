
/**
 * Write a description of class SauceDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SauceDecorator extends BurgerDecorator
{
    int i = 0;
    Burger tempBurger;
    public SauceDecorator(Burger tempBurger)
    {
        
        this.tempBurger = tempBurger;
    }

  
    public String getDescription()
    {
        return tempBurger.getDescription() + "adding Sauce";
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
        return(tempBurger.getCost() + 0.75);
    }
       
        
    }
}
