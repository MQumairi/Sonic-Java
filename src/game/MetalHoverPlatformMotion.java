package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*** MetalHoverPlatformMotion- handles the motion of MetalHoverPlatform*/

public class MetalHoverPlatformMotion implements StepListener {

    private MetalHoverPlatform metalHoverPlatform;
    private float startPos;
    private float endPos;

    public MetalHoverPlatformMotion(MetalHoverPlatform metalHoverPlatform, float startPos, float endPos) {
        this.metalHoverPlatform = metalHoverPlatform;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {


        //Vertical Motion
        metalHoverPlatform.move(new Vec2(0, (metalHoverPlatform.getMotionSpeed() * metalHoverPlatform.getMotionDirection())));

        if (metalHoverPlatform.getyPos() >= startPos) {
            metalHoverPlatform.setMotionDirection(-1);
        }

        if (metalHoverPlatform.getyPos() <= endPos) {
            metalHoverPlatform.setMotionDirection(1);
        }


//        System.out.println("Yposition for Platform = " + metalHoverPlatform.getyPos() + " , Platform direciton = " + metalHoverPlatform.getMotionDirection());
    }



//        System.out.println("Yposition for platform = " + hoverPlatform.getyPos() + " , Direction of platform = " + hoverPlatform.getMotionDirection()
//        + ", Speed of platform = " + hoverPlatform.getMotionSpeed());


}