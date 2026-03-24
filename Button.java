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
        /* Jakob: Methode, welche den Buttons die richtige Welt hervorrufen lässt
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
                default: Greenfoot.setWorld(new MenueWorld());
                    break;
            }
        */
        switch(indexNumber) //Adonai: den Buttons wird ein Index gegeben
            {
                case 1:
                    Greenfoot.setWorld(new Level(1));
                    break;                
                case 2:
                    Greenfoot.setWorld(new Level(2));
                    break; 
                case 3:
                    Greenfoot.setWorld(new Einstellungen());
                    break; 
                case 4:
                    Greenfoot.setWorld(new Credits());
                    break; 
                case 10:
                    Greenfoot.setWorld(new Tasteneinstellung());
                    break;
                case 11:
                    Greenfoot.setWorld(new Tasteneinstellung());
                    break;
                case 12:
                    Greenfoot.setWorld(new Tasteneinstellung());
                    break;
                case 13:
                    Greenfoot.setWorld(new Tasteneinstellung());
                    break;
                default: Greenfoot.setWorld(new MenueWorld());
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
}
