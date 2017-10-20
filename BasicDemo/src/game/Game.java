package game;

import city.cs.engine.*;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

/**
 * A world with some bodies.
 */
public class Game {

    private GameLevel world;
    private int level;
    private int score;
    private MyView view;
    private ShipMovement shipMovement;
    private JFrame frame = new JFrame("Project");
    private MouseHandler m;
    private Container buttons;
    private Score ScorePanel;
    private int lives;
    private ShipRotation shiprotation;
    private GameOverScreen g;

    /**
     *
     * @return the number of lives the player has
     */
    public int getLives() {
        return lives;
    }

    /**
     *
     * @param rip the number of lives gained ( can be negative to represent losing life)
     */
    public void setLives(int rip) {
        this.lives = lives + rip;
    }

    /**
     *
     * @return the Score panel (top panel)
     */
    public Score getScorePanel() {
        return ScorePanel;
    }

    /**
     *
     * @return The current gameworld
     */
    public GameLevel world() {
        return world;
    }

    /**
     * Initialise a new Demo.
     */
    public Game() {
        //intialise game
        score = 0;
        lives = 3;
        level = 1;

        world = new Level1();
        view = new MyView(world, 500, 500);
        world.populate(this, view);
        world.setGravity(0f);
        // make a view

        shiprotation = new ShipRotation(world.getShip());
        view.addMouseMotionListener(shiprotation);
        m = new MouseHandler(view, world.getShip(), this);

        //view.setGridResolution(1);
        view.addMouseListener(m);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        buttons = new MenuBar(this);
        frame.add(buttons, BorderLayout.EAST);
        buttons.setVisible(true);
        frame.setVisible(true);

        ScorePanel = new Score(this);
        frame.add(ScorePanel, BorderLayout.NORTH);
        ScorePanel.setVisible(true);
        
        frame.setVisible(true);
        g = new GameOverScreen(this);
        frame.add(g, BorderLayout.SOUTH);
        g.setVisible(false);
        frame.setVisible(true);

        shipMovement = new ShipMovement(world.getShip());
        frame.addKeyListener(shipMovement);
        frame.setVisible(true);

        world.startTimer();
        // start!
        world.start();
        

    }

    /**
     *
     * @return Increases the level of the game
     */
    public int incrementDifficulty(){
        level = level+1;
        return level;
           
    }

    /**
     * 
     * To be used with incrementDifficulty, this method will initilise the new game level
     */
    public void harder() {
        
        
        world.stopTimer();
        world.stop();
        if (level == 2) {
            world = new Level2();
            world.populate(this, view);

            shipMovement.setBody(world.getShip());

            view.removeMouseListener(m);
            m = new MouseHandler(view, world.getShip(), this);
            view.addMouseListener(m);

            view.removeMouseMotionListener(shiprotation);
            shiprotation = new ShipRotation(world.getShip());
            view.addMouseMotionListener(shiprotation);

            view.setWorld(world);
            world.startTimer();
            world.start();
        }
        if (level == 3) {
            world = new Level3();
            world.populate(this, view);

            shipMovement.setBody(world.getShip());

            view.removeMouseListener(m);
            m = new MouseHandler(view, world.getShip(), this);
            view.addMouseListener(m);

            view.removeMouseMotionListener(shiprotation);
            shiprotation = new ShipRotation(world.getShip());
            view.addMouseMotionListener(shiprotation);

            view.setWorld(world);
            world.startTimer();
            world.start();

        }

    }

    /**
     * Run the demo.
     * @param args start the game
     */
    public static void main(String[] args) {
        new Game();
    }

    /**
     *
     * @return return the score of this game
     */
    public String getScore() {
        return String.valueOf(score);
    }

    /**
     *
     * @param x increases the score by x amount
     */
    public void setScore(int x) {
        score = score + x;
    }

    /**
     *
     * @return the current number of counter ticks (maximum of 30 on the first 2 levels, unlimited on the last level)
     */
    public String getTime() {
        return String.valueOf(world.getCounter());
    }

    /**
     *
     * @param t sets the current number of ticks - to be used with load game
     */
    public void setTime(int t){
        world.setCounter(t);
                }

    /**
     * ends the game
     */
    public void gameOver() {
        world.stopTimer();
        world.stop();

        buttons.setVisible(false);
        g.setVisible(true);
    }

    /**
     *
     * @return the current level of the game
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param l the new level
     */
    public void setLevel(int l){
        level = l;
                }

    /**
     * stops the timer (and counter) i.e stopping the game.
     */
    public void stop(){
        world.stop();
        world.stopTimer();
    }

    /**
     * starts the timer (and counter) i.e resuming the game.
     */
    public void start(){
        world.start();
        world.startTimer();
        
    }

}

