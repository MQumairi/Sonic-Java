package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** Batnik - the Robot bat from level 1*/

public class Batnik extends Walker {


    private static Shape batnikLeftShape = new PolygonShape(-1.86f,1.49f, -1.78f,-1.62f, 0.78f,-1.8f, 1.88f,0.0f, 1.61f,1.72f, -1.54f,1.58f);
    private float startXPos;
    private float xPos;
    private int patrolDirection = 1;
    private boolean checkMovingRight = false;


    private static final BodyImage batnik =
            new BodyImage("data/Badnicks/batnikRight.gif", 4);

    public Batnik(World world) {
        super (world, batnikLeftShape);
        addImage(batnik);
        setGravityScale(0);
    }

    public boolean getCheckMovingRight() {
        return checkMovingRight;
    }

    public void setCheckMovingRight(boolean checkMovingRight) {
        this.checkMovingRight = checkMovingRight;
    }

    public void makeMoveRight() {
        removeAllImages();
        addImage(new BodyImage("data/Badnicks/batnikRight.gif", 4f));
    }

    public void makeMoveLeft() {
        removeAllImages();
        addImage(new BodyImage("data/Badnicks/batnikLeft.gif", 4f));
    }

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

    public int getPatrolDirection () {
        return patrolDirection;
    }

    public void setPatrolDirection (int patrolDirection) {
        this.patrolDirection = patrolDirection;
    }
}
