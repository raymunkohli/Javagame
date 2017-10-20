/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 * A class used to deal with collisions asteroids have with walls
 * @author raymu
 */
public class WallListener implements CollisionListener {

    private Wall w;

    WallListener(Wall w ) {
        this.w = w;
        
    }

    /**
     *
     * @param e the Collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Wall && e.getOtherBody() instanceof Asteroid){
            Asteroid a = (Asteroid) e.getOtherBody();
            Wall w = (Wall) e.getReportingBody();
            if (w.getSide()==true){
                a.setLinearVelocity(new Vec2(-a.getSpeed().x,a.getSpeed().y));
                
        }
            else{
                a.setLinearVelocity(new Vec2(a.getSpeed().x,-a.getSpeed().y));
            }
    }
    }

}
