/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * 
 * The Listener to be used to detect if a projectile collides with an alien triggering  a game over
 * @author raymu
 */
public class AlienListnener implements CollisionListener {

    private Alien a;
    private Game g;
    AlienListnener(Alien a, Game g) {
        this.a = a;
        this.g = g;
    }

    /**
     *
     * @param e The collision event 
     * The Listener used to detect a projectile colliding with an alien
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Alien && e.getOtherBody() instanceof Projectile){
            g.setLives(-3);
            g.gameOver();
        }
    }

}
