/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.World;

/**
 * The class used to calculate what happens if a projectile collides with something
 * @author raymu
 */
public class ProjectileCollision implements CollisionListener {

    private Projectile p;
    private Ship ship;
    private Game game;
    ProjectileCollision(Projectile p, Ship ship,Game game) {
        this.p = p;
        this.ship = ship;
        this.game = game;
    }

    /**
     *
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Asteroid && e.getReportingBody() instanceof Projectile) {
            Asteroid A = (Asteroid) e.getOtherBody();
            Projectile P = (Projectile) e.getReportingBody();
            
            P.destroy();
                
            A.setHealth(A.getHealth() - P.getDamage());

            if (A.getHealth() <= 0) {
                game.setScore(A.getScore());
                game.getScorePanel().setjLabel4(game.getScore());
                e.getOtherBody().destroy();
            }

            System.out.println("Score: " + game.getScore());
        }
        if (e.getOtherBody() instanceof Wall && e.getReportingBody() instanceof Projectile) {
            e.getReportingBody().destroy();
        }
    }

}
