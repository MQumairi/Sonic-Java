package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/*** MetalElectricListner- Handles the alternation from being switched on, to being switched off, for the MetalElectric generator obstacle*/

public class MetalElectricListner implements StepListener {

    private MetalElectric metalElectric;

    public MetalElectricListner(MetalElectric metalElectric) {
        this.metalElectric = metalElectric;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if (metalElectric.getTimer() < 300) {
            metalElectric.incrementTimer();
        }

        if(metalElectric.getTimer() == 300) {
            metalElectric.setTimer(0);
        }

        if(metalElectric.getTimer() < 100) {
            metalElectric.setSwitchOn(false);
            metalElectric.removeAllImages();
        }

        if(metalElectric.getTimer() >= 100) {
            metalElectric.setSwitchOn(true);
            metalElectric.addImage(new BodyImage("data/MetalMadness/Electric.gif", 12));
        }

//        System.out.println("Timer = " + metalElectric.getTimer() + " , Is switched on? " + metalElectric.getSwitchOn());
    }

}