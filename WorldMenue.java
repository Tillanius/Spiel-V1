import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMenue extends World
{
    int x = 0;
    /**
     * Constructor for objects of class Menue.
     * 
     */
    public WorldMenue()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        x++;
        System.out.println(x);
    }
}
