package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/** IcePillarMotion - Handles how the IcePillar from level2 moves */

public class IcePillarMotion implements StepListener {

    private IcePillar icePillar;
    private float speedMultiplier;

    public IcePillarMotion(IcePillar icePillar) {
        this.icePillar = icePillar;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        icePillar.move(new Vec2(0, (icePillar.getySpeed() * icePillar.getMotionDirection())));


        if (icePillar.getyPos() <= icePillar.getStartyPos()) {
            icePillar.setMotionDirection(1);
            icePillar.setySpeed(0.04f * speedMultiplier);
        }

        if (icePillar.getyPos() >= icePillar.getStartyPos() + 13) {
            icePillar.setMotionDirection(-1);
            icePillar.setySpeed(1 * speedMultiplier);
        }

//        System.out.println("Ice Pillar yPos = " + icePillar.getyPos() + ", and Gravity is at = " + icePillar.getGravityScale());

    }


    public void setSpeedMultiplier(float speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }



}