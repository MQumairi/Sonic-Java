package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;


/*** GreenHillSmallPlatform- The small platform founds in level1*/


public class GreenHillSmallPlatform extends StaticBody {

    private static final Shape movingPlatformShape = new BoxShape(2,0.75f);
    private float xPos;

    private static final BodyImage movingPlatform = new BodyImage("data/GreenHill/GreenMovingPlat.png", 1.5f);

    public GreenHillSmallPlatform(World world) {
        super (world, movingPlatformShape);
        addImage(movingPlatform);
    }

    public float getxPos() {
        xPos = getPosition().x;
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public Shape getShape () {return movingPlatformShape;}


}
