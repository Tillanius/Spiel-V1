import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musik3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musik3 //Jakob
{
    public static GreenfootSound music = new GreenfootSound("MusikV1Pre.mp3");
    private static String musikCheck;
    
    protected static boolean musikON = true;
    
    /**
     * Constructor for objects of class Musik
     */
    public Musik3()
    {
        
    }
    
    public static void changeMusik(String musik)
{
    if(!musik.equals(musikCheck))
    {
        music.stop();
        music = new GreenfootSound(musik);
        musikCheck = musik;
    }

    if(musikON)
    {
        music.playLoop();
    }
}
}
