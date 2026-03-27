import greenfoot.GreenfootSound;

/**
 * Write a description of class Musik here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musik  
{
    // instance variables - replace the example below with your own
    public static GreenfootSound music = new GreenfootSound("MusikV1Pre.mp3");
    private static String musikCheck;
    
    protected static boolean musikON = true;
    
    /**
     * Constructor for objects of class Musik
     */
    public Musik()
    {
    }
    
    private void act()
    {
        
    }
    
    public static void changeMusik(String musik)
    {
        if(musikON)
        {
            if(musik != musikCheck)
            {
                music.stop();
                musikCheck = musik;
                music = new GreenfootSound(musik);
                music.playLoop();
            }
        }
    }
}
