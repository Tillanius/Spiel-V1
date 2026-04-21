import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
* Write a description of class Hindernis here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
 
public class Hindernis extends Boden
{
    
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
        
    }
 
   
}