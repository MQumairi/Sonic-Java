package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**SonicTracker - Handles Sonic's animations and timers*/

public class SonicTracker implements StepListener {

    private Sonic sonic;
    private float oldY;
    private float newY;
    private float oldX;
    private float newX;
    private int whenToRun = 100;
    private int maximumSpeed = 25;


    public SonicTracker(Sonic sonic) {
        this.sonic = sonic;
    }

    @Override
    public void preStep(StepEvent e) {
        oldY = sonic.getyPos();
        oldX = sonic.getxPos();
    }

    @Override
    public void postStep(StepEvent e) {
        newY = sonic.getyPos();
        newX = sonic.getxPos();

        //Is Y positon constant? If so, set checkJump  to false. But if Y position is changing, set checkJump to true.
        if (oldY == newY) {
            sonic.setCheckJump(false);


            //To make sure sonic is not curlled up in a ball after landing from jump while in motion.
            if (!(oldX == newX) && (!(sonic.getCheckTakingDamage()))){

                if (sonic.getCheckMovingRight()) {

                    if(sonic.getCheckSonicMaxSpeed()) {

                        sonic.makeRunRight();

                    } else if (!(sonic.getCheckSonicMaxSpeed())) {

                        sonic.makeWalkRight();
                    }

                }

                if (!(sonic.getCheckMovingRight())) {

                    if (sonic.getCheckSonicMaxSpeed()) {

                        sonic.makeRunLeft();

                    } else if (!(sonic.getCheckSonicMaxSpeed())) {

                        sonic.makeWalkLeft();
                    }

                }

            }

        } else if (!(oldY == newY)){
            sonic.setCheckJump(true);
                    }

        //Check if sonic's x and y positions are constant. If yes, set checkStand to true. Else, set it to false.
        if (oldY == newY && oldX == newX) {
            sonic.setCheckStand(true);
        } else {
            sonic.setCheckStand(false);
        }

        //If Sonic is not Standing, nor Jumping, and the SpeedCount has not reached the limit (whenToRun), increment SonicSpeedCounter.
        if((!(sonic.getCheckStand()) && (!(sonic.getCheckJump()) && sonic.getSonicSpeedCount() < whenToRun))) {
            sonic.incrementSonicSpeedCount();
        }

        //If sonic stops, or takes damage, reset SonicSpeedCounter, Speed, and CheckRunning
        else if (sonic.getCheckStand() || sonic.getCheckTakingDamage()) {
            sonic.setSonicSpeedCount(0);
            sonic.setSonicSpeed(sonic.getSonicDefaultSpeed());
            sonic.setCheckRuning(false);
        }

        //If SonicSpeedCounter is at its limit (whenToRun), set checkRunning to true. If it is less than the limit, set checkRunning to false.
        if(sonic.getSonicSpeedCount() == whenToRun) {
            sonic.setCheckRuning(true);
        } else if (sonic.getSonicSpeedCount() < whenToRun) {
            sonic.setCheckRuning(false);
        }

        //If Sonic is running, not jumping, and his speed is less than or equal to the maximum speed, increment his speed.
        if(sonic.getCheckRunning() && (!(sonic.getCheckJump()) && sonic.getSonicSpeed() <= maximumSpeed)) {
            sonic.incrementSonicSpeed();
        }

        //If sonic's speed is greater than maximum speed, set checkSnonicMaxSpeed to true. Else, set it to false.
        if (sonic.getSonicSpeed() > maximumSpeed) {
            sonic.setCheckSonicMaxSpeed(true);
        } else {
            sonic.setCheckSonicMaxSpeed(false);
        }

        //If sonic is standing, either give him stand right or stand left images depending on the most recent direction moved in.
        if (sonic.getCheckStand()) {
            if(sonic.getCheckMovingRight()) {
                sonic.makeStandRight();
            }

            if(!(sonic.getCheckMovingRight())) {
                sonic.makeStandLeft();
            }
        }

        //If sonic takes damage start the damage counter for take damage animation. 70ms long animation.
        if (sonic.getTakeDamageCount() >= 1 && sonic.getTakeDamageCount() < 70) {
            sonic.incrementTakeDamageCount();
            sonic.setCheckTakingDamage(true);
        }

        //If the damage counter for the take damage animation reaches 40ms, end the animation. Return sonic to either
        //stand right or stand left images.
        if(sonic.getTakeDamageCount() == 40) {
            sonic.setTakeDamageCount(0);
            sonic.setCheckTakingDamage(false);
            sonic.stopWalking();

            if(sonic.getCheckMovingRight()) {
                sonic.makeStandRight();
            }

            if(!(sonic.getCheckMovingRight())) {
                sonic.makeStandLeft();
            }
        }

        //When sonic takes damage, make him fall back.
        if(sonic.getCheckTakingDamage()) {

            if (sonic.getCheckMovingRight()) {
                sonic.makeDamagedRight();

            } else if (!(sonic.getCheckMovingRight())) {
                sonic.makeDamagedLeft();

            }
        }

        //If Sonic is standing on a moving Platform, make him stand
        if (sonic.getCheckOnBoard() && sonic.getCheckStand()) {

            if(sonic.getCheckMovingRight()) {
                sonic.makeStandRight();
            } else {
                sonic.makeStandLeft();
            }

        }

        //If Sonic recieves death blow, change his picture and start incrementing the death counter
        if (sonic.getCheckDead()) {
            sonic.incrementDeathCount();
            sonic.makeDead();
        }

        //When death counter reaches 30, if Sonic has no lives, destroy Sonic. Else Respawn him.
        if (sonic.getDeathCount() >= 30) {
            if (sonic.getLiveCount() == 0) {
                sonic.destroy();
            } else {
                sonic.decrementLives();
                sonic.respawn();
                sonic.setCheckDead(false);
            }
        }

        //When Live Ticker Reaches 10, gain a life, and then reset the ticker.
        if (sonic.getLiveTicker() >= 10) {
            sonic.incrementLives();
            sonic.setLiveTicker(0);
        }

    }

    public void setSonic (Sonic sonic) {
        this.sonic = sonic;
    }

}