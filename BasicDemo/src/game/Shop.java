package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * unused class -for future development
 * @author raymu
 */
public class Shop extends StaticBody{
    boolean toggle;
    
    Shop(World world){
        super(world);
        toggle = false;
    }
    boolean setToggle(){
        toggle = !toggle;
        if (toggle == false){
            setPosition(new Vec2(100,100));
        }
        if (toggle == true){
            setPosition(new Vec2(0,0));
        }
        return toggle;        
    }
    
    
}
