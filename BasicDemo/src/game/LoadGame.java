/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jbox2d.common.Vec2;

/**
 *
 * The class used to read data from a file
 * @author raymu
 */
public class LoadGame {

    /**
     *
     * @throws IOException if no file is found
     */
    public void load() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            fr = new FileReader("data/saveGame.txt");
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] splitline= line.split(" ");
            Game a =new Game();
            
            a.setLevel(Integer.parseInt(splitline[0]));
            a.setScore(Integer.parseInt(splitline[2]));
            
            int numberOfBodies = Integer.parseInt(splitline[3]);
            
            a.harder();
            a.stop();
            a.setLives(-3+Integer.parseInt(splitline[1]));
            a.getScorePanel().setjLabel2(String.valueOf(0+Integer.parseInt(splitline[1])));
            a.setTime(Integer.parseInt(splitline[4]));
            for (int x=0;x!=numberOfBodies-1;x++){
                
                String nextLine = reader.readLine();
                String[] splitNextLine =nextLine.split(" ");
                
                if (x==numberOfBodies-1){
                    a.world().getShip().setPosition(new Vec2 (Float.parseFloat(splitNextLine[2]),Float.parseFloat(splitNextLine[3])));
                }
                else{
                    
                    String t = splitNextLine[1];
                    System.out.println(t);
                    String[] type = splitNextLine[1].split("game.");
                    if (t.equals("game.SmallAsteroid")){
                        SmallAsteroid s = new SmallAsteroid(a.world());
                        s.setPosition(new Vec2 (Float.parseFloat(splitNextLine[2]),Float.parseFloat(splitNextLine[3])));
                        s.setLinearVelocity(new Vec2(Float.parseFloat(splitNextLine[4]),Float.parseFloat(splitNextLine[5])));
                        s.addCollisionListener(new ShipCollision(a.world().getShip(),a));
                    }
                    if (t.equals("game.MediumAsteroid")){
                        MediumAsteroid s = new MediumAsteroid(a.world());
                        s.setPosition(new Vec2 (Float.parseFloat(splitNextLine[2]),Float.parseFloat(splitNextLine[3])));
                        s.setLinearVelocity(new Vec2(Float.parseFloat(splitNextLine[4]),Float.parseFloat(splitNextLine[5])));
                        s.addCollisionListener(new ShipCollision(a.world().getShip(),a));
                    }
                    if (t.equals("game.LargeAsteroid")){
                        LargeAsteroid s = new LargeAsteroid(a.world());
                        s.setPosition(new Vec2 (Float.parseFloat(splitNextLine[2]),Float.parseFloat(splitNextLine[3])));
                        s.setLinearVelocity(new Vec2(Float.parseFloat(splitNextLine[4]),Float.parseFloat(splitNextLine[5])));
                        s.addCollisionListener(new ShipCollision(a.world().getShip(),a));
                    }
                  
                    /*Class DBody = Class.forName(t);
                    Constructor c = DBody.getConstructor(World.class);
                    Object O = c.newInstance(a.world());*/
                    
                    
                }
                
                
            }
        }
            
         catch(IOException e){
            System.out.println("No file found unpause previous game");
        }
    }

}
