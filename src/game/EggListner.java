package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;


/** Egglistner - Handles the phasing of the final boss fight*/

public class EggListner implements StepListener {

    private Eggman eggman;
    private Eggbeam beam;
    private Eggbomb bomb;
    private Sonic sonic;


    public EggListner(Eggman eggman, Eggbeam beam, Eggbomb bomb, Sonic sonic) {
        this.eggman = eggman;
        this.beam = beam;
        this.bomb = bomb;
        this.sonic = sonic;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {



        //The time for boss to go through one cycle
        int maxTime = 2200;


        //Time cycle

        if(eggman.isEggAlive()) {

            if (eggman.getEggTime() < maxTime) {
                eggman.incrementTimer();
            } else {
                eggman.resetTimer();
            }
        }



        //State Cycle

        if(eggman.isEggAlive()) {

            if (eggman.getEggTime() < 200) {

                eggman.setEggState(1);
                //Make bomb disappear
                bomb.removeImage();
            } else if (eggman.getEggTime() < 1000) {

                eggman.setEggState(2);
                //Make bomb disappear
                bomb.removeImage();
            } else if (eggman.getEggTime() < 1400) {
                eggman.setEggState(3);
                //Make bomb disappear
                bomb.removeImage();
            } else if (eggman.getEggTime() < 1950) {
                eggman.setEggState(4);
                //Make bomb appear
                bomb.addImage();
            } else if (eggman.getEggTime() < maxTime) {
                eggman.setEggState(5);
                //Make bomb disappear
                bomb.removeImage();
            } else if (eggman.getEggTime() == maxTime) {
                eggman.setEggState(1);
                //Make bomb disappear
                bomb.removeImage();
            }
        } else {
            eggman.move(new Vec2(0, 0.3f));
        }


        //If Eggman is not alive, make him toasted, move him upwards and increment the Death Timer. When timer reaches 100, end game.

        if(!eggman.isEggAlive()){
            eggman.makeToasted();
            eggman.incrementDeathTimer();
        }

        if(eggman.deathTimer == 100) {
            System.out.println("Game Completed!");
            GameComplete gameComplete = new GameComplete(eggman.getWorld());
            gameComplete.setPosition(new Vec2(0, 8));
//            System.exit(0);
        }

        //If Eggman's damage timer is switched from 0 to 1, increment it, make him angry, and when it reaches 50, reset it to 0.

        if(eggman.getDamageTimer() > 0) {
            eggman.incrementDamageTimer();
            eggman.makeAngry();
        }

        if(eggman.getDamageTimer() == 50) {
            eggman.setDamageTimer(0);
            eggman.makeIdle();
        }

        //Beam Cycle

        if(beam.getxPos() < -20) {
            beam.removeImage();
            beam.setPosition(new Vec2(eggman.getPosition()));
            beam.stopWalking();
        }

        //Bomb Cycle
        if(bomb.getyPos() < 0) {
            bomb.setPosition(eggman.getPosition());
        } else {
            bomb.move(new Vec2(0, -0.3f));
        }



        //        EGG STATES
        //        State 1 = Transition
        //        State 2 = Beam phase
        //        State 3 = Transition
        //        State 4 = Bomb Phase
        //        State 5 = Transition


        //STATE 1 - if the timer is less than 50, make eggman enter the level starting from x=9, y=20


            if (eggman.getEggState() == 1) {

                //When timer resets, move Eggman to start position
                if(eggman.getEggTime() == 0) {
                    eggman.setPosition(eggman.getStartPos());
                }

                //Then move him downards to idle position (9, 10)

                if(eggman.getEggTime() > 0) {
                    if(eggman.getyPos() >= 10)
                       eggman.move(new Vec2(0, -0.15f));
                }

            }


        //STATE 2 - if the timer is less than 500, make eggman enter beam mode. y-pos = sonic's y-pos. Fire beams ever 100.


            if (eggman.getEggState() == 2) {

                //If Eggmna's yPos is less than Sonic's move Eggman upwards

                if(eggman.getyPos() < sonic.getyPos() + 1) {
                    eggman.move(new Vec2(0, 0.3f));
                }

                //If Eggman's yPos is greater than Sonic's move Eggman downards

                if(eggman.getyPos() > sonic.getyPos() + 1) {
                    eggman.move(new Vec2(0, -0.3f));
                }


                //Eggman Shoots - at marks 200, 350, 500, 750, 900

                shoot(200);
                shoot(350);
                shoot(500);
                shoot(750);
                shoot(900);

            }


        //STATE 3 (1000 to 1400) - move up, then down to initiate bomb phase


        if(eggman.getEggState() == 3) {

            //before mark 1200, move Eggman up

            if (eggman.getEggTime() < 1200) {

                if (eggman.getyPos() < 30) {

                    eggman.move(new Vec2(0, 0.5f));

                }
            }

            //At mark 1200, set Eggman to position 0, 30

            else if (eggman.getEggTime() == 1200) {

                eggman.setPosition(new Vec2(0, 30));

            }


            //Between marks 1200 to 1400, move eggman downwards, if his yPos is less than 17, else set his yPos to 11

            else if (eggman.getEggTime() < 1400) {

                if (eggman.getyPos() > 17) {

                    eggman.move(new Vec2(0, -0.15f));

                }
            }

            //At mark 1400, set Eggman to position 0, 16

            else if (eggman.getEggTime() == 1400){
                    eggman.setPosition(new Vec2 (0, 17));
            }


        }


        //STATE 4 (1400 to 2000) - bomb phase

            if(eggman.getEggState() == 4) {


                if(eggman.getEggTime() == 1400) {
                    bomb.setPosition(eggman.getPosition());
                }

                //If Eggman's xPos is less than Sonic's xPos, move eggman to the right

                if(eggman.getxPos() < sonic.getxPos()) {

                    eggman.move(new Vec2(0.1f, 0));

                }

                //If Eggman's xPos is greater than Sonic's xPos, move eggman to the left

                if(eggman.getxPos() > sonic.getxPos()) {

                    eggman.move(new Vec2(-0.1f, 0));

                }


            }


        //STATE 5 (1950 to 2200) - move up and reset


            if(eggman.getEggState() == 5) {

                if (eggman.getEggTime() < maxTime) {

                    eggman.move(new Vec2(0, 0.5f));

                } else if (eggman.getEggTime() == maxTime) {

                    eggman.setPosition(eggman.getStartPos());

                }
            }

        }

    public void shoot(int time) {
        if (eggman.getEggTime() == time) {
            beam.setPosition(new Vec2(eggman.getPosition()));
            beam.addImage();
            beam.moveBeam();
        }
    }

}