/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static java.lang.Math.random;
import static java.lang.Math.signum;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.jbox2d.common.Vec2;

/**
 * The class used to create asteroids
 * @author raymu
 */
public class asteroidSpawningTask extends TimerTask {

    Ship s;
    GameLevel w;
    Vec2 Position;
    float SmallRate,MediumRate,LargeRate,AlienRate;
    Game game;
    int number;

    asteroidSpawningTask(Ship s, GameLevel w,float SmallRate,float MediumRate, float LargeRate, Game game, float AlienRate) {
        this.s = w.getShip();
        this.w = w;
        this.SmallRate = SmallRate;
        this.MediumRate =MediumRate;
        this.LargeRate = LargeRate;
        this.game = game;
        this.AlienRate = AlienRate;
        number = 0;
    }

    @Override
    public void run() {
        float a = (float) random();
        Vec2 Position = getPosition();
        while(s.contains(Position)){
            System.out.println("success");
            Position = getPosition();
        }
        try{
        if (a<SmallRate) {
            System.out.println("s");
            SmallAsteroid smallguy = new SmallAsteroid(w);
            smallguy.setPosition(Position);
            smallguy.addCollisionListener(new ShipCollision(s,game));
            System.out.println("small"+smallguy.getPosition());
            number++;
        }
        else if (a > SmallRate && a < MediumRate) {
            System.out.println("m");
            MediumAsteroid mediumguy = new MediumAsteroid(w);
            mediumguy.setPosition(Position);
            mediumguy.addCollisionListener(new ShipCollision(s,game));
            System.out.println("medium:"+mediumguy.getPosition());
            number++;
            

        }
        else if (a > MediumRate && a < LargeRate) {
            System.out.println("l");
            LargeAsteroid largeguy = new LargeAsteroid(w);
            largeguy.setPosition(Position);
            largeguy.addCollisionListener(new ShipCollision(s,game));
            //System.out.println("large" +largeguy.getPosition());
            number++;
            
        }
        else if (a > AlienRate){
            Alien alien = new Alien(w);
            alien.setPosition(Position);
            alien.addCollisionListener(new AlienListnener(alien,game));
            number++;
            
        }
        
        System.out.println(number);
        w.incrementCounter(game);
        if (game.getLevel()==1){
            game.getScorePanel().setjLabel3("Level 1        Time Remaining :"+String.valueOf(w.getCounter())+"/30");
        }
        if (game.getLevel()==2){
            game.getScorePanel().setjLabel3("Level 2        Time Remaining :"+String.valueOf(w.getCounter())+"/30");
        }
        if (game.getLevel()==3){
            game.getScorePanel().setjLabel3("Level 3        You have survived "+String.valueOf(w.getCounter())+" seconds of Level 3");
        }
        }
        catch(NullPointerException e){
            w.stopTimer();
            w.startTimer();
        }
        
        
        

    }

    /**
     *
     * @return a new position for an object to be in
     */
    public Vec2 getPosition() {
        Random x = new Random();
        Random y = new Random();
        int X =(x.nextInt(8)-4);
        int Y =(y.nextInt(8)-4);
        Vec2 Position= new Vec2((X+signum(X)*6),(Y+signum(Y)*6));
        //Position= new Vec2(7,9);
        if (s.contains(Position)== true){
            System.out.println("Bad Asteroid spawn detected, recalculating..");
            return getPosition();
        }
        else{
            System.out.println(Position);
           
            return Position;
        }
              
    }
   

}
