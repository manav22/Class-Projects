import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Picker p;
    public void act() 
    {
        // Add your action code here.
    }    
    public boolean isValidCoin(Actor coin)
    {
           World world;
           world=getWorld();
            if (coin instanceof Quarter)
                {
                    if(coin instanceof FakeQuarter)
                    {
                        
                    world.addObject(new Message("Fake Quarter"), 495, 68);
            
                    }
                    else{
                    List<Picker> pickerList=world.getObjects(Picker.class);
                    Picker p = pickerList.get(Greenfoot.getRandomNumber(2));
                    p.pickBall();
                   world.addObject(new Message("Gumball Ejected!"), 495,68);
                        
                      // world.addObject(new RedGumball(), 400,500);  
                    
                    }
            
                }
            
            
            else{
               
                world.addObject(new Message("It's a penny!"), 495,68);
            
                }
         return true;
                
    }
}
