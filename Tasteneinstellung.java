import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tasteneinstellung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tasteneinstellung extends World
{

    private int einstellung;
    
    /**
     * Constructor for objects of class Tasteneinstellung.
     * 
     */
    public Tasteneinstellung()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackgroundColor();
    }
    
    public void setEinstellung(int n){
        einstellung = n;
    }
    
    private void setBackgroundColor()
    {
        GreenfootImage img = new GreenfootImage(getWidth(), getHeight()); //Hintergrund des Menüs wird an Feldgröße angepasst
        img.setColor(new Color(168,205,168)); //Farbe für Hintergrund wird bestimmt
        img.fill(); //Hintergrund Bild wird gefärbt/gefüllt
        setBackground(img); //Weist Hintergrund Bild zu
        img.setColor(new Color(78,181,78)); //Schriftfarbe
        img.setFont(new Font("Arial",false,false,35));//Einstellungen für Schrift
        img.drawString("Drücke eine bliebige Taste", 10,120);
        img.drawString("für die Akion", 10,160);//Menüüberschrift wird erstellt
    }
    
    private void stelleEin(){
        switch(einstellung)
            {
                case 0:
                    Greenfoot.setWorld(new Level(1));
                    break;                
            }
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("a"))
        {
            stelleEin();
        }
    }
}
