import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    private Coin coin;
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }
       
    public void act() 
    {
        Actor tempCoin;

        tempCoin = getOneObjectAtOffset(0,0,Coin.class);
        if(tempCoin != null)
        {     
            World world;
            world = getWorld();
            world.removeObject(coin);
            world.addObject(new Message("Have a coin!"), 495,68);
            coin = (Coin) tempCoin;
        }
        
        if(Greenfoot.mousePressed(this) && coin != null)
        {
           List<Inspector> inspectorList = getIntersectingObjects(Inspector.class);
           Inspector i= inspectorList.get(0);
           i.isValidCoin(coin);
           coin = null;
        }
    }
}