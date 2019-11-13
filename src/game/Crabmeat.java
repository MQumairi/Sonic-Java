package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;


/** Crabmeat - the Robot crab from level 1*/


public class Crabmeat extends Walker {


    private static final Shape badnickShape = new PolygonShape(-2.191f,1.21f, -2.474f,0.775f, -2.423f,-1.224f,
             2.464f,-1.153f, 2.494f,0.745f, 2.08f,1.2f, -2.04f,1.22f);
    private float startXPos;
    private float xPos;
    private int patrolDirection = 1;


    private static final BodyImage badnick =
            new BodyImage("data/Badnicks/crabMeat.gif", 2.5f);

    public Crabmeat(World world) {
        super (world, badnickShape);
        addImage(badnick);
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
