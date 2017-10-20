package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * A class representing a medium Asteroid
 * @author raymu
 */
public class MediumAsteroid extends Asteroid{
    private static final int s = 2;
    private static final Shape mediumAstroidShape = new PolygonShape (0.4f*s,0.305f*s, 0.38f*s,0.074f*s, 0.096f*s,-0.332f*s, -0.309f*s,-0.358f*s, -0.425f*s,-0.038f*s, -0.308f*s,0.349f*s, -0.04f*s,0.472f*s, 0.228f*s,0.476f*s);
    private static final String mediumAstroidImage ="data/mediumrock.png";
    private static int health = 30;
    private static int Score = 100;
    
    /**
     *
     * @param world the world for the asteroid to be created in
     */
    public MediumAsteroid(World world) {
        super(world,mediumAstroidShape,mediumAstroidImage,health,s,Score);

    }

}