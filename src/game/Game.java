package game;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;


/**
 * THIRD JAVA MILESTONE FOR MOHAMMED ALQUMAIRI, GROUP C, STUDENT NUMBER 180030156.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    public GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private BackgroundView view;

    /** the level number*/
    private int level;

    /** the controller*/
    private Controller controller;

    /** the camera - pans with character unless in level5*/
    private Tracker camera;

    /** the sonicTracker- steplistner for sonic's animations*/
    private SonicTracker sonicTrack;

    /** the extralives sonic has acquired since starting the game- */
    private int extraLives;

    /** the extralives sonic has acquired since starting the game- */
    private boolean isPaused = false;

    /** Initialise a new Game. */
    public Game() throws IOException {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);


        // make a view
        view = new BackgroundView(world, 500, 500, this);

        view.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));


        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Multi-level game");


        ControlPanel buttons = new ControlPanel(frame, this);
        view.add(buttons.getMainPanel(), BorderLayout.SOUTH);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // Step Listeners

        //Camera
        camera = new Tracker(view, world.getPlayer(), this);
        world.addStepListener(camera);

        //Sonic Tracker
        sonicTrack = new SonicTracker(world.getPlayer());
        world.addStepListener(sonicTrack);

        // start!
        world.start();

    }

    /** The player in the current level. */
    public Sonic getPlayer() {
        return world.getPlayer();
    }

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }


    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (level == 5) {
            System.exit(0);

        } else if (level == 0) {

            level++;

            //Change background
            view.makeGreen();

            // get a new world
            world = new Level1();

            // fill it with bodies
            world.populate(this);

            // show the new world in the view
            view.setWorld(world);

            // switch the keyboard control to the new player
            controller.setSonic(world.getPlayer());

            // switch the camera to the new player
            camera = new Tracker(view, world.getPlayer(), this);
            world.addStepListener(camera);

            //switch the sonic tracker to the new player
            sonicTrack = new SonicTracker(world.getPlayer());
            world.addStepListener(sonicTrack);

            //switch the sonic tracker to the new player
            world.start();

            //Change Sonic's Live Count to reflect Extra Lives
            world.getPlayer().setLiveCount(world.getPlayer().getLiveCount() + getExtraLives());


        }

        else if (level == 1) {
            level++;

            //Change background
            view.makeSnow();

            // get a new world
            world = new Level2();

            // fill it with bodies
            world.populate(this);

            // show the new world in the view
            view.setWorld(world);

            // switch the keyboard control to the new player
            controller.setSonic(world.getPlayer());

            // switch the camera to the new player
            camera = new Tracker(view, world.getPlayer(), this);
            world.addStepListener(camera);

            //switch the sonic tracker to the new player
            sonicTrack = new SonicTracker(world.getPlayer());
            world.addStepListener(sonicTrack);

            //switch the sonic tracker to the new player
            world.start();

            //Change Sonic's Live Count to reflect Extra Lives
            world.getPlayer().setLiveCount(world.getPlayer().getLiveCount() + getExtraLives());

        }

        else if (level == 2) {
            level++;

            //Change background
            view.makeLaunch();

            // get a new world
            world = new Level3();

            // fill it with bodies
            world.populate(this);

            // show the new world in the view
            view.setWorld(world);

            // switch the keyboard control to the new player
            controller.setSonic(world.getPlayer());

            // switch the camera to the new player
            camera = new Tracker(view, world.getPlayer(), this);
            world.addStepListener(camera);

            //switch the sonic tracker to the new player
            sonicTrack = new SonicTracker(world.getPlayer());
            world.addStepListener(sonicTrack);

            //switch the sonic tracker to the new player
            world.start();

            //Change Sonic's Live Count to reflect Extra Lives
            world.getPlayer().setLiveCount(world.getPlayer().getLiveCount() + getExtraLives());

        }

        else if (level == 3) {
            level++;

            //Change background
            view.makeMetal();

            // get a new world
            world = new Level4();

            // fill it with bodies
            world.populate(this);

            // show the new world in the view
            view.setWorld(world);

            // switch the keyboard control to the new player
            controller.setSonic(world.getPlayer());

            // switch the camera to the new player
            camera = new Tracker(view, world.getPlayer(), this);
            world.addStepListener(camera);

            //switch the sonic tracker to the new player
            sonicTrack = new SonicTracker(world.getPlayer());
            world.addStepListener(sonicTrack);

            //switch the sonic tracker to the new player
            world.start();

            //Change Sonic's Live Count to reflect Extra Lives
            world.getPlayer().setLiveCount(world.getPlayer().getLiveCount() + getExtraLives());


        }

        else if (level == 4) {
            level++;

            //Change background
            view.makeMetal();

            // get a new world
            world = new Level5();

            // fill it with bodies
            world.populate(this);

            // show the new world in the view
            view.setWorld(world);

            // switch the keyboard control to the new player
            controller.setSonic(world.getPlayer());

            // switch the camera to the new player
            camera = new Tracker(view, world.getPlayer(), this);
            world.addStepListener(camera);

            //switch the sonic tracker to the new player
            sonicTrack = new SonicTracker(world.getPlayer());
            world.addStepListener(sonicTrack);

            //switch the sonic tracker to the new player
            world.start();

            //Change Sonic's Live Count to reflect Extra Lives
            world.getPlayer().setLiveCount(world.getPlayer().getLiveCount() + getExtraLives());

        }

    }

    public void removeSonicTracker() {
        world.removeStepListener(sonicTrack);
    }

    /** Run the game. */
    public static void main(String[] args) throws IOException {
        new Game();

    }

    /** Get the number of the level Sonic is on*/
    public int getLevelNumber() {
        return level;
    }

    /** Set the level number*/
    public void setLevelNumber(int level) {
        this.level = level;
    }

    /**Get this game*/
    public Game getGame() {return this;}

    /**Get the world sonic is on*/
    public GameLevel getGameLevel() {
        return world;
    }

    /** Is the game paused? */
    public boolean getIsPaused() {
        return isPaused;
    }

    /** Set the game to paused */
    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    /** Get the game's view */
    public BackgroundView getView () {return view;}

    /** Get Sonic's Extra Lives */
    public int getExtraLives() {return extraLives;}

    /** Set Sonic's Extra Lives*/
    public void setExtraLives(int extraLives) {this.extraLives = extraLives;}

}
