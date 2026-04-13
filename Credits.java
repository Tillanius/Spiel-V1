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
        img.drawString("Credits", 180 ,100); //Menüüberschrift wird erstellt#
        img.setFont(new Font("Arial",true,false,33));//Einstellungen für Schrift
        img.drawString("Credits gehen an:",160,150);
        img.setFont(new Font("Arial",true,false,27));//Einstellungen für Schrift
        img.drawString("Adonai Gonzales",40,200);
        img.drawString("Till Kruse",40,250);
        img.drawString("Henri Bartolomäus",40,300);
        img.drawString("David Noske",40,350);
        img.drawString("Jakob Kringel",340,200);
        img.drawString("Selma Korb",340,250);
        img.drawString("Milena Kvasnicka",340,300);
    }
}
