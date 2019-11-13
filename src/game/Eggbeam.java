package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** Eggbeam - Eggman's Laser Beam*/

public class Eggbeam extends Walker {

    private static final Shape beamShape = new BoxShape(1.5f, 0.5f);
    private float startXPos;
    private float xPos;
    private int patrolDirection = 1;
    private static final BodyImage beamImage =
            new BodyImage("data/Eggman/eggbeam.png", 1);

    private Sensor beamSensor;
    private boolean harmful = false;


    public Eggbeam(World world) {
        super (world, beamShape);
        getFixtureList().get(0).destroy();
        beamSensor = new Sensor(this, beamShape);
        beamSensor.setDensity(0);
        setGravityScale(0);
    }

    //Position

    public float getxPos() {
        xPos = getPosition().x;
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getStartXPos(){
        return startXPos;
    }

    public void setStartXPos(float startXPos) {
        this.startXPos = startXPos;
    }


    //Move

    public void moveBeam() {
//            setLinearVelocity(new Vec2(-30, 0));
        if(getxPos() > -20) {
            startWalking(-30);
        }

        if(getxPos() < -20) {
            stopWalking();
        }
    }

    //Manipulate Images
    public void removeImage() {
        removeAllImages();
        harmful = false;
    }

    public void addImage() {
        addImage(beamImage);
        harmful = true;
    }


    //Harmful

    public boolean isHarmful() {
        return harmful;
    }


    //Return Sensor
    public Sensor getBeamSensor() {
        return beamSensor;
    }
}
