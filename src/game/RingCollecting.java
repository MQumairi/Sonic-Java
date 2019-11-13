package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**Handles Sonic's acquiring of a ring.*/

public class RingCollecting implements SensorListener {
    private Sonic sonic;
    private Ring ring;
    private SoundClip RingAcquiredSound;


    public RingCollecting(Ring ring, Sonic sonic) {
        this.ring = ring;
        this.sonic = sonic;
    }

    @Override
    public void beginContact(SensorEvent e) {
        e.getContactBody(); //Sonic
        e.getSensor(); //the Ring

        if(e.getContactBody() instanceof  Sonic) {
            sonic.incrementRingCount();
            sonic.incrementLiveTicker();

            try {
                RingAcquiredSound = new SoundClip("data/Sounds/RingAcquiredSound.wav");   // Open an audio input stream
                RingAcquiredSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException er) {
                System.out.println(er);
            }

            ring.destroyRing();

        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
