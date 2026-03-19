import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nuss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nuss extends Sammelitems
{
    private int posX;
    private int posY;
    
    private int nussbild;
    
    private int etwasLangsamer = 0;
    
    public Nuss(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;        
        setImage("MrNut1.png");
        nussbild = 1;
    }
    
    /**
     * Act - do whatever the Nuss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //change Grafik
        nextImage();
    }
    
    public void nextImage()
    {
        setImage("MrNut"+nussbild+".png");
        if(etwasLangsamer < 1)
        {
            if(nussbild<13)
            {
                nussbild++;
            }
            else
            {
                nussbild = 1;
            }
            etwasLangsamer = 1;
        }
        else
        {
            etwasLangsamer--;
        }
    }
}
