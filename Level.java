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
    public static Flagge flagge;
    
    /**
     * Constructor for objects of class Level
     */
    public Level(int level)
    {
        super(600, 400, 1);

        setBackground("sky.png");

        spieler = new Spieler(100, 100, level);
        addObject(spieler, 100, 100);
        for(int i=0; i<4; i++){
            addObject(spieler.getCounter(i), 50, 10+12*i); //Anzeigen werden in 12 pixel Intervallen geladen nacheinander
        }
        
        boden();

        switch(level)
        {
            case 1:
                lvl1();
                Musik3.changeMusik("MusikV1.mp3");
                break;
            case 2:
                lvl2();
                Musik3.changeMusik("MusikV1.mp3"); //Damit die Musik neu startet
                break;
            case 3:
                lvl3();
                Musik3.changeMusik("MusikV1.mp3");
                break;
            case 4:
                Greenfoot.setWorld(new Credits());
                break;
        }
        //wprepare();
    }

    private void boden()
    {
        for(int i = 0; i < 20; i++)
        {
            Boden boden = new Boden();
            addObject(boden, 32*i, 390);
        }
    }

    private void lvl1()
    {
        addObject(new Boden(), 200, 285);
        addObject(new Boden("Erde"), 200, 317);

        addObject(new Boden(), 400, 285);
        addObject(new Boden("Erde"), 400, 317);
        
        addObject(new Boden(), 300, 332);
        addObject(new Boden("Erde"), 300, 364);
        addObject(new Boden("Erde"), 300, 396);
        
        addObject(new Hindernis(1), 400, 260);
        
        nuss(200,250);
        
        flagge = new Flagge(550, 326, 2); //wichtig, damit der Spieler change() aufrufen kann
        addObject(flagge, 550, 326);
        addObject(new Flagge(), 550, 358); //Der untere Mast der Flagge
    }

    public void lvl2() //Selma und Milena
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
        hindernis(3,160,137);
        hindernis(3,192,137);

        hindernis(3,289,137);
        hindernis(3,320,137);

        hindernis(3,416,137);
        hindernis(3,448,137);
        hindernis(3,480,137);

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
        
        hindernis(1,200,365);//3.Plattform
        hindernis(1,230,365);
        hindernis(1,260,365);
        hindernis(1,290,365);
        
        //Nüsse
        nuss(16, 65);
        nuss(241,65);//1.Plattform
        nuss(448,42);
        nuss(350,350);
        nuss(20,137);//2.Plattform
        
        flagge = new Flagge(550,326,3);
        addObject(flagge, 550, 326);
        addObject(new Flagge(), 550, 358);
    }
    
    public void lvl3() //Milena
    {
        platform(5,0,100);//Startplatform
        
        platform(2,224,131);
        platform(2,353,100);
        platform(2,482,131);
        
        platform(4,497,242);//2. Plattform
        
        bewegterHalberBoden(350,219,350,432,1);
        
        platform(5,145,242);
        platform(1,49,242);
 
        platform(3,450,340);
        platformE(3,450,370);
        
        //Hindernisse
        hindernis(1,160,107); //1. Plattform    
            halbePlatform(1,160,123);
        hindernis(1,192,123);
            halbePlatform(1,192,139);
        
        hindernis(1,289,123);
            halbePlatform(1,289,139);
        hindernis(1,321,107);
            halbePlatform(1,321,123);
            
        hindernis(1,418,107);
            halbePlatform(1,418,123);
        hindernis(1,450,123);
            halbePlatform(1,450,139);
            
        
        hindernisPlatform(3,6,305,236); //2. Plattform
            halbePlatform(6,  305,250);
            
        hindernisPlatform(3,2,81,236);
            halbePlatform(2,  81,250);
        
            
        bewegtesHindernis(1,210, 365,210,300,2);//3. Plattform
        
        hindernis(1,419,365);
        
        nuss(482,80);
        nuss(49,205);
        nuss(450,302);
        
        
        flagge = new Flagge(550, 326, 4);
        addObject(flagge, 550, 326);
        addObject(new Flagge(), 550, 358);
    }
    
    /* Erstellt Nüsse für das Spiel
    */
 
    public void bewegterBoden(int x ,int y, int minX, int maxX, int speed) //Milena
 
    {
        Boden boden = new Boden(minX,maxX,speed);
 
        addObject(boden, x, y);
    }
    
    /* Erstellt Nüsse für das Spiel
    */
 
    public void bewegterHalberBoden(int x ,int y, int minX, int maxX, int speed) //Milena
 
    {
        Boden boden = new Boden(minX,maxX,speed);
        boden.setImage("Boden_halb.png");
        addObject(boden, x, y);
    }
    
    
    /* Erstellt Hindernisplattformen für das Spiel welche modelierbar sind.
     */
    public void hindernisPlatform(int ausrichtung,int platformlaenge, int platformstart ,int platformhoehe)//David, Selma und Milena
    {
        for(int i = 0;i < platformlaenge; i++ )
        { 
            Hindernis hindernis= new Hindernis(ausrichtung);
            
            addObject(hindernis, platformstart + 32*i, platformhoehe);
        }
    }
    
    /* Erstellt Plattformen für das Spiel welche modelierbar sind.

     */

    public void nuss( int x ,int y) //Selma und Milena

    {
        Nuss nuss =new Nuss(x,y);

        addObject(nuss, x, y);
    }

    /* Erstellt Plattformen für das Spiel welche modelierbar sind.
     */
    public void platform(int platformlaenge, int platformstart ,int platformhoehe)//David, Selma und Milena
    {
        for(int i =0;i < platformlaenge; i++ )
        { 
            Boden boden =new Boden();

            addObject(boden,  platformstart+ 32*i, platformhoehe);
        }
    }

    public void halbePlatform(int platformlaenge, int platformstart ,int platformhoehe)//David, Selma und Milena
    {
        for(int i =0;i < platformlaenge; i++ )
        { 
            Boden boden =new Boden();
            boden.setImage("Boden_halb.png");
            addObject(boden,  platformstart+ 32*i, platformhoehe);
        }
    }
    
    /* Erstellt Plattformen für das Spiel welche modelierbar sind.
     */
    public void platformE(int platformlaenge, int platformstart ,int platformhoehe)//David, Selma und Milena
    {
        for(int i =0;i < platformlaenge; i++ )
        { 
            Boden boden =new Boden("Erde");

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
    
    public void bewegtesHindernis(int ausrichtung, int x, int y, int minX, int maxX, int speed)//Milena
    {
        Hindernis hindernis = new Hindernis(ausrichtung, minX, maxX, speed);
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
