package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Key handler to control Sonic.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 25;
    private Sonic sonic;
    private SoundClip jumpsound;



    public Controller(Sonic sonic) {
        this.sonic = sonic;
    }

    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //deals with directional motion with arrow keys
        int codej = e.getKeyCode(); //deals with jump with space bar

        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        }

        if (codej == KeyEvent.VK_SPACE && !(sonic.getCheckDead())) { // Space = jump

            Vec2 v = sonic.getLinearVelocity();
            sonic.makeJump(); //replaces the animation with sonic jump


            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                sonic.jump(JUMPING_SPEED);

                try {
                    jumpsound = new SoundClip("data/Sounds/jumpSound.wav");   // Open an audio input stream
                    jumpsound.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException er) {
                    System.out.println(er);
                }

            }

        } else if (code == KeyEvent.VK_LEFT && !(sonic.getCheckDead())) {
            sonic.startWalking(-(sonic.getSonicSpeed())); // Left arrow = walk left
            sonic.setCheckMovingRight(false); //change the right-motion tracking boolean to false

            if(!(sonic.getCheckJump())) {
                if(sonic.getCheckSonicMaxSpeed()) {
                    sonic.makeRunLeft();
                }

                if(!(sonic.getCheckSonicMaxSpeed())) {
                    sonic.makeWalkLeft();
                }

            }

        } else if (code == KeyEvent.VK_RIGHT && !(sonic.getCheckDead())) {

            sonic.startWalking(sonic.getSonicSpeed()); // Right arrow = walk right
            sonic.setCheckMovingRight(true); //change the right-motion tracking boolean to true

            if(!(sonic.getCheckJump())) {
                if(sonic.getCheckSonicMaxSpeed()) {
                    sonic.makeRunRight();
                }

                if(!(sonic.getCheckSonicMaxSpeed())) {
                    sonic.makeWalkRight();
                }
            }

        }
    }

    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        int codej = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT && !(codej == KeyEvent.VK_SPACE)) {
            sonic.stopWalking();

        } else if (code == KeyEvent.VK_RIGHT && !(codej == KeyEvent.VK_SPACE)) {
            sonic.stopWalking();
        }

    }
    public void setSonic(Sonic sonic) {
        this.sonic = sonic;
    }

}
