/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;

/**
 *The information used for Level 1
 * @author raymu
 */
public class Level1 extends GameLevel {

    /**
     *
     * @param game the game for which to be populated
     * @param v the view to set the background image with
     */
    
    @Override
    public void populate(Game game,MyView v) {
        super.populate(game,v);     
      
    }
            
    /**
     *
     * @return The rate at which small asteroids spawn in this level
     */
    @Override
    public float SmallRate(){
        return 0.2f;
    }

    /**
     *
     * @return The rate at which medium asteroids spawn in this level
     */
    @Override
    public float MediumRate(){
        return 0.3f;
    }

    /**
     *
     * @return The rate at which large asteroids spawn in this level
     */
    @Override
    public float LargeRate(){
        return 0.3f;
    }

    /**
     *
     * @return The rate at which aliens spawn in this level
     */
    public float AlienRate(){
        return 1;
    }

    /**
     *
     * @return The link to the background image used in this level
     */
    @Override
    public ImageIcon I(){
        return new ImageIcon("data/blue.png");
    }
}
