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
    private String text;
    private Color normalColor = new Color(107,82,16);
    //private Color hoverColor = new Color(228,159,23);
    private Color secondColor = new Color(228,159,23);
    //private Color secondColor = new Color(107,82,16);
    
    /**
     * Constructor for objects of class Button
     */
    public Button(String text)
    {
        this.text = text; //weist Text dem Button zu
        createButton(normalColor); //Button der Farbe normalColor wird erstellt
    }
    
    public void createButton(Color bgColor)
    {
        GreenfootImage img = new GreenfootImage(120,70);//Button der Größe 120, 70 wird bestimmt
        img.setColor(bgColor); //weist Farbe dem Button zu
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Level());
        }
    }
   

    
}
