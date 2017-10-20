package game;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import org.jbox2d.common.Vec2;

/**
 * A class used to fire projectiles
 * @author raymu
 */
public class MouseHandler extends MouseAdapter {

    private static final float RADIUS = 0.5f;
    
    private static final Shape ballShape
                = new CircleShape(RADIUS);
    
    private static final BodyImage ballImage
                = new BodyImage("data/bowl.png", 2*RADIUS);
    
    private WorldView view;
    private Ship ship;
    private Game game;

    /**
     *
     * @param view the view which the mouse handler is to be used in
     * @param ship the ship to be used
     * @param game The game the ship is a part of 
     */
    public MouseHandler(WorldView view,Ship ship,Game game) {
        this.view = view;
        this.ship=ship;
        this.game = game;
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {
         
        Projectile p = new Projectile(view.getWorld(),ship);
        p.putOn(ship);
        p.rotate(ship.getPosition(),ship.getAngle());
        p.addCollisionListener(new ProjectileCollision(p,ship,game));
        p.setLinearVelocity(p.setPAngle(p.getSpeed(),ship.getAngleDegrees()));

    }    
    // to do for deadline 2: 1)game menu 4)
    
}
