import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private static final Color TEXT_COLOR = new Color(0,0,0);
    private static final int HEIGHT = 16;
    private static final int PADDING_X = 2;
    private static final int BASELINE_Y = 12;
    
    
    private int value = 0;
    private String text;
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Counter(String prefix){
        this.text = prefix;
        
        int width = (this.text.length() + 2) * 10; //Länge des Bildes wird festgelegt, abhängig von der Textlänge
        setImage(new GreenfootImage(width, HEIGHT)); //Größe des Bildes wird vorgegeben
        GreenfootImage image = getImage(); //Bild wird gesucht
        image.setColor(TEXT_COLOR);
        updateImage(); //Bild wird eingefügt
    }
    
    public void add(int score){
        value = value + score;
        updateImage();
    }
    
    private void updateImage() {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, PADDING_X, BASELINE_Y);
    }
}
