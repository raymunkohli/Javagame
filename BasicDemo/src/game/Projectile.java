/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raymu
 */
package game;

import city.cs.engine.*;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;
import org.jbox2d.common.Vec2;

/**
 * The Projectile class
 * @author raymu
 */
public class Projectile extends DynamicBody {

    private int Speed, Amount, Damage;
    private static final Shape ProjectileShape = new PolygonShape(0.32f, 0.31f, 0.303f, -0.306f, -0.238f, -0.322f, -0.372f, 0.092f, 0.015f, 0.391f);
    private double Angle,xOffset,yOffset;

    Projectile(World world, Ship ship) {
        super(world,ProjectileShape);
        addImage(new BodyImage("data/yellowbullet.png", 1));
        this.setPosition(ship.getPosition());
        Speed = 6;
        Damage = 15;
    }

    /**
     *
     * @param Speed the new speed of the projectile
     */
    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    /**
     *
     * @return the speed of the projectile
     */
    public int getSpeed() {
        return Speed;
    }

    /**
     *
     * @param amount the new number of projectile to be fired
     */
    public void setAmount(int amount) {
        this.Amount = amount;
    }

    /**
     *
     * @return the number of projectiles to be fired 
     */
    public int getAmount() {
        return Amount;
    }

    /**
     *
     * @param damage the new damage a single projectile will deal 
     */
    public void setDamage(int damage) {
        this.Damage = damage;
    }

    /**
     *
     * @return the damage a single projectie will deal
     */
    public int getDamage() {
        return Damage;
    }

    /**
     *
     * @param speed the speed of the projectile
     * @param angle the angle of the ship in comparison to the mouse cursor
     * @return a vec 2 which consists of the angle of the ship and speed of the projectile
     */
    public Vec2 setPAngle(int speed, double angle) {
        if (angle > 0 && angle < 90) {
            Angle = 90-angle;
            xOffset = -1;
            yOffset = 1;
        }
        if (angle> 90 && angle< 180) {
            Angle = angle-90;
            xOffset=-1;
            yOffset=-1;
              
        }
        if (angle> 180 && angle < 270) {
            Angle = angle+90;
            xOffset =1;
            yOffset =1;
        }
        if (angle > 270 && angle< 360) {
            Angle = angle-270;
            xOffset =1;
            yOffset = 1;
        }
        
        double xVector = Speed* cos(toRadians(Angle))*xOffset;
        double yVector = Speed* sin(toRadians(Angle))*yOffset;
        return new Vec2((float)xVector,(float)yVector);

    }

}
