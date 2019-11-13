package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** Abstract class for all levels.*/

public abstract class GameLevel extends World {
    private Sonic sonic;
    private SoundClip levelMusic;

    public Sonic getPlayer() {
        return sonic;
    }

    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        sonic = new Sonic(this, game);
        sonic.setPosition(startPosition());
        FinishLine finishLine = new FinishLine(this);
        finishLine.setPosition(doorPosition());
        finishLine.addCollisionListener(new FinnishLineCollision(game, finishLine));
        FinnishLineListner finnishLineListner = new FinnishLineListner(game, finishLine);
        this.addStepListener(finnishLineListner);


        try {
            levelMusic = new SoundClip(setLevelMusic());   // Open an audio input stream
            levelMusic.loop();  // Set it to continous playback (looping)
            levelMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    public SoundClip getLevelMusic() {
        return levelMusic;
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** The Level's Music. */
    public abstract String setLevelMusic();

    /** Is this level complete? */
    public abstract boolean isCompleted();
}
