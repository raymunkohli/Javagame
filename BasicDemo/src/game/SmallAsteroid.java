/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * A class representing the small Asteroids used
 * @author raymu
 */
public class SmallAsteroid extends Asteroid{
    private static final Shape smallAstroidShape = new PolygonShape (-0.333f,-0.295f, 0.156f,-0.5f, 0.382f,0.144f, 0.069f,0.48f, -0.267f,0.225f);
    private static final String smallAstroidImage ="data/smallrock.png";
    private static int health = 10;
    private static int Score = 10;
    
    /**
     *
     * @param world the world for the asteroid to be initilised in 
     */
    public SmallAsteroid(World world) {
        super(world,smallAstroidShape,smallAstroidImage,health,1,Score);

    }

}
