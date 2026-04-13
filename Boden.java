import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
* Write a description of class Boden here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Boden extends Weltblöcke
{
    private int speed = 0;
    private int minX, maxX;
    private boolean bewegt = false;
 
    /**
     * Act - do whatever the Boden wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (bewegt) 
        {
            bewegen();
        }
    }
 
    //KONSTRUKTOR für "normalen" Boden
    public Boden()
    {
        setImage("boden.png");
    }
    
    public Boden(String erde)
    {
        setImage("erde.png");
    }
 
    //Konstruktor für bewegten Boden
    public Boden(int minX, int maxX, int speed)//Milena
    {
        setImage("boden.png");
        this.minX = minX;
        this.maxX = maxX;
        this.speed = speed;
        this.bewegt = true;
    }
 
    //GETTER
    public int getSpeed()//Milena
    {
        return speed;
    }
 
    //Methoden
    private void bewegen() //Milena
    {
        // setLocation() verschiebt das Objekt in der Welt auf neue Koordinaten.
        // getX() = aktuelle X-Position, getY() = aktuelle Y-Position
        // Hier wird die X-Position um "speed" verändert, die Y-Position bleibt gleich.
        setLocation(getX() + speed, getY());
 
        // Prüfen, ob das Objekt die linke oder rechte Grenze erreicht hat
        if (getX() <= minX || getX() >= maxX) 
        {
            // Wenn ja, kehrt es die Richtung um, indem das Vorzeichen von speed geändert wird
            speed = -speed;
        }
    }
}