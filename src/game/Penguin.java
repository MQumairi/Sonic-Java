package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/*** Penguin- the Robot penguin found in level2*/

public class Penguin extends Walker {

    private static final Shape badnickShape = new PolygonShape(-0.6f,1.73f, -1.13f,1.09f, -1.16f,-1.69f, 1.09f,-1.7f,
            1.13f,1.29f, 0.43f,1.68f, -0.47f,1.74f);
    private float startXPos;
    private float xPos;
    private int patrolDirection = 1;
    private boolean checkMovingRight = false;


    private static final BodyImage batnik =
            new BodyImage("data/Badnicks/penguinRight.gif", 4);

    public Penguin(World world) {
        super (world, badnickShape);
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
        addImage(new BodyImage("data/Badnicks/penguinRight.gif", 4f));
    }

    public void makeMoveLeft() {
        removeAllImages();
        addImage(new BodyImage("data/Badnicks/penguinLeft.gif", 4f));
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
