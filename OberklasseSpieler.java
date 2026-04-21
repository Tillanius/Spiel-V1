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
    
    //Bewegung
    public boolean vornFrei() {
        // return true;
        
        int x = getX();
        int y = getY();
        switch (blickrichtung) {
        case SUED:
            y++;
            break;
        case OST:
            x++;
            break;
        case NORD: 
            y--;
            break;
        case WEST:
            x--;
            break;
        }
    
        if (x >= getWorld().getWidth() || y >= getWorld().getHeight() || x < 0
                || y < 0) {
            return false;
        }
    
        return getWorld().getObjectsAt(x, y, Boden.class).size() == 0;
    }
    
    //Berührt der Spieler...
    //... eine Falle
    protected boolean headHitsTrap()
    {
        //Über dem Spieler wird geprüft, ob ein Bodenobjekt ist
        Object above = getOneObjectAtOffset(0, -getImage().getHeight()/2 +3, Hindernis.class);
        return above != null;
    }
    
    /**
     *  Überprüft ob der Spieler eine Falle berührt
     */
    protected boolean onTrap()
    {
        //Am unteren Ende des Spielers wird überprüft ob eine Falle berührt wird.
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2, Hindernis.class);
        return under != null;
    }

    //... den Boden   
        protected boolean headHitsGround(int a)
    {
        //Über dem Spieler wird geprüft, ob ein Bodenobjekt ist
        Object above = getOneObjectAtOffset(0, -getImage().getHeight()/2 +a, Boden.class);
        return above != null;
    }
    
    /**
     *  Überprüft ob der Spieler den Boden berührt
     */
    protected boolean onGround()
    {
        //Am unteren Ende des Spielers wird überprüft ob der den Boden berührt.
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 - 2, Boden.class);
        return under != null;
    }
    
    protected void mitBlock()
    {
        // Prüft, ob ein Boden-Block direkt unter dem Spieler ist
        Actor block = getOneObjectAtOffset(0, getImage().getHeight()/2, Boden.class);

        if (block != null) 
        {
            // Spieler steht auf einem Block, also soll er mit dem Block mitfahren
            // Sicherstellen, dass das Objekt auch tatsächlich ein Boden-Block ist
            if (block instanceof Boden) 
            {
                // speed des Blocks abfragen
                int speed = ((Boden)block).getSpeed();

                // Spieler horizontal um die gleiche Geschwindigkeit bewegen wie der Block
                setLocation(getX() + speed, getY());
            }
        }
    }
}
