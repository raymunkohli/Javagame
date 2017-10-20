/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.util.*;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;

/**
 * A class representing each of the gamelevels a game can have
 * @author raymu
 */
public abstract class GameLevel extends World {

    private Ship ship;
    private int counter;
    private Game g;
    private Timer timer = new Timer();

    //private int counter;

    /**
     *
     * @return returns the ship used in this game level
     */
    public Ship getShip() {
        return ship;
    }

    /**
     *
     * @param g the game for which the counter is to be increased
     */
    public void incrementCounter(Game g) {
        counter = counter + 1;
        if (this instanceof Level3) {

        } else {
            if (counter == 30) {
                timer.cancel();
                g.incrementDifficulty();
                g.harder();

            }
        }
    }

    /**
     * stops the timer
     */
    public void stopTimer() {
        timer.cancel();
        System.out.println(counter);
    }

    /**
     *
     * @return returns the number of ticks on the timer
     */
    public int getCounter() {
        return counter;
    }

    /**
     *
     * @param a the new value for how many ticks have passed (to be used with loadgame)
     */
    public void setCounter(int a){
        counter = a;
    }

    /**
     *
     * @param game the game for which is to be populated
     * @param v A view used to set the background image
     */
    public void populate(Game game, MyView v) {
        setGravity(0f);
        this.g = game;
        ship = new Ship(this);
        ship.setPosition(new Vec2(0, 0));
        //walls
        Wall botWall = new Wall(this, new BoxShape(18, 0.001f),false);
        botWall.setPosition(new Vec2(0, -12f));

        Wall topWall = new Wall(this, new BoxShape(18, 0.001f),false);
        topWall.setPosition(new Vec2(0, 12f));

        Wall leftWall = new Wall(this, new BoxShape(0.001f, 18),true);
        leftWall.setPosition(new Vec2(11f, 0));

        Wall rightWall = new Wall(this, new BoxShape(0.001f, 18),true);
        rightWall.setPosition(new Vec2(-11f, 0));
        
        botWall.addCollisionListener(new WallListener(botWall));
        topWall.addCollisionListener(new WallListener(topWall));
        rightWall.addCollisionListener(new WallListener(rightWall));
        leftWall.addCollisionListener(new WallListener(leftWall));
        
        v.setBackgrounds(I());
        
        

        // configure ship
        //float angle = Math.atan2();
        //ship.setAngle(angle); 
        //wall
        //Background background = new Background(this);
        //background.setPosition(new Vec2(0,0));
        //alien
    }

    /**
     * starts the timer
     */
    public void startTimer(){
        this.timer = new Timer();
        timer.scheduleAtFixedRate(new asteroidSpawningTask(ship, this, SmallRate(), MediumRate(), LargeRate(), g, AlienRate()), 1, 1000);
    }

    /**
     *
     * @return the small asteroid rate for a game level
     */
    public abstract float SmallRate();

    /**
     *
     * @return the medium asteroid rate for a game level
     */
    public abstract float MediumRate();

    /**
     *
     * @return the large asteroid rate for a game level
     */
    public abstract float LargeRate();
    
    /**
     *
     * @return the rate at which aliens spawn on a game level
     */
    public abstract float AlienRate();
    
    /**
     *
     * @return the background image used on a game level
     */
    public abstract ImageIcon I();
            
    

}
