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
    private Flagge flagge;
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
        
        boden();

        if(level == 1)
        {
            lvl1();
        }
        else if(level == 2)
        {
            lvl2();
        }
        //wprepare();
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

    public void lvl1() //Selma und Milena
    {
        platform(5,0,100);//Startplatform
        platformE(1,128,132);

        platform(2,225,100);//erste landefläche
        platformE(2,225,132);

        platform(2,352,100);//zweite landefläche
        platformE(2,352,132);

        platform(2,512,100);//dritte landefläche
        platformE(2,512,132);

        platform(11,160,162);//Plattform auf der sich die erste Reihe Spikes befindet
        platformE(1,128,162);
        platformE(2,512,162);
        platformE(2,224,162);
        platformE(2,352,162);
        
        //spikes Reihe1
        hindernis(1,160,137);
        hindernis(1,192,137);

        hindernis(1,289,137);
        hindernis(1,320,137);

        hindernis(1,416,137);
        hindernis(1,448,137);
        hindernis(1,480,137);

        platform(18,50,270);
        platformE(1,50,270);
        platformE(1,50,239);
        platform(1,50,208);
        
        //spikes Reihe2
        hindernis(1,512,245);
        hindernis(2,447,187);
        
        hindernis(1,385,245);
        hindernis(2,323,187);
        
        hindernis(1,261,245);
        hindernis(2,199,187);
        
        hindernis(1,137,245);
        
        hindernis(1,199,365); //3.Plattform
        hindernis(1,230,365);
        hindernis(1,261,365);
        hindernis(1,292,365);
        
        //Nüsse
        nuss(225,65); //1.Plattform
        nuss(448,60);
        
        nuss(20,137); //2.Plattform
        nuss(323,235);
        
        nuss(245,320); //3.Plattform
        
        //Zielflagge
        flagge(580,365);//3.Plattform
    }
    
    private void lvl2()
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

        Hindernis hindernis = new Hindernis(1);
        addObject(hindernis,400, 280);

        this.addObject(new Button("LEVEL2","NextLevel"), 500, 40);
    }
    
    /* Erstellt Nüsse für das Spiel 

     */

    public void nuss( int x ,int y) //Selma und Milena

    {
        Nuss nuss =new Nuss(x,y);

        addObject(nuss, x, y);

    }
    
    /* Erstellt Zielflagge für das Spiel
     */

    public void flagge( int x ,int y) //Selma und Milena

    {
        Flagge flagge =new Flagge(x,y);

        addObject(flagge, x, y);

    }

    /* Erstellt Plattformen für das Spiel welche modelierbar sind.
     */
    public void platform(int platformlaenge, int platformstart ,int platformhoehe)//David, Selma und Milena
    {
        for(int i =0;i < platformlaenge; i++ )
        { 
            Boden boden =new Boden();

            addObject(boden,platformstart+ 32*i, platformhoehe);
        }

    }

    /* Erstellt Plattformen für das Spiel welche modelierbar sind.
     */
    public void platformE(int platformlaenge, int platformstart ,int platformhoehe)//David, Selma und Milena
    {
        for(int i =0;i < platformlaenge; i++ )
        { 
            Boden boden =new Boden("erde");

            addObject(boden,platformstart+ 32*i, platformhoehe);
        }
    }
    
    /* Erstellt Plattformen für das Spiel welche modelierbar sind.

     */

    public void hindernis(int ausrichtung, int x ,int y)//Selma und Milena

    {
        Hindernis hindernis =new Hindernis(ausrichtung);

        addObject(hindernis, x, y);

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
