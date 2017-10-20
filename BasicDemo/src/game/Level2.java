/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BoxShape;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;

/**
 *
 * The information used in Level 2
 * @author raymu
 */
public class Level2 extends GameLevel {

    /**
     *
     * @param game the game to be populated
     * @param v the view for which to set a background image
     */
    @Override
    public void populate(Game game,MyView v) {
        super.populate(game,v);
        System.out.println("level 2");
       // Wall middleWall = new Wall(this, new BoxShape(7, 1));
        //middleWall.setPosition(new Vec2(0, 9));
    }

    /**
     *
     * @return The rate at which small asteroids spawn in this level
     */
    @Override
    public float SmallRate() {
        return 0.3f;
    }

    /**
     *
     * @return The rate at which medium asteroids spawn in this level
     */
    @Override
    public float MediumRate() {
        return 0.4f;
    }

    /**
     *
     * @return The rate at which large asteroids spawn in this level
     */
    @Override
    public float LargeRate() {
        return 0.5f;
    }

    /**
     *
     * @return The rate at which aliens spawn in this level
     */
    @Override 
    public float AlienRate(){
        return 1;
    }

    /**
     *
     * @return the link to the background image used in this game level
     */
    @Override
    public ImageIcon I(){
        return new ImageIcon("data/green.png");
    }
          
}
