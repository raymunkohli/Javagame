/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.StaticBody;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;

/**
 *
 * The information used in level 3
 * @author raymu
 */
public class Level3 extends GameLevel{
    
    /**
     *
     * @param game the game to be populated
     * @param v the view for which the background is to be set
     */
    @Override
    public void populate(Game game,MyView v) {
        super.populate(game,v);
        //StaticBody middleWall = new StaticBody(this,new CircleShape(5));
        //middleWall.setPosition(new Vec2(0, 9));
    }

    /**
     *
     * @return The rate at which small asteroids spawn in this level
     */
    @Override
    public float SmallRate(){
        return 0.4f;
    }

    /**
     *
     * @return The rate at which medium asteroids spawn in this level
     */
    @Override
    public float MediumRate(){
        return 0.7f;
    }

    /**
     *
     * @return The rate at which large asteroids spawn in this level
     */
    @Override
    public float LargeRate(){
        return 0.85f;
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
     * @return the background image to be used in this level
     */
    @Override
    public ImageIcon I(){
        return new ImageIcon("data/red.jpg");
    }
}
