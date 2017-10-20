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
 * The ship class
 * @author raymu
 */
public final class Ship extends Walker {
    private static final int s = 5;
    private static final Shape shipShape = new PolygonShape(0.055f*s,0.481f*s, 0.253f*s,0.239f*s, 0.361f*s,-0.131f*s, 0.334f*s,-0.441f*s, -0.355f*s,-0.441f*s, -0.406f*s,-0.142f*s, -0.317f*s,0.18f*s, -0.052f*s,0.494f*s);
    private static final BodyImage image = new BodyImage("data/ship.png", (float)s);
    private Vec2 ShipPosition;
    private int lives,speed,score;
    
    /**
     *
     * @param world the world for which the ship is to be placed
     */
    public Ship(World world) {

        super(world, shipShape);
        ShipPosition =new Vec2(0,0);
        addImage(image);
        setPosition(ShipPosition);
        setSpeed(5);
        score = 0;
        setLives(3);
        
    }

    /**
     *
     * @return the position of the ship
     */
    public Vec2 getShipPosition(){
        return ShipPosition;
    }

    /**
     *
     * @param ShipPosition the new position for the ship to be
     */
    public void setShipPosition(Vec2 ShipPosition){
        this.ShipPosition=ShipPosition;
        setPosition(this.ShipPosition);
    }

    /**
     *
     * @return the number of lives the ship has
     */
    public int getLives(){
        return lives;
    }

    /**
     *
     * @param newlife the number of lives the user has gained ( can be negative to represent losing life)
     */
    public void setLives(int newlife){
        lives = lives+ newlife;
    }

    /**
     *
     * @param newspeed the new speed value for the ship to travel at
     */
    public void setSpeed(int newspeed){
        this.speed = newspeed;
        
    }

    /**
     *
     * @return the speed the ship travels at
     */
    public int getSpeed(){
        return speed;
    }

    /**
     *
     * @return the score the ship as accumulated
     */
    public int getScore(){
        return score;
    }

    /**
     *
     * @param x the score of the game will increase by x
     */
    public void setScore(int x){
        score = score + x;
    }
    
    
    
    
    
    
}
