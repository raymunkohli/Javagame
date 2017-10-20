/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.lang.Math.*;

/**
 *
 * The base class for all the asteroids
 * @author raymu
 */
public class Asteroid extends DynamicBody{
    private static Shape asteroidShape;
    private static String image;
    private int health;
    private int Score;
    private Vec2 speed;
    
    /**
     *
     * @param world The world for the asteroid to be in
     * @param s The shape of the Asteroid
     * @param i The link to the image of the Asteroid
     * @param h The initial health of the Asteroid
     * @param scale The scale of the image
     * @param Score The score which destroying this asteroid will give
     */
    public Asteroid(World world,Shape s,String i,int h,float scale,int Score) {
        super(world,s);
        addImage(new BodyImage(i,scale));
        setHealth(h);
        this.Score = Score;
        speed = generateSpeed();
        setLinearVelocity(speed);
        
    }

    /**
     *
     * @return
     * returns the initial speed of the asteroid
     */
    public Vec2 getSpeed(){
        return speed;
    }

    /**
     *
     * @return
     * generates the intial speed of the asteroid
     */
    public Vec2 generateSpeed(){
        float a = (float)Math.random();
        return new Vec2(((float)Math.random()*6)-3,((float)Math.random()*6)-3);
    }
    
    /**
     *
     * @return
     * returns the health of the asteroid
     */
    public int getHealth(){
        return health;
    }

    /**
     *
     * @param health the new health of the asteroid
     */
    public void setHealth(int health){
        this.health = health;
    }

    /**
     *
     * @return returns the shape of the asteroid
     */
    public Shape getShape(){
        return asteroidShape;
    }

    /**
     *
     * @param shape  the new asteroid shape
     */
    public void setShape(Shape shape){
        this.asteroidShape =shape;
    }

    /**
     *
     * @return returns the image location of the asteroid
     */
    public String getImage(){
        return image;
    }

    /**
     *
     * @param image the new image to be used for the asteroid
     */
    public void setImage(String image){
        this.image = image;
        
    }

    /**
     *
     * @return returns the score killing the asteroid will give 
     */
    public int getScore(){
        return Score;
    }
}
