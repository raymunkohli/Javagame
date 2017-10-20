package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * A class representing a large asteroid 
 * @author raymu
 *  
 */
public class LargeAsteroid extends Asteroid{
    private static final int s = 3;
    private static final Shape largeAstroidShape = new PolygonShape (-0.46f*s,0.028f*s, -0.229f*s,-0.462f*s, 0.305f*s,-0.448f*s, 0.454f*s,0.039f*s, 0.254f*s,0.344f*s, -0.116f,0.445f*s, -0.433f*s,0.345f*s);
    private static final String largeAstroidImage ="data/largerock.png";
    private static int health = 90;
    private static int Score = 1000;
    
    /**
     *
     * @param world the world for the large asteroid to be initilised in
     */
    public LargeAsteroid(World world) {
        super(world,largeAstroidShape,largeAstroidImage,health,s,Score);

    }

}
