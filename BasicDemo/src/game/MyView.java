/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A class used to set the background image in a game
 * @author raymu
 */
public class MyView extends UserView{
    
    
    private Image background;
    private int height,width;

    /**
     *
     * @param world the world for which the view to be in
     * @param width the width of the view
     * @param height the height of the view
     */
    public MyView(World world,int width, int height) {
        super(world, width, height);
        this.width = width;
        this.height = height;
    }
    
    /**
     *
     * @param g the new image to be used as the background image
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    
    }

    /**
     *
     * @param g unused
     */
    @Override
    protected void paintForeground(Graphics2D g) {
    }

    /**
     *
     * @param b set the background image to be scaled to fit on the screen
     */
    public void setBackgrounds(ImageIcon b){
        this.background = b.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        
    }
    
    
}
