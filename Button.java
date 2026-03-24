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
    
    private final boolean ON = true;
    private final boolean OFF = false;
    
    private boolean onOff = ON;
    
    /**
     * Constructor for objects of class Button
     */
    public Button(String text, String Image)
    {
        this.text = text; //weist Text dem Button zu
        createButton(normalColor); //Button der Farbe normalColor wird erstellt

        setImage(Image+".png");
        GreenfootImage image = getImage();
        image.scale(100,45);
        setImage(image);
    }
    
    public Button(String text, String Image, boolean onOrOff)
    {
        this.text = text; //weist Text dem Button zu
        createButton(normalColor); //Button der Farbe normalColor wird erstellt

        setImage(Image+".png");
        GreenfootImage image = getImage();
        image.scale(100,45);
        setImage(image);
        
        onOff = onOrOff;
    }
    
    public void createButton(Color bgColor)
    {
        GreenfootImage img = new GreenfootImage(120,70);//Button der Größe 120, 70 wird bestimmt
        img.setColor(bgColor); //weist Farbe dem Button zu
    }

    private void fuehreAktionDurch(){
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
                    toggle();
                    break;
                case "SoundFX":
                    toggle();
                    break;
                    
                default: Greenfoot.setWorld(new MenueWorld());
                    break; 
            }
    }
    
    public void toggle()
    {
        if(onOff == ON)
        {
            onOff = OFF;
        }
        else if(onOff == OFF)
        {
            onOff = ON;
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
