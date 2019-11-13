package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** Eggbomb - Eggman's Bomb*/

public class Eggbomb extends Walker {

//The Crabmeat (robot crab).

    private static final Shape bombShape = new CircleShape(1);
    private float xPos;
    private float yPos;
    private static final BodyImage bombImage =
            new BodyImage("data/Eggman/bomb.gif", 2);

    private Sensor bombsensor;
    private boolean harmful = false;


    public Eggbomb(World world) {
        super (world, bombShape);
//        addImage(bombImage);
        getFixtureList().get(0).destroy();
        bombsensor = new Sensor(this, bombShape);
        bombsensor.setDensity(0);
        setGravityScale(0);
    }

    //Position

    public float getxPos() {
        xPos = getPosition().x;
        return xPos;
    }

    public float getyPos() {
        yPos = getPosition().y;
        return yPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }



    //Move

    public void moveBomb() {
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
        addImage(bombImage);
        harmful = true;
    }


    //Harmful

    public boolean isHarmful() {
        return harmful;
    }

    //Sensor
    public Sensor getBombsensor() {
        return bombsensor;
    }
}
