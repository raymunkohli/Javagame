/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Walker;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 * A class used to move the ship
 * @author raymu
 */
public class ShipMovement extends KeyAdapter {

    private Ship ship;
    private float SPEED, h, v;
    private double shipAngle;

    /**
     *
     * @param ship the ship to be used
     */
    public ShipMovement(Ship ship) {
        this.ship = ship;
        SPEED = ship.getSpeed();
        shipAngle = ship.getAngle();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            v = SPEED;
            
            
        }
        if (code == KeyEvent.VK_S) {
            v = -SPEED;
        }
        if (code == KeyEvent.VK_D) {
            h = SPEED;
        }
        if (code == KeyEvent.VK_A) {
            h = -SPEED;
        }
        ship.setLinearVelocity(new Vec2(h, v));

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
            v = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A) {
            h = 0;
        }
        ship.setLinearVelocity(new Vec2(h, v));

    }

    /**
     *
     * @param ship the ship to be used
     */
    public void setBody(Ship ship) {
        this.ship = ship;
    }

}
