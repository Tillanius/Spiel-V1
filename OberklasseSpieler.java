import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OberklasseSpieler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OberklasseSpieler extends Actor
{
    /**
     * Blickrichtung Nord
     */
    public final static int NORD = 0;

    /**
     * Blickrichtung Ost
     */
    public final static int OST = 1;

    /**
     * Blickrichtung Sued
     */
    public final static int SUED = 2;

    /**
     * Blickrichtung West
     */
    public final static int WEST = 3;

    protected int blickrichtung;

    /**
     * Act - do whatever the OberklasseSpieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public boolean obenFrei()
    {
        int offsetY = -getImage().getHeight() / 2;
        Object obenBoden = getOneObjectAtOffset(0, offsetY, Boden.class);
        Object obenCheck = getOneObjectAtOffset(0, offsetY, Bodencheck.class);
        return obenBoden == null && obenCheck == null;
    }

    public boolean vornFrei()
{
    int offsetX = 0;
    int offsetY = 0;

    int abstand = getImage().getWidth() / 2;

    if(blickrichtung == OST)
    {
        offsetX = abstand;
    }
    else if(blickrichtung == WEST)
    {
        offsetX = -abstand;
    }
    else if(blickrichtung == NORD)
    {
        offsetY = -abstand;
    }
    else if(blickrichtung == SUED)
    {
        offsetY = abstand;
    }

    Actor obj = getOneObjectAtOffset(offsetX, offsetY, Boden.class);

    if (obj instanceof Hindernis)
    {
        return true; // Hindernis → TRUE
    }

    if (obj != null)
    {
        return false; // normaler Boden → FALSE
    }

    return true; // nichts → TRUE
}
}
