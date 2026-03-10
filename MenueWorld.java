import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenueWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MenueWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); //Erstellt Feld mit genannten Größen
        setBackgroundColor(); //Weist Feld Hintergrund zu
        this.addObject(new Button(1), 300, 250); //Neuer Button Start an Stelle 100, 220
       
    }
    
    private void setBackgroundColor()
    {
        GreenfootImage img = new GreenfootImage(getWidth(), getHeight()); //Hintergrund des Menüs wird an Feldgröße angepasst
        img.setColor(new Color(168,205,168)); //Farbe für Hintergrund wird bestimmt
        img.fill(); //Hintergrund Bild wird gefärbt/gefüllt
        setBackground(img); //Weist Hintergrund Bild zu
        img.setColor(new Color(78,181,78)); //Schriftfarbe
        img.setFont(new Font("Arial",true,false,66));//Einstellungen für Schrift
        img.drawString("MENÜ", 210,120); //Menüüberschrift wird erstellt
    }
}
