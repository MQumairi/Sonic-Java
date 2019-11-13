package game;

import city.cs.engine.*;
import city.cs.engine.Shape;


/*** MetalElectric- the Eelectrical generator obstacle from level4*/


public class MetalElectric extends DynamicBody {


    private static final Shape electricShape = new BoxShape(1.2f, 6);
    private Sensor electricSensor;
    private boolean switchOn = false;
    private int timer = 0;


    private static final BodyImage icePillar =
            new BodyImage("data/MetalMadness/Electric.gif", 12);

    public MetalElectric(World world) {
        super (world, electricShape);
        addImage(icePillar);
        setGravityScale(0);
        getFixtureList().get(0).destroy();
        electricSensor = new Sensor(this, electricShape);
        electricSensor.setDensity(0);
    }

    public boolean getSwitchOn() {
        return switchOn;
    }

    public void setSwitchOn(boolean switchOn) {
        this.switchOn = switchOn;
    }

    public Sensor getElectricSensor () {return electricSensor;}

    public int getTimer(){
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void incrementTimer() {
        timer++;
    }

}
