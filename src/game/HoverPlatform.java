package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** HoverPlatform - the moving platform from level 3*/


public class HoverPlatform extends StaticBody {

    private static final Shape movingPlatformShape = new BoxShape(2,1.25f);
    private float startXPos;
    private float xPos;
    private float yPos;
    private int motionDirection = 1;
    private float motionSpeed = 0.1f;


    private static final BodyImage movingPlatform = new BodyImage("data/LaunchBase/HoverPlatform.gif", 2.5f);

    public HoverPlatform(World world) {
        super (world, movingPlatformShape);
        addImage(movingPlatform);
    }

    public float getxPos() {
        xPos = getPosition().x;
        return xPos;
    }

    public float getyPos(){
        yPos = getPosition().y;
        return  yPos;
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

    public int getMotionDirection () {
        return motionDirection;
    }

    public void setMotionDirection (int patrolDirection) {
        this.motionDirection = patrolDirection;
    }

    public float getMotionSpeed () { return motionSpeed;}

    public void setMotionSpeed(int motionSpeed) {this.motionSpeed = motionSpeed;}

    public Shape getShape () {return movingPlatformShape;}


}
