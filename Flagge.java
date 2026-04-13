import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flagge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flagge extends Weltblöcke
{
    private int posX;
    private int posY;
    
    private int level;
    
    private static String image;
    private static final String checkImage = "flagge_unten.png";
    
    public Flagge (int posX, int posY, int level)
    {
        super();
        setImage("flagge_unten.png");
        image = "flagge_unten.png";
        this.level = level;
    }
    
    public Flagge()
    {
        super();
        setImage("flaggeStamm.png");
    }
    
    public void change()
    {
        if(image == checkImage)
        {
            setImage("flagge.png");
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Level(level));
        }
    }
}