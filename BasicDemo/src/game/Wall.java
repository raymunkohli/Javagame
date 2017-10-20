/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * A class used for the walls
 * @author raymu
 */
public class Wall extends StaticBody{
    private static final Shape longwall = new BoxShape(0.001f,9);
    private static final Shape widewall = new BoxShape(9,0.001f);
    private Shape shape;
    private Boolean side;
    Wall(World world,BoxShape BoxShape,Boolean a){
        super(world,BoxShape);
        side = a;
        
    }

    /**
     *
     * @return if the wall is a side wall or not 
     */
    public Boolean getSide(){
        return side;
    }
    
}
