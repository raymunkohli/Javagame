/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * A class representing the background image to be used
 * @author raymu
 * 
 */
public class Background extends StaticBody{
    private static final BodyImage image = new BodyImage("data/background.gif", 30f);
    Background(World world){
        super(world);
        addImage(image);
    }
    
}
