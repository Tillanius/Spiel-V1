import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends World
{

    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        setScene();
        
        this.addObject(new Button("Menue","back"), 50, 25);
    }
    
    private void setScene()
    {
        GreenfootImage img = new GreenfootImage(getWidth(), getHeight()); //Hintergrund des Menüs wird an Feldgröße angepasst
        img.setColor(new Color(168,205,168)); //Farbe für Hintergrund wird bestimmt
        img.fill(); //Hintergrund Bild wird gefärbt/gefüllt
        setBackground(img); //Weist Hintergrund Bild zu
        img.setColor(new Color(78,181,78)); //Schriftfarbe
        img.setFont(new Font("Arial",true,false,66));//Einstellungen für Schrift
        img.drawString("Einstellungen", 85,120); //Menüüberschrift wird erstellt#
        
        img.setFont(new Font("Arial", false, false, 40));
        img.drawString("Links", 60,200); //Menüüberschrift wird erstellt
    }
}
