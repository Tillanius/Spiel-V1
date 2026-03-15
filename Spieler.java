import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spieler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spieler extends OberklasseSpieler
{
    private int posX;
    private int posY;
    public int nuesse;
    public int muenzen;

    private int waitTime = 30;
    private int coolDownCounter = waitTime;
    private boolean doCoolDown;
    
    private final int dashSpeed = 20;
    
    private final int speed = 6; //Laufgeschwindigkeit
    private final int acceleration = 1; //Variable für die Stärke der Schwerkraft
    private final int sprunghöhe = 14; //Wie hoch der Spieler springen kann
    private int vSpeed = 0; //Aktuelle vertikale Geschwindigkeit des Spielers
    
    private int time = 0; //Zeitvariable für Sprungstopp zwischen den Sprüngen
    
    //Countervariablen
    public Counter[] meineCounter = new Counter[4];
    int zeit = 0; //Im Level verbrachte Zeit
    
    private boolean checkFall = true;
    /**
     * Act - do whatever the Spieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        linksLaufen();
        rechtsLaufen();
        springen();
        sammeln();
        
        //Dash
        linksDash();
        rechtsDash();
        coolDown();
        
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
            realisiereCounter(3); //Counter mit Index 2 ist die Zeit.
            zeit=0;
        }
        
        
        if(vSpeed > 2)
        {
            checkFall = true;
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
        meineCounter[2] = new Counter("Nüsse: ");
        meineCounter[3] = new Counter("Zeit: ");
    }
    
    
    private void linksLaufen()
    {
        if(Greenfoot.isKeyDown("d") && vornFrei())
        {
            setImage("Knight_flipped.png");
            move(speed);
        }
    }
    
    private void linksDash()
    {
        if(Greenfoot.isKeyDown("f") && vornFrei() && coolDown() == true)
        {
            setImage("Knight_flipped.png");
            move(dashSpeed);
            doCoolDown = true;
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
    
    private void rechtsDash()
    {
        if(Greenfoot.isKeyDown("y") && vornFrei() && coolDown() == true)
        {
            setImage("Knight.png");
            move(-dashSpeed);
 
            doCoolDown = true;
        }
    }
    
    public boolean coolDown()
    {
        boolean coolDownDone = true;
        if(doCoolDown == true)
        {
            coolDownDone = false;
            coolDownCounter--;
            if(coolDownCounter <= 0){
                doCoolDown = false;
            }
        }
        else {
            coolDownDone = true;
            coolDownCounter = waitTime;
        }
        return coolDownDone;
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
    
    private void sammeln()
    {
        Actor nuss = getOneIntersectingObject(Nuss.class);
        if(nuss != null)
        {
            getWorld().removeObject(nuss);
            realisiereCounter(2);
        }
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
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 - 3, Bodencheck.class);
        return under != null;
    }
    
    public boolean headHitsGround()
    {
        //Über dem Spieler wird geprüft, ob ein Bodenobjekt ist
        Object above = getOneObjectAtOffset(0, -getImage().getHeight()/2 - 3, Bodencheck.class);
        return above != null;
    }

    /**
     *  Überprüft ob der Spieler eine Falle berührt
     */
    public boolean onTrap()
    {
        //Am unteren Ende des Spielers wird überprüft ob eine Falle berührt wird.
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 - 3, Hindernis.class);
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
            while(onGround() && checkFall)
            {
                setLocation(getX(), getY() - 1);
            }
            checkFall = false;
        }
        else {
            if (onTrap()) {
            Greenfoot.stop();
        }
        else {
            fall();
        }
        }
    }
    
    private void springen()
    {
        if(Greenfoot.isKeyDown("w") && onGround() && time == 0 && !headHitsGround())
        {
            vSpeed = -sprunghöhe; //Negativ weil nach oben
            fall();
            time = 28;
            checkFall = true;
        }
    }
}
