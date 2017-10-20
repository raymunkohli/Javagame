/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.DynamicBody;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class used to save the game (write data)
 * @author raymu
 */
public class SaveGame {
    Game game;
    SaveGame(Game g){
        game = g;
        
    }

    /**
     *
     * 
     * @throws IOException if no file is found
     */
   

    public void Save() throws IOException{
        System.out.println("ayy");
        FileWriter fw = new FileWriter("data/saveGame.txt",false);
        fw.write(game.getLevel()+" "+game.getLives()+" "+game.getScore()+" "+(game.world().getDynamicBodies().size())+" "+ game.world().getCounter()+"\n");
        for(DynamicBody D:game.world().getDynamicBodies()){
            fw.write(D.getClass()+" "+Float.toString(D.getPosition().x)+" "+Float.toString(D.getPosition().y)+" "+Float.toString(D.getLinearVelocity().x)+" " + Float.toString(D.getLinearVelocity().y)+" "+"\n");
        }
        game.stop();
        fw.close();
    }
}
