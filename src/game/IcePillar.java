package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** IcePillar - the IcePillar from Level2*/

public class IcePillar extends DynamicBody {


    private static final Shape pillarShape = new BoxShape(2, 10);
    private float startyPos;
    private float yPos;
    private float ySpeed = 0.04f;
    private int motionDirection = 1;
    private int gravity = 0;
    private Sensor icePillarSensor;


    private static final BodyImage icePillar =
            new BodyImage("data/IceCap/IcePillar.png", 20);

    public IcePillar(World world) {
        super (world, pillarShape);
        addImage(icePillar);
        setGravityScale(gravity);
        getFixtureList().get(0).destroy();
        icePillarSensor = new Sensor(this, pillarShape);
        icePillarSensor.setDensity(0);
    }

    public float getyPos() {
        yPos = getPosition().y;
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public float getStartyPos(){
        return startyPos;
    }

    public void setStartyPos(float startXPos) {
        this.startyPos = startXPos;
    }

    public int getMotionDirection () {
        return motionDirection;
    }

    public void setMotionDirection (int motionDirection) {
        this.motionDirection = motionDirection;
    }

    public float getySpeed() {return ySpeed;}

    public void setySpeed(float ySpeed) {this.ySpeed = ySpeed;}

    public Sensor getIcePillarSensor () {return icePillarSensor;}

}
