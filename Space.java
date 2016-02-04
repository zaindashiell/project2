import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.util.List;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

    public Space() 
    {
        super(600, 300, 1);
        
        
        Cowboy rocket = new Cowboy();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 380);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
    }
    
  
    
    
    /**
     * Counts the score
     */
    public void countScore()
    {
        List<Counter> score = getObjects(Counter.class);
        for (Counter s : score)
        {
            s.add(100);
        }
    }
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        List<Counter> score = getObjects(Counter.class);
        for (Counter s : score)
        {
            int finalScore = s.getValue();
            addObject( new ScoreBoard( finalScore ), getWidth()/2, getHeight()/2 );
        }

    }

}