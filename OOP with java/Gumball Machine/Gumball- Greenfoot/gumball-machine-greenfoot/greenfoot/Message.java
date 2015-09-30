import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    public Message(String text)
    {
        GreenfootImage image = getImage() ;
        image.scale( 120, 120 ) ; 
        image.drawString(text, 24, 56);
    }
    /*
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */
    
    public void act() 
    {
        // Add your action code here.
    }    
}
