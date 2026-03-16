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
        prepare();
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
        addObject(bodencheck,200, 300);
        
        Bodencheck bodencheck2 = new Bodencheck();
        addObject(bodencheck2,200, 330);
        
        Bodencheck bodencheck3 = new Bodencheck();
        addObject(bodencheck3,400, 330);
        
        Boden boden =new Boden();
        addObject(boden, 200, 300);
        
        Boden boden2 =new Boden();
        addObject(boden2, 400, 300);
        
        Hindernis hindernis = new Hindernis();
        addObject(hindernis,400, 280);
        
        this.addObject(new Button("LEVEL2","NextLevel"), 500, 40);
    }

    private void lvl2()
    {
        platform(5,0,100);
        platform(1,128,132);
        
        platform(2,225,100);
        platform(2,225,132);
        hindernis();
        
        platform(2,352,100);
        platform(2,352,132);
        
        platform(9,128,162);
    }

    /* Erstellt Plattformen für das Spiel welche modelierbar sind.

     */

    public void platform(int platformlaenge, int platformstart ,int platformhoehe)

    {

        for(int i =0;i < platformlaenge; i++ )

        { 

            Bodencheck bodencheck = new Bodencheck();
            Boden boden =new Boden();

            addObject(boden,platformstart+ 32*i, platformhoehe);
            addObject(bodencheck, platformstart+32*i, platformhoehe);
        }

    }
    
    /* Erstellt Plattformen für das Spiel welche modelierbar sind.

     */

    public void hindernis(int ausrichtung, int start ,int hoehe)

    {
        Hindernis hindernis =new Hindernis(ausrichtung);

        addObject(hindernis, start, hoehe);
        

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        platform(2, 3, 333);
        platform(4, 4, 100);
        platform(4, 44, 200);
    }
}
