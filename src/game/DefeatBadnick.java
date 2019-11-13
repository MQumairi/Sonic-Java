package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/** Handles how Sonic interacts with Robots.*/

public class DefeatBadnick implements CollisionListener {
    private Sonic sonic;
    private SoundClip BadnikDestroySound;
    private SoundClip SonicHurtSound;
    private SoundClip SonicDeadSound;



    public DefeatBadnick(Sonic sonic) {
        this.sonic = sonic;
    }

    @Override
    public void collide(CollisionEvent e) {
        e.getReportingBody(); //the Robot
        e.getOtherBody(); //Sonic


        //If Sonic collides with the Robot while Sonic is jumping, destroy the Robot!
        if (sonic.getCheckJump()) {
            if (e.getOtherBody() instanceof Sonic) {

                try {
                    BadnikDestroySound = new SoundClip("data/Sounds/badnikExplosion.wav");   // Open an audio input stream
                    BadnikDestroySound.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException er) {
                    System.out.println(er);
                }

                e.getReportingBody().destroy();
            }
        }

        //If Sonic collides with the Robot while Sonic is grounded, Sonic loses one ring.
        else if (!(sonic.getCheckJump()) && sonic.getRingCount() > 0) {

            try {
                SonicHurtSound = new SoundClip("data/Sounds/damaged.wav");   // Open an audio input stream
                SonicHurtSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException er) {
                System.out.println(er);
            }

            sonic.deccrementRingCount(); //decrement ring by one
            //sonic.incrementTakeDamageCount();
            sonic.setTakeDamageCount(1);
        }

        //If Sonic collides with the Robot while Sonic is grounded, and Sonic has no rings, destroy Sonic.
        else if (!(sonic.getCheckJump()) && sonic.getRingCount() ==0) {
            if (e.getOtherBody() instanceof Sonic) {
                sonic.setCheckDead(true);
//                e.getOtherBody().destroy();
            }
        }

    }

}