package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**SpringListner - launches Sonic upwards when he hits a spring*/

public class SpringListner implements CollisionListener {
    private Sonic sonic;
    private SoundClip springSound;

    public SpringListner(Sonic sonic) {
        this.sonic = sonic;
    }

    @Override
    public void collide(CollisionEvent e) {
        e.getReportingBody(); //the Spring
        e.getOtherBody(); //Sonic


        //If Sonic collides with the Spring while Sonic is jumping, make Sonic Jump High!
        if (sonic.getCheckJump()) {
            if (e.getOtherBody() instanceof Sonic) {
                sonic.jump(50);

                try {
                    springSound = new SoundClip("data/Sounds/SpringSound.wav");   // Open an audio input stream
                    springSound.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException er) {
                    System.out.println(er);
                }
            }
        }

        if (e.getReportingBody() instanceof Spring) {
            ((Spring) e.getReportingBody()).makePush();
        }

    }

}