package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/*** MetalHoverPlatform- the elevator found at the end of level4*/

public class MetalHoverPlatform extends StaticBody {

    private static final Shape MetalmovingPlatformShape = new BoxShape(3,1.125f);
    private float startXPos;
    private float xPos;
    private float yPos;
    private int motionDirection = 1;
    private float motionSpeed = 0.3f;


    private static final BodyImage movingPlatform = new BodyImage("data/MetalMadness/MetalMovingPlat.png", 2.25f);

    public MetalHoverPlatform(World world) {
        super (world, MetalmovingPlatformShape);
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

    public Shape getShape () {return MetalmovingPlatformShape;}


}
