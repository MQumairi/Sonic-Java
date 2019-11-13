package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/*** Level5ScrollFloor- handles the motion of Level5's floor*/

public class Level5ScrollFloor implements StepListener {

    private Level5Floor floor;

    public Level5ScrollFloor(Level5Floor floor) {
        this.floor = floor;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
    }

    @Override
    public void postStep(StepEvent stepEvent) {

        floor.move(new Vec2(-0.5f, 0));


        if(floor.getxPos() <= -50) {
            floor.resetX();
        }

//        System.out.println(floor.getxPos());

    }
}
