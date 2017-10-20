/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * The class used to deal with collisions with the ship
 * @author raymu
 */
public class ShipCollision implements CollisionListener {

    private Ship ship;
    private Game game;

    ShipCollision(Ship ship, Game game) {
        this.ship = ship;
        this.game = game;
    }

    /**
     *
     * @param e the Collision event
     */
    @Override
    public void collide(CollisionEvent e) {
         
        if (e.getOtherBody() == ship) {
            game.setLives(-1);
            System.out.println(e.getReportingBody().getPosition());
            if (game.getLives() == 0 && e.getOtherBody() == ship) {
                game.gameOver();
            }
            
            game.getScorePanel().setjLabel2(String.valueOf(game.getLives()));
            System.out.println("Lives Remaining :" + game.getLives());
        }

    }

}
