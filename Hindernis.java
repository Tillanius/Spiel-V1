import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hindernis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hindernis extends Boden
{
    /**
     * Act - do whatever the Hindernis wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Hindernis(int richtung)
    {
        super();
        if(richtung == 1)
        {
            setImage("Hindernis.png");
        }
        else
        {
            setImage("HindernisUpDown.png");
        }
        //setImage("");
    }
}
