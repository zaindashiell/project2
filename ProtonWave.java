import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
 * A proton wave that expands and destroys things in its path.
 * 
 * @author Michael Kolling
 * @version 0.1
 */
public class ProtonWave extends Actor
{

    private int imageCount = 0;
    
    /** The damage this wave will deal */
    private static final int DAMAGE = 30;
    
    /** How many images should be used in the animation of the wave */
    private static final int NUMBER_IMAGES= 30;
    
    /** 
     * The images of the wave. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /**
     * Create a new proton wave.
     */
    public ProtonWave() 
    {
        initializeImages();
        setImage(images[0]);
        Greenfoot.playSound("proton.wav");
    }
    
    /** 
     * Create the images for expanding the wave.
     */
    public static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            for (int i = 0; i < NUMBER_IMAGES; i++)
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
            
        }
    }
    
    /**
     * Act for the proton wave is: grow and check whether we hit anything.
     */
    public void act()
    { 
       
        grow();
    }
    
    /**
     * Increases the size of the proton wave, using the different size images stored in images[]
     */
    private void grow()
    {
        if (imageCount >= NUMBER_IMAGES )
        {
            getWorld().removeObject(this);
        }
        else
        {
            setImage(images[imageCount]);
            imageCount++;
        }
    }

    
}
