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
import java.util.Set;


/**Sonic*/

public class Sonic extends Walker {
    private Game game;


    /**Sonic' Shape*/
    private static Shape sonicShape = new PolygonShape(
            -1.54f, 1.97f, -1.53f, -1.96f, 1.61f, -2.0f, 0.75f, 1.92f, -1.21f, 1.98f);

    /**Sonic's Default Image*/
    private static BodyImage sonicStand =
            new BodyImage("data/Sonic/sonicStand.gif", 4);

    /** Sonic's Rings*/
    private int ringCount;

    /** Sonic's Lives- default is 3*/
    private int liveCount = 3;

    /** Field that counts for 10 rings. When Sonic gets 10 rings, he gets a life, and the ticker resets*/
    private int liveTicker = 0;

    /** Damage timer - handles how long Sonic will be on damaged animation*/
    private int takeDamageCount;

    /** Sonic's Speed - Sonic's current speed */
    private float sonicSpeed;

    /** Sonic's Default Speed - 15 */
    private float sonicDefaultSpeed = 15;

    /** Sonic's Speed Count - handles sonic's acceleration, starting from default speed. When he reaches maximum speed, his animation changes */
    private int sonicSpeedCount;

    /** Sonic's Death Count - handles how long Sonic will be on death animation*/
    private int deathCount;

    /** Is Sonic Jumping?*/
    private boolean checkJump = false;

    /** Is Sonic Standing?*/
    private boolean checkStand = true;

    /** Did Sonic recently take damage?*/
    private boolean checkTakingDamage = false;

    /** Had Sonic been moving to the right?*/
    private boolean checkMovingRight = true;

    /** Is Sonic Running?*/
    private boolean checkRunning = false;

    /** Is Sonic on max speed?*/
    private boolean checkSonicMaxSpeed = false;

    /** Is Sonic standing on a hover platform?*/
    private boolean checkOnboard = false;

    /** Did Sonic die?*/
    private boolean checkDead = false;

    /** Sonic's Constructor*/
    public Sonic(World world, Game game) {
        super(world, sonicShape);
        this.game = game;
        addImage(sonicStand);
        ringCount = 0;
        takeDamageCount = 0;
        sonicSpeed = sonicDefaultSpeed;
        setGravityScale(5);
    }



    /** Get Sonic's Shape*/
    public Shape getSonicShape() {
        return sonicShape;
    }

    /** Set Sonic's Shape*/
    public void setSonicShape(Shape sonicShape) {
        this.sonicShape = sonicShape;
    }

    /** Get Sonic's xPosition*/
    public float getxPos() {
        return getPosition().x;
    }

    /** Get Sonic's yPosition*/
    public float getyPos() {
        return getPosition().y;
    }

    /** Check if Sonic is Jumping*/
    public boolean getCheckJump() {
        return checkJump;
    }

    /** Set Sonic to jumping or not*/
    public void setCheckJump(boolean checkJump) {
        this.checkJump = checkJump;
    }

    /** Check if Sonic to standing*/
    public boolean getCheckStand() {
        return checkStand;
    }

    /** Set Sonic to standing or not*/
    public void setCheckStand(boolean checkStand) {
        this.checkStand = checkStand;
    }

    /** Check if Sonic is running */
    public boolean getCheckRunning() {return checkRunning;}

    /** Set Sonic to running or not*/
    public void setCheckRuning(boolean checkRuning) {this.checkRunning = checkRuning;}

    /** Check if Sonic is taking damage */
    public boolean getCheckTakingDamage() { return checkTakingDamage; }

    /** Set Sonic to taking damage or not*/
    public void setCheckTakingDamage(boolean checkTakingDamage) {
        this.checkTakingDamage = checkTakingDamage;
    }

    /** Check if Sonic is moving to the right or not */
    public boolean getCheckMovingRight() { return checkMovingRight; }

    /** Set Sonic to moving to the right or not*/
    public void setCheckMovingRight(boolean checkMovingLeft) {
        this.checkMovingRight = checkMovingLeft;
    }

    /** Check if Sonic is on top of a hovering platform */
    public boolean getCheckOnBoard() { return checkOnboard;}

    /** Set Sonic to standing on a hovering platform or not*/
    public void setCheckOnboard(boolean checkOnboard) {this.checkOnboard = checkOnboard;}

    /** Check if Sonic is running */
    public boolean getCheckDead() { return checkDead;}

    /** Set Sonic to dying or not*/
    public void setCheckDead(boolean checkDead) {this.checkDead = checkDead;}

    /**Get Sonic Default Speed*/
    public float getSonicDefaultSpeed() {return  sonicDefaultSpeed;}

    /**Get Sonic Speed*/
    public float getSonicSpeed() {return sonicSpeed;}

    /**Set Sonic Speed*/
    public void setSonicSpeed(float sonicSpeed) {this.sonicSpeed = sonicSpeed;}

    /**Increment Sonic Speed*/
    public void incrementSonicSpeed() {
        sonicSpeed+=0.5;
    }

    /**Get Sonic Speed Counter to check how long between default speed and maxspeed*/
    public int getSonicSpeedCount() {
        return sonicSpeedCount;
    }

    /**Sets the count since acceleration*/
    public void setSonicSpeedCount(int sonicSpeedCount) {
        this.sonicSpeedCount = sonicSpeedCount;
    }

    /**Increment the acceleration timer - once it reaches the top limit, sonic should set to max speed */
    public void incrementSonicSpeedCount() {
        sonicSpeedCount++;
    }

    /**Gets the count since death blow - how long Sonic has been on death animation*/
    public int getDeathCount() {return deathCount;}

    /**Sets the count since death blow - how long Sonic has been on death animation*/
    public void setDeathCount(int deathCount) {this.deathCount = deathCount;}

    /**Increment the count since death blow - how long Sonic has been on death animation*/
    public void incrementDeathCount() {deathCount++;}

    /**Checks if Sonic is on max speed or not*/
    public boolean getCheckSonicMaxSpeed() { return checkSonicMaxSpeed;}

    /**Sets to max speed*/
    public void setCheckSonicMaxSpeed(boolean checkSonicMaxSpeed) { this.checkSonicMaxSpeed = checkSonicMaxSpeed;}


    /**Gives Sonic Jump animation*/
    public void makeJump() {
        removeAllImages();
        addImage(new BodyImage("data/Sonic/sonicJump.gif", 2.5f));
        setCheckOnboard(false);
    }

    /**Gives Sonic the Walk Left animation, unless sonic is on level 5, in which case his animation should remain constant*/
    public void makeWalkLeft() {
        removeAllImages();

        if(game.getLevelNumber() != 5) {
            addImage(new BodyImage("data/Sonic/sonicWalkLeft.gif", 4f));
        }

        else {
            addImage(new BodyImage("data/Sonic/sonicWalkRight.gif", 4f));
        }

    }

    /**Gives Sonic the Walk Right animation*/
    public void makeWalkRight() {
        removeAllImages();
        addImage(new BodyImage("data/Sonic/sonicWalkRight.gif", 4f));
    }

    /**Gives Sonic the standing anaimation*/
    public void makeStop() {
        removeAllImages();
        addImage(new BodyImage("data/Sonic/sonicStand.gif", 4));
    }

    /**Gives Sonic the Take Damage Left Picture*/
    public void makeDamagedLeft() {
        removeAllImages();

        if(game.getLevelNumber() != 5) {
            addImage(new BodyImage("data/Sonic/DamageLeft.png", 4.7f));
            startWalking(10);
            jump(15);
        }

        else {
            addImage(new BodyImage("data/Sonic/DamageRight.png", 4.7f));
        }
    }

    /**Gives Sonic the Take Damage Right Picture*/
    public void makeDamagedRight() {
        removeAllImages();
        addImage(new BodyImage("data/Sonic/DamageRight.png", 4.7f));
        startWalking(-10);
        jump(15);
    }

    /**Gives Sonic the Stand Left Picture, unless Sonic is on level5, else keep him walking right*/
    public void makeStandLeft() {

        removeAllImages();

        if(game.getLevelNumber() != 5) {
            addImage(new BodyImage("data/Sonic/SonicStandLeft.png", 4));
        }

        else {
            addImage(new BodyImage("data/Sonic/sonicWalkRight.gif", 4f));
        }
    }

    /**Gives Sonic the Stand Right Picture, unless Sonic is on level5, else keep him walking right*/
    public void makeStandRight() {
        removeAllImages();

        if(game.getLevelNumber() != 5) {
            addImage(new BodyImage("data/Sonic/SonicStandRight.png", 4));
        }
        else {
            addImage(new BodyImage("data/Sonic/sonicWalkRight.gif", 4f));
        }
    }

    /**Gives Sonic the Run Left animation*/
    public void makeRunLeft() {
        removeAllImages();

        if(game.getLevelNumber() != 5) {
            addImage(new BodyImage("data/Sonic/sonicRunLeft.gif", 3.8f));
        }

        else {
            addImage(new BodyImage("data/Sonic/sonicRunRight.gif", 3.8f));
        }
    }

    /**Gives Sonic the Run Right animation*/
    public void makeRunRight() {
        removeAllImages();
        addImage(new BodyImage("data/Sonic/sonicRunRight.gif", 3.8f));
    }

    /**Gives Sonic the Dead Picture*/
    public void makeDead() {
        removeAllImages();
        addImage(new BodyImage("data/Sonic/SonicDead.png", 3.8f));
        jump(30);
    }



    /**Returns the number of Rings Sonic has*/
    public int getRingCount() {
        return ringCount;
    }

    /**Sets th enumber of rings Sonic has*/
    public void setRingcount(int ringCount) {
        this.ringCount = ringCount;
    }

    /**Increase Rings by 1*/
    public void incrementRingCount() {
        ringCount++;
    }

    /**Decrease Rings by 1*/
    public void deccrementRingCount() {
        ringCount--;
    }

    /**Returns the number of Lives Sonic*/
    public int getLiveCount() {return  liveCount;}

    /**Sets the Live Count of Sonic*/
    public void setLiveCount(int liveCount) {
        this.liveCount = liveCount;
    }

    /**Increase Lives by 1*/
    public void incrementLives() {
        liveCount++;
        System.out.println("New Life! Current total = " + liveCount);
    }

    /**Decrease Lives by 1*/
    public void decrementLives() {
        liveCount--;
        System.out.println("Loss of Life! Current total = " + liveCount);
    }

    /**Get Live Ticker (to increment lives by 1 every 10 rings collected)*/
    public int getLiveTicker() {
        return liveTicker;
    }

    /** Set Live Ticket*/
    public void setLiveTicker(int liveTicker) {
        this.liveTicker = liveTicker;
    }

    /**Increment Live Ticker*/
    public void incrementLiveTicker() {
        liveTicker++;
    }

    /**Respawn Sonic if he dies without 0 lives*/
    public void respawn() {
        if (checkDead) {
            setPosition(new Vec2(0, 6));
            makeStop();
            this.setDeathCount(0);
        }
    }

    /**Returns the count since taking damage*/
    public int getTakeDamageCount() {
        return takeDamageCount;
    }

    /**Sets the count since taking damage*/
    public void setTakeDamageCount(int takeDamageCount) {
        this.takeDamageCount = takeDamageCount;
    }

    /**Count up after taking damage*/
    public void incrementTakeDamageCount() {
        takeDamageCount++;
    }

}

