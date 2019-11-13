package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/** HoverPlatformMotion - Handles the oscillating motion of the HoverPlatform of level 3*/

public class HoverPlatformMotion implements StepListener {

    private HoverPlatform hoverPlatform;
    private float startPos;
    private float endPos;
    private boolean isVertical;

    public HoverPlatformMotion(HoverPlatform hoverPlatform, float startPos, float endPos, boolean isVertical) {
        this.hoverPlatform = hoverPlatform;
        this.startPos = startPos;
        this.endPos = endPos;
        this.isVertical = isVertical;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if(isVertical) {

            //Vertical Motion
            hoverPlatform.move(new Vec2(0, (hoverPlatform.getMotionSpeed() * hoverPlatform.getMotionDirection())));

            if (hoverPlatform.getyPos() <= startPos) {
                hoverPlatform.setMotionDirection(1);
            }

            if(hoverPlatform.getyPos() >= endPos) {
                hoverPlatform.setMotionDirection(-1);
            }

        } else {

            //Horizontal Motion
            hoverPlatform.move(new Vec2((hoverPlatform.getMotionSpeed() * hoverPlatform.getMotionDirection()), 0));

            if (hoverPlatform.getxPos() <= startPos) {
                hoverPlatform.setMotionDirection(1);
            }

            if(hoverPlatform.getxPos() >= endPos) {
                hoverPlatform.setMotionDirection(-1);
            }
        }




//        System.out.println("Yposition for platform = " + hoverPlatform.getyPos() + " , Direction of platform = " + hoverPlatform.getMotionDirection()
//        + ", Speed of platform = " + hoverPlatform.getMotionSpeed());
    }


}