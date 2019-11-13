package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.io.IOException;


/** Eggman - aka Dr.Robotnik, the final boss of the final level */

public class Eggman extends StaticBody {

    /** the Game*/
    private Game game;

    /** Eggman's Shape*/
    private static Shape eggShape = new CircleShape(3);

    /** Eggman's Image*/
    private static BodyImage eggIdle =
            new BodyImage("data/Eggman/idle.gif", 6);


    /** Eggman's starting position*/
    Vec2 startPos;

    /** Eggman's xPosition*/
    float xPos = getPosition().x;

    /** Eggman's yPosition*/
    float yPos = getPosition().y;

    /** Eggman's State - default is 1 - he has five:
     * EGG STATES
     * State 1 = Transition - Eggman enters the level
     * State 2 = Beam phase - Eggman moves vertically and fires beams periodically
     * State 3 = Transition - Eggman flies up
     * State 4 = Bomb Phase - Eggman moves horizontally and drops bombs continuously
     * State 5 = Transition - Eggman flies up, restart phase1
     * */
    int eggState = 1;

    /**Timer for Eggman - cycles in Egglistner to phase events and states*/
    int eggTime = 0;

    /**Timer for how long Eggman should have the taken damage animation- triggered when sonic hits him*/
    int damageTimer = 0;

    /**Timer for how long Eggman should have the death animation- triggered when sonic defeats him*/
    int deathTimer = 0;

    /**Is Eggman alive?*/
    boolean eggAlive = true;

    /**Eggman's Health - starts on 10*/
    int eggHealth = 10;

    /** Eggman's's Constructor*/
    public Eggman(World world) {
        super(world, eggShape);
        this.game = game;
        addImage(eggIdle);
    }

    /**Get Eggman's current state**/
    public int getEggState() {
        return eggState;
    }

    /**Set Eggman's  state**/
    public void setEggState(int eggState) {
        this.eggState = eggState;
    }

    /**Get the Egg Timer*/
    public int getEggTime() {
        return eggTime;
    }

    /**Set the Egg Timer*/
    public void setEggTime(int eggTime) {
        this.eggTime = eggTime;
    }

    /**Increment the Egg Timer*/
    public void incrementTimer() {
        eggTime++;
    }

    /**Reset the Egg Timer*/
    public void resetTimer() {
        setEggTime(0);
    }

    /**Get the Damage Timer*/
    public int getDamageTimer() {
        return damageTimer;
    }

    /**Set the Damage Timer*/
    public void setDamageTimer(int damageTimer) {
        this.damageTimer = damageTimer;
    }

    /**Increment the Damage Timer*/
    public void incrementDamageTimer() {
        damageTimer++;
    }

    /**Get the Death Timer*/
    public int getDeathTimer() {
        return deathTimer;
    }

    /**Set the Death Timer*/
    public void setDeathTimer(int deathTimer) {
        this.deathTimer = deathTimer;
    }

    /**Increment the Death Timer*/
    public void incrementDeathTimer() {
        deathTimer++;
    }

    //Egg Images

    /**Make Eggman Angry - triggered for a short time after sonic hits him*/
    public void makeAngry() {
        removeAllImages();
        addImage(new BodyImage("data/Eggman/hit.png", 6));
    }

    /**Make Eggman toasted - triggered after sonic defeats him*/
    public void makeToasted() {
        removeAllImages();
        addImage(new BodyImage("data/Eggman/toasted.png", 6));
    }

    /**Reset Eggman to the default idle animation*/
    public void makeIdle() {
        removeAllImages();
        addImage(new BodyImage("data/Eggman/idle.gif", 6));
    }

    /**Get Eggman's Health*/
    public int getEggHealth() {
        return eggHealth;
    }

    /**Set Eggman's Health*/
    public void setEggHealth(int eggHealth) {
        this.eggHealth = eggHealth;
    }

    /**Decrement Eggman's Health - triggered when sonic hits him*/
    public void decrementEggHealth() {
        eggHealth--;
    }

    /**Checks if Eggman is alive*/
    public boolean isEggAlive() {
        return eggAlive;
    }

    /**Sets if Eggman is alive* or not */
    public void setEggAlive(boolean eggAlive) {
        this.eggAlive = eggAlive;
    }


    /**Returns Eggman's starting position (this is assigned when Eggman is instantiated in level5 */
    public Vec2 getStartPos() {
        return startPos;
    }

    /**Sets Eggman's Starting position*/
    public void setStartPos(Vec2 startPos) {
        this.startPos = startPos;
    }


    /** Get Eggman's xPosition*/
    public float getxPos() {
        return getPosition().x;
    }

    /** Set Eggman's xPosition*/
    public void setxPos(float xPos) {
        this.xPos = xPos;
        setPosition(new Vec2(xPos, yPos));
    }

    /** Get Eggman's yPosition*/
    public float getyPos() {
        return getPosition().y;
    }

    /** Set Eggman's yPosition*/
    public void setyPos(float yPos) {
        this.yPos = yPos;
        setPosition(new Vec2(xPos, yPos));
    }

}

