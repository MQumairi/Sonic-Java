package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/*** MetalPillarMotion- handles the motion of the falling ceiling from level4. When sonic hits the trigger, the ceiling starts
 * falling at slow speed. Once it reaches the floor, it quickly goes back up again*/

public class MetalPillarMotion implements StepListener {

    private MetalPillar metalPillar;
    private MetalTriggerCollision trigger;
    private Sonic sonic;

    public MetalPillarMotion(MetalPillar metalPillar, MetalTriggerCollision trigger, Sonic sonic) {
        this.metalPillar = metalPillar;
        this.trigger = trigger;
        this.sonic = sonic;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {


        if(trigger.getIsTriggered()) {


            metalPillar.move(new Vec2(0, (metalPillar.getySpeed() * metalPillar.getMotionDirection())));



            //Move Ceiling downwards
            if (metalPillar.getyPos() >= metalPillar.getStartyPos()) {
                metalPillar.setMotionDirection(-1);
                metalPillar.setySpeed(0.03f);
            }

            //Move Ceiling upwards

            if (metalPillar.getyPos() <= metalPillar.getStartyPos() - 13) {
                metalPillar.setMotionDirection(1);
                metalPillar.setySpeed(1);
            }





        }

        //If Sonic dies, reset ceiling

        if(sonic.getCheckDead()) {
                metalPillar.setPosition(new Vec2(metalPillar.getPosition().x, metalPillar.getStartyPos()));
                trigger.setIsTriggered(false);
            }

//        System.out.println("Ice Pillar yPos = " + icePillar.getyPos() + ", and Gravity is at = " + icePillar.getGravityScale());

//        System.out.println("Is the Pillar moving? " + trigger.getIsTriggered());

    }

}