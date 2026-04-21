import greenfoot.*;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor 
{
    // instance variables - replace the example below with your own
    //Selma und Milena
    private String text;
    
    private int indexNumber;
    
    private boolean on = true;
    /**
     * Constructor for objects of class Button
     */
    public Button(String text, String Image)//Selma und Milena
    {
        this.text = text; //weist Text dem Button zu
        

        setImage(Image+".png");
        GreenfootImage image = getImage();
        image.scale(100,45);
        setImage(image);
    }

    /**
     * Es wird einen Index gegeben, welcher für die Druchfuehrung der Aktion wichtig ist
     * Selma und Milena
     */public Button(String text, String Image, int index) 
    {
        this.text = text; //weist Text dem Button zu
        indexNumber = index;
        
        setImage(Image+".png");
        GreenfootImage image = getImage();
        image.scale(100,45);
        setImage(image);
    }

    private void fuehreAktionDurch(){
         //Jakob: Methode, welche den Buttons die richtige Welt hervorrufen lässt
        switch(text)
            {
                case "START":
                    Greenfoot.setWorld(new Level(1));
                    break;                
                case "LEVEL2":
                    Greenfoot.setWorld(new Level(2));
                    break; 
                case "Settings":
                    Greenfoot.setWorld(new Einstellungen());
                    break; 
                case "Credits":
                    Greenfoot.setWorld(new Credits());
                    break; 
                case "Musik":
                    on = !on;
                    setImage("Musik."+on+".png");
                    Musik3.musikON = on;
                    musicOnOff();
                    break;
                case "SoundFX": 
                    on = !on;
                    setImage("Sound."+on+".png");
                    break;
                    
                default: switch(indexNumber) //Adonai: den Buttons wird ein Index gegeben
                {
                    case 10:
                        Greenfoot.setWorld(new Tasteneinstellung(0));
                        break;
                    case 11:
                        Greenfoot.setWorld(new Tasteneinstellung(1));
                        break;
                    case 12:
                    Greenfoot.setWorld(new Tasteneinstellung(2));
                        break;
                    case 13:
                        Greenfoot.setWorld(new Tasteneinstellung(3));
                        break;
                    default: Greenfoot.setWorld(new MenueWorld());
                        break;
                }
                break;
            }
        
    } 
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            fuehreAktionDurch();
        }
    }
    
    private void musicOnOff()
{
    Musik3.musikON = !Musik3.musikON;

    if(Musik3.musikON)
    {
        Musik3.music.pause();
    }
    else
    {
        
        Musik3.music.playLoop();
    }
}
}
