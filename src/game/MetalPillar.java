package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/*** MetalPillar- a section of the falling ceiling from level4*/


public class MetalPillar extends DynamicBody {


    private static final Shape pillarShape = new BoxShape(2, 8);
    private float startyPos;
    private float yPos;
    private float ySpeed = 0;
    private int motionDirection = -1;
    private int gravity = 0;
    private Sensor metalPillarSensor;


    private static final BodyImage metalPillar =
            new BodyImage("data/MetalMadness/MetalPillar.png", 16);

    public MetalPillar(World world) {
        super (world, pillarShape);
        addImage(metalPillar);
        setGravityScale(gravity);
        getFixtureList().get(0).destroy();
        metalPillarSensor = new Sensor(this, pillarShape);
        metalPillarSensor.setDensity(0);
    }

    public float getyPos() {
        yPos = getPosition().y;
        return yPos;
    }

    public void setyPos(float yPos) {
        setPosition(new Vec2(getPosition().x,yPos));
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

    public Sensor getmetalPillarSensor () {return metalPillarSensor;}

}
