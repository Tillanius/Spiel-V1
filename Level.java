import greenfoot.*; 
/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World 
{
    // instance variables - replace the example below with your own
    private int x;
    private Spieler spieler;
    private Nuss nuss;
    /**
     * Constructor for objects of class Level
     */
    public Level(int level)
    {
        super(600, 400, 1);
        
        setBackground("sky.png");
        
        spieler = new Spieler(100, 100);
        addObject(spieler, 100, 100);
        for(int i=0; i<4; i++){
            addObject(spieler.getCounter(i), 50, 10+12*i); //Anzeigen werden in 12 pixel Intervallen geladen nacheinander
        }
        nuss = new Nuss(350,350);
        addObject(nuss, 350, 350);
        boden();
        
        if(level == 1)
        {
            lvl1();
        }
        else if(level == 2)
        {
            lvl2();
        }
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
    
    private void lvl1()
    {
        Bodencheck bodencheck = new Bodencheck();
        Boden boden =new Boden();
        addObject(boden, 200, 300);
        addObject(bodencheck,200, 300);
        
        this.addObject(new Button("LEVEL2"), 300, 250);
    }
    
    private void lvl2()
    {
        
    }
    
    /* Erstellt Plattformen für das Spiel welche modelierbar sind.

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
