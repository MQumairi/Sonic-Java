package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**SpikeCollision- Handles Sonic's collision with spikes. If Sonic hits a spike, he instantly dies*/

public class SpikeCollision implements CollisionListener {
    private Sonic sonic;
    private SoundClip spikeSound;

    public SpikeCollision(Sonic sonic) {
        this.sonic = sonic;
    }

    @Override
    public void collide(CollisionEvent e) {

        e.getReportingBody(); //Spikes
        e.getOtherBody(); //sonic

        if (e.getOtherBody() instanceof Sonic) {
            sonic.setCheckDead(true);

            try {
                spikeSound = new SoundClip("data/Sounds/spikeCollisionSound.wav");   // Open an audio input stream
                spikeSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException er) {
                System.out.println(er);
            }

        }
    }

}
