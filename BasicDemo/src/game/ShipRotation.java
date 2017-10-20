/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.abs;
import static java.lang.Math.atan;
import static java.lang.Math.signum;

/**
 * A class used to rotate the ship
 * @author raymu
 */
public class ShipRotation implements MouseMotionListener{
    private final Ship ship;
    private final World world = new World();
    private final UserView view = new UserView(world, 500, 500);
    private double shipAngle;
    
    ShipRotation(Ship ship){
       this.ship=ship;
    }
    @Override
    public void mouseMoved(MouseEvent e){
        shipAngle=0;  
        double lengthX = ship.getPosition().x-(view.viewToWorld(e.getPoint()).x-12);
        double lengthY = ship.getPosition().y+(view.viewToWorld(e.getPoint()).y+12);
        if (signum(lengthX)==-1 && signum(lengthY) ==-1){ //bottom right
             shipAngle = Math.PI+atan(abs(lengthX)/abs(lengthY));
        }
        if (signum(lengthX)==1 && signum(lengthY)==1){ //top right
            shipAngle = atan(abs(lengthX)/abs(lengthY));
        }
        if (signum(lengthX)==1 && signum(lengthY)==-1){ //bottom right
           shipAngle= Math.PI-atan(abs(lengthX)/abs(lengthY));
        }
        if (signum(lengthX)==-1&& signum(lengthY)==1){//top left
            shipAngle = 2*Math.PI-atan(abs(lengthX)/abs(lengthY));
        }

       
        ship.setAngle((float)shipAngle);      
        //System.out.println(ship.getAngleDegrees());
        
        
        
           
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    
    
}
