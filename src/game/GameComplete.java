package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/** GameComplete - the text that appears after final boss is defeated*/


public class GameComplete extends StaticBody {


    private static final Shape gcShape = new BoxShape(4, 8);


    private static final BodyImage gc =
            new BodyImage("data/Icons/gameComplete.png", 8);

    private Sensor gcSensor;


    public GameComplete(World world) {
        super (world, gcShape);
        addImage(gc);
        getFixtureList().get(0).destroy();
        gcSensor = new Sensor(this, gcShape);
        gcSensor.setDensity(0);
    }

}
