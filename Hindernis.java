import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
* Write a description of class Hindernis here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
 
public class Hindernis extends Boden
{
    private int speed = 0;
    private int minX, maxX;
    private boolean bewegt = false;
 
    public void act()//Milena
    {
        if (bewegt) {
            bewegen();
        }
    }
 
    public Hindernis(int richtung) //Jakob
    {
        super();
        switch(richtung)
        {
            case 1:
                setImage("spikes.png");
                break;
            case 2:
                setImage("spikes180.png");
                break;
            case 3:
                setImage("spikescon.png");
                break;
            case 4:
                setImage("spikes180con.png");
                break;
                
            default:
                setImage("spikes.png");
                break;
        }
        
        GreenfootImage image = getImage();
        image.scale(32,19);
        setImage(image);
    }
 
    //NEUER Konstruktor für bewegliche Hindernisse
    public Hindernis(int richtung, int minX, int maxX, int speed)//Milena
    {
        this(richtung); // nutzt den bestehenden Konstruktor
        this.minX = minX;
        this.maxX = maxX;
        this.speed = speed;
        this.bewegt = true; //Wenn dieser Konstruktor aufgerufen wird, bewegt sich das Objekt
    }
 
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