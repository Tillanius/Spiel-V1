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

    private int blickrichtung;
    
    /**
     * Act - do whatever the OberklasseSpieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public boolean vornFrei() {
        return true;
        
        // int x = getX();
        // int y = getY();
        // switch (blickrichtung) {
        // case SUED:
            // y++;
            // break;
        // case OST:
            // x++;
            // break;
        // case NORD:
            // y--;
            // break;
        // case WEST:
            // x--;
            // break;
        // }
    
        // if (x >= getWorld().getWidth() || y >= getWorld().getHeight() || x < 0
                // || y < 0) {
            // return false;
        // }
    
        // return getWorld().getObjectsAt(x, y, Boden.class).size() == 0;
    }
}
