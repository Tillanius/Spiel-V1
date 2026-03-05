import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Spieler spieler;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("sky.png");
        
        spieler = new Spieler(100, 100);
        addObject(spieler, 100, 100);
        for(int i=0; i<3; i++){
            addObject(spieler.getCounter(i), 50, 10+12*i); //Anzeigen werden in 12 pixel Intervallen geladen nacheinander
        }
        
        boden();
        
        Button button = new Button("Start");
        addObject(button, 300, 200);
    }
    
    private void boden()
    {
        for(int i = 0; i < 20; i++)
        {
            Bodencheck bodencheck = new Bodencheck();
            Boden boden =new Boden();
            addObject(boden, 32*i, 390);
            addObject(bodencheck, 32*i, 390);
        }
    }
    
    

    /**

     * Erstellt Plattformen für das Spiel welche modelierbar sind.

     */

    public void platform(int platformlange, int platformstart ,int plaformhoehe)

    {

     for(int dauer =platformstart;dauer < platformlange; dauer++ )

     { 

        Bodencheck bodencheck = new Bodencheck();
            Boden boden =new Boden();

        addObject(boden, 32*dauer, plaformhoehe);
        addObject(bodencheck, 32*dauer, plaformhoehe);
     }

    }
 
    
}
