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
    private Level level;

    private int waitTime = 30;
    private int coolDownCounter = waitTime; //Wie viele frames der Cooldown lang sein soll
    private boolean doCoolDown; //Variable, damit der Spieler weiß, ob er den Cooldown machen muss
    private int jump;
    private final int dashSpeed = 15; // Wie schnell der Spieler den Dash macht

    private final int speed = 6; //Laufgeschwindigkeit
    private final int acceleration = 1; //Variable für die Stärke der Schwerkraft
    private final int sprunghöhe = 10; //Wie hoch der Spieler springen kann
    private int vSpeed = 0; //Aktuelle vertikale Geschwindigkeit des Spielers

    private int time = 0; //Zeitvariable für Sprungstopp zwischen den Sprüngen

    private static int finalTode = 0;
    private static int finalPunkte = 0;
    private static int finalNuesse = 0;
    private static int finalTime = 0;

    private String tasteLinks = "a";
    private String tasteRechts = "d";
    private String tasteSprung = "w";
    private String tasteDash = "shift";

    //Countervariablen
    public Counter[] meineCounter = new Counter[4];
    int zeit = 0; //Im Level verbrachte Zeit

    private boolean disableFallingWhileDashing = false;

    private boolean checkFall = true;

    private Flagge flagge;

    /**
     * Act - do whatever the Spieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        linksLaufen();
        rechtsLaufen();
        springen();
        nussSammeln();
        flaggePruefen();

        //Dash
        linksDash();
        rechtsDash();
        coolDown();

        //schwerkraft
        checkFall();

        //mit bewegtem Block bewegen
        mitBlock();
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

    public Spieler(int posX, int posY, int level)
    {
        this.posX = posX;
        this.posY = posY;
        muenzen = 0;
        nuesse = 0;
        String tasteLinks = "a";
        tasteRechts = "d";
        tasteSprung = "w";
        tasteDash = "shift";

        setImage("Knight_flipped.png");

        meineCounter[0] = new Counter("Tode: ", level);
        meineCounter[1] = new Counter("Punkte: ", level);
        meineCounter[2] = new Counter("Nüsse: ", level);
        meineCounter[3] = new Counter("Zeit: ", level);
    }

    //Bewegung
    private void linksLaufen()
    {
        if(Greenfoot.isKeyDown(tasteLinks))
        {
            setImage("Knight.png");
            blickrichtung = WEST;

            for(int i = 0; i < speed; i++)
            {
                if(vornFrei())
                {
                    setLocation(getX() - 1, getY());
                }
                else
                {
                    break;
                }
            }

            sterben();
        }
    }

    private void rechtsLaufen()
    {
        if(Greenfoot.isKeyDown(tasteRechts))
        {
            setImage("Knight_flipped.png");
            blickrichtung = OST;

            for(int i = 0; i < speed; i++)
            {
                if(vornFrei())
                {
                    setLocation(getX() + 1, getY());
                }
                else
                {
                    break;
                }
            }

            sterben();
        }
    }

    private void linksDash()
    {
        if(Greenfoot.isKeyDown(tasteLinks) && Greenfoot.isKeyDown(tasteDash) && vornFrei() && coolDown() == true)
        {
            setImage("Knight.png");
            disableFallingWhileDashing = true;
            for(int i=0; i<5; i++){
                move(-dashSpeed);
                doCoolDown = true;
            }
            sterben();
            disableFallingWhileDashing = false;
        }
    }

    private void rechtsDash()
    {
        if(Greenfoot.isKeyDown(tasteRechts) && Greenfoot.isKeyDown(tasteDash) && vornFrei() && coolDown() == true)
        {
            setImage("Knight_flipped.png");
            disableFallingWhileDashing = true;
            for(int i=0; i<5; i++){
                move(dashSpeed);
                doCoolDown = true;
            }
            sterben();
            disableFallingWhileDashing = false;
        }
    }

    /**
     * Ein Cooldown, damit man warten muss, bevor man wieder dashen kann.
     */
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

    //Counter
    public Counter getCounter(int i){
        return meineCounter[i];
    }

    public int getCounterValue(int i){
        int x = 0;
        for(int y = meineCounter[i].getValue(); y > 0; y--)
        {
            x++;
        }
        return x;
    }

    /**
     * Erhöhe Zahl im Counter n um 1.
     */
    private void realisiereCounter(int n){
        meineCounter[n].add(1);
    }

    /**
     * Erhöhe Zahl im Counter n um 1.
     */
    public void realisiereCounter(int n, int x){
        meineCounter[n].add(x);
    }

    //Berührt der Spieler...
    /**
     *  Wenn der Spieler eine Nuss berührt, wird diese Eingesammelt.
     */
    private void nussSammeln()
    {
        Actor nuss = getOneIntersectingObject(Nuss.class);
        if(nuss != null)
        {
            getWorld().removeObject(nuss);
            realisiereCounter(2);
            Greenfoot.playSound("Münze.mp3");
        }
    }

    /**
     * Überprüft, ob der Spieler eine Flagge berührt.
     * Wenn ja, dann wird das neue Level aufgerufen.
     */
    private void flaggePruefen()
    {
        Actor flagge = getOneIntersectingObject(Flagge.class);
        if(flagge != null)
        {
            finalTode = finalTode + getCounterValue(0);
            finalPunkte = finalPunkte + getCounterValue(1);
            finalNuesse = finalNuesse + getCounterValue(2);
            finalTime = finalTime + getCounterValue(3);

            Level.flagge.change();
            Greenfoot.playSound("Flagge.mp3");
        }
    }

    /**
     *  Wenn der Spieler eine Falle berührt, wird er zurück teleportiert
     *  und der Todescounter wird erhöht.
     */
    private void sterben()
    {
        if (onTrap() || headHitsTrap()) 
        {
            realisiereCounter(0);
            setLocation(posX, posY-30);
            Greenfoot.playSound("tot.mp3");
        }
    }

    private int pixel()
    {
        int a = vSpeed;
        while (a<0)
        {
            if(!headHitsGround(a))
            {
                return a;
            }
            a++;
        }
        return 0;
    }

    //Springen und Fallen
    /**
     *  Änderung in y-Richtung
     */
    protected void fall() 
    { 
        if(!disableFallingWhileDashing)
        {
            setLocation (getX(), getY() + vSpeed); 
            sterben(); 
            vSpeed += acceleration; 
        }
    }

    /**
     *  Implementierung der Schwerkraft
     */
    protected void checkFall() { 
        if (onGround()) 
        { 
            vSpeed = 0; 
            while(onGround() && checkFall) 
            { 
                setLocation(getX(), getY() -1);
            } 
            checkFall = false; 
        } 
        else {
            if (onTrap()) 
            { 
                realisiereCounter(0);
                setLocation(posX, posY);
            } 
            else 
            { 
                fall();
            } 
        } 
    }

    /**
     *  Der Spieler springt gemäß den Gesetzen der Schwerkraft
     */
    private void springen()
    {
        if(Greenfoot.isKeyDown(tasteSprung) && onGround() && time == 0 && !headHitsGround(3))
        {
            vSpeed = -sprunghöhe;
            sterben();
            if(!headHitsGround(vSpeed-1))
            {
                fall();
            }
            else
            {
                vSpeed=pixel()+4;
                fall();
            }
            time = 22;
            checkFall = true;
        }
    }

    public int gibFinaleZeit()
    {
        return finalTime;
    }
}