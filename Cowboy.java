import greenfoot.*;

/**
 * Write a description of class Cowboy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cowboy extends SmoothMover
{

    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.
    private static final int protonReloadTime = 500; // the minimum delay between firing proton waves

    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private int protonReloadDelayCount;  // How long ago we fired the proton wave the last time.
    
    private GreenfootImage rocket = new GreenfootImage("image.png");    



    /**
     * Act - do whatever the paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveOnKeyPress();
    } 
    public void moveOnKeyPress() 
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            moveUp();
        }
        if (Greenfoot.isKeyDown("down"))
        {
            moveDown();
        }
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
    }
  /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getMovement().copy(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
}
