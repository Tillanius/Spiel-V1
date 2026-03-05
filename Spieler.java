import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spieler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spieler extends Actor
{
    private int posX;
    private int posY;
    public int nuesse;
    public int muenzen;

    private final int speed = 6; //Laufgeschwindigkeit
    private final int acceleration = 1; //Variable für die Stärke der Schwerkraft
    private final int sprunghöhe = 14; //Wie hoch der Spieler springen kann
    private int vSpeed = 0; //Aktuelle vertikale Geschwindigkeit des Spielers
    private boolean up = false; // t -> telepotiert über den boden; f -> teleportiert nicht
    
    private int time = 0; //Zeitvariable für Sprungstopp zwischen den Sprüngen
    
    //Countervariablen
    public Counter[] meineCounter = new Counter[3];
    int zeit = 0; //Im Level verbrachte Zeit
    /**
     * Act - do whatever the Spieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        linksLaufen();
        rechtsLaufen();
        springen();
        
        //schwerkraft
        checkFall();
        
        //Zeit zwischen den Sprüngen vergeht, damit keine Fehler entstehen
        if (time > 0)
        {
            time--;
        }
        
        //Im Level verbachte Zeit wird sauber und schön angezeigt
        zeit++;
        if(zeit >= 60){
            realisiereCounter(2); //Counter mit Index 2 ist die Zeit.
            zeit=0;
        }
    }

    
    
    public Spieler(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        muenzen = 0;
        nuesse = 0;
        
        setImage("Knight_flipped.png");
        
        meineCounter[0] = new Counter("Tode: ");
        meineCounter[1] = new Counter("Punkte: ");
        meineCounter[2] = new Counter("Zeit: ");
    }
    
    
    
    private void linksLaufen()
    {
        if(Greenfoot.isKeyDown("d") && vornFrei())
        {
            setImage("Knight_flipped.png");
            move(speed);
        }
    }
    
    private void rechtsLaufen()
    {
        if(Greenfoot.isKeyDown("a") && vornFrei())
        {
            setImage("Knight.png");
            move(-speed);
        }
    }
    
    
    
    public Counter getCounter(int i){
        return meineCounter[i];
    }
    
    private void realisiereCounter(int n){
        meineCounter[n].add(1);
    }
    
    
    
    private void sammeln(Muenze muenze)
    {
        muenzen++;
    }
    
    private void sammeln(Nuss nuss)
    {
        nuesse++;
    }
    
    
    
    private void sterben()
    {
        //open death menue
    }
    
    private boolean amZiel()
    {
        //open endMenue
        return false;
    }
    
    
    
    /**
     *  Überprüft ob der Spieler den Boden berührt
     */
    public boolean onGround()
    {
        //Am unteren Ende des Spielers wird überprüft ob der den Boden berührt.
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, Bodencheck.class);
        return under != null;
    }
    
    /**
     *  Änderung in y-Richtung
     */
    public void fall()
    {
        setLocation (getX(), getY() + vSpeed);
        vSpeed += acceleration;
    }
    
    /**
     *  Implementierung der Schwerkraft
     */
    public void checkFall()
    {
        if (onGround()) {
            vSpeed = 0;
            while(onGround() && up)
            {
                setLocation (getX(), getY() - 1);
            }
            up = false;
        }
        else {
            fall();
        }
    }
    
    private void springen()
    {
        if(Greenfoot.isKeyDown("w") && onGround() && time == 0)
        {
            vSpeed = -sprunghöhe; //Negativ weil nach oben.
            fall();
            time = 28;
            up = true;
        }
    }
    
    
    
    private boolean vornFrei()
    {
        return true;
        //Damit man nicht gegen die Blöcke springen kann
    }
}
