import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flagge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flagge extends Weltblöcke
{
    private int posX;
    private int posY;
    
    public Flagge (int posX, int posY)
    {
        super();
        this.posX = posX;
        this.posY = posY;
        setImage("flagge.png");
        }
    
    
}