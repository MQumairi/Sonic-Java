package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/*** Level5Floor- the scrolling floor from the level5 boss fight*/

public class Level5Floor extends StaticBody {

    private static final Shape movingPlatformShape = new BoxShape(2,2);
    private float startXPos;
    private float xPos;
    private float yPos;
    private int motionDirection = 1;
    private float motionSpeed = 0.1f;
    private boolean checkWeighted = false;


    private static final BodyImage movingPlatform = new BodyImage("data/MetalMadness/MetalTopPlat.png", 4);

    public Level5Floor(World world) {
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

    public void resetX () {
        setPosition(new Vec2(30, 0));
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

    public Shape getShape () {return movingPlatformShape;}

}
