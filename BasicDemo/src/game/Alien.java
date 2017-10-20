/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * 
 * The class representing the alien as seen ingame.
 */
    public class Alien extends DynamicBody{
    private static Shape alienShape=new PolygonShape(0.112f*5,0.498f*5, -0.254f*5,0.423f*5, -0.351f*5,0.182f*5, -0.396f*5,-0.487f*5, 0.398f*5,-0.49f*5, 0.338f*5,0.438f*5);
    
    /**
     *The class representing the alien as seen ingame.
     * @param world the world for the Alien to be in
     * The class representing the alien as seen ingame.
     */
    public Alien(World world) {
        super(world,alienShape);
        addImage(new BodyImage("data/alien.png",5f));
        setPosition(new Vec2(-5,-5));
    }
}
