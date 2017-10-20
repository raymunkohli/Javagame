/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import city.cs.engine.*;
import java.util.Timer;
import org.jbox2d.common.Vec2;
/**
 *
 * Outdated and unused now
 * @author raymu
 */
public class GameWorld extends World {
    /*private Ship ship;
    public GameWorld() {
        super();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new asteroidSpawningTask(ship,this),1,1000);
        
        // configure ship
        ship = new Ship(this);
        
        //float angle = Math.atan2();
        //ship.setAngle(angle); 
        //walls
        Wall botWall =new Wall(this,new BoxShape(18,0.001f));
        botWall.setPosition(new Vec2(0,-12.5f));
        
        Wall topWall = new Wall(this,new BoxShape(18,0.001f));
        topWall.setPosition(new Vec2(0,12.5f));
        
        Wall leftWall=new Wall(this,new BoxShape(0.001f,18));
        leftWall.setPosition(new Vec2(12.5f,0));
        
        Wall rightWall = new Wall (this,new BoxShape(0.001f,18));
        rightWall.setPosition(new Vec2(-12.5f,0));
        
        //Background background = new Background(this);
        //background.setPosition(new Vec2(0,0));
        //alien
        
        //Alien alien = new Alien(this,ship);
        if (ship.getLives()==0){
              //gameover
        }
        
        
        
    }
    public Ship getShip(){
        return ship;
    }*/
}
