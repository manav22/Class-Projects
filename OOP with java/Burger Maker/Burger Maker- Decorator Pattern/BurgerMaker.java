
/**
 * Write a description of class BurgerMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurgerMaker
{
    // instance variables - replace the example below with your own
    public static void main(String args[])
    {
 
        Burger burger=new OnABun("","medium");
        System.out.println(burger.getCost());
       
        burger=new PremiumToppings(burger);
        System.out.println(burger.getCost());
        
        Burger burger1=new OnABun("","medium");
        burger1= new CheeseDecorator(burger1);
        burger1.getCost();
        burger1= new CheeseDecorator(burger1);
        System.out.println(burger1.getCost());
        
        Burger burger2=new InABowl("","small");
        burger2= new CheeseDecorator(burger2);
        burger2.getCost();
        burger2= new ToppingsDecorator(burger2);
        burger2.getCost();
        burger2= new ToppingsDecorator(burger2);
        burger2.getCost();
        burger2= new ToppingsDecorator(burger2);
        burger2.getCost();
        burger2= new ToppingsDecorator(burger2);
        burger2.getCost();
        burger2= new ToppingsDecorator(burger2);
        System.out.println(burger2.getCost());
        
        
    }
}
