package game;

import city.cs.engine.*;
import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/** EggmanCollision - Handles how Sonic collides with the Eggman boss*/

public class EggmanCollision implements CollisionListener {
    private Sonic sonic;
    private Eggman eggman;
    private SoundClip SonicHurtSound;
    private SoundClip SonicDeadSound;



    public EggmanCollision(Eggman eggman, Sonic sonic) {
        this.sonic = sonic;
        this.eggman = eggman;
    }

    @Override
    public void collide(CollisionEvent e) {
        e.getReportingBody(); //Eggman
        e.getOtherBody(); //Sonic


        //If Sonic collides with Eggman while Sonic is jumping, damage Eggman, make bounce Sonic off him
        if (sonic.getCheckJump()) {
            if (e.getOtherBody() instanceof Sonic && e.getReportingBody() instanceof Eggman) {


                //If Eggman's Health is less than
                if(eggman.getEggHealth() > 0) {
                    eggman.decrementEggHealth();
                    eggman.setDamageTimer(1);
                    sonic.startWalking(-10);
                    sonic.jump(15);

                    System.out.println("Eggman Took Damage! His health is now at: " + eggman.getEggHealth());
                }

                //Else, make Eggman dead

                else {
                    eggman.setEggAlive(false);
                }

            }
        }

        //If Sonic collides with Eggman while Sonic is grounded, Sonic loses one ring :(
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

        //If Sonic collides with Eggman while Sonic is grounded, and Sonic has no rings, destroy Sonic :((
        else if (!(sonic.getCheckJump()) && sonic.getRingCount() ==0) {
            if (e.getOtherBody() instanceof Sonic) {
                sonic.setCheckDead(true);
            }
        }

    }

}