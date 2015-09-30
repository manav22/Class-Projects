import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void pickBall()
    {
        int x=Greenfoot.getRandomNumber(3);
        
      World world=getWorld();
       switch(x){
      
           case 0:
           {
               Gumball g = new BlueGumball();

               world.addObject(g, 367, 461);
               
            }
            break;
            case 1:
            {
               Gumball g = new RedGumball();
               
               world.addObject(g, 367, 461);
               
            }
            break;
            case 2:
            {
                Gumball g = new GreenGumball(); 
                
                world.addObject(g, 367, 461);
                
            }
            break;
            default:
            {}
        }
    }
   
            
    public void act() 
    {
        // Add your action code here.
    }    
}
