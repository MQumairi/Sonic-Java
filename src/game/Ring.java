package game;

import city.cs.engine.*;

/*** Ring- the Rings*/

public class Ring extends DynamicBody {

    private static final float radius = 0.7f;
    private static final Shape ringShape = new CircleShape(radius);
    private static final BodyImage ringImage =
            new BodyImage("data/LevelObjects/ring.gif", 2*radius);
    private Sensor ringSensor;

    public Ring(World world) {
        super(world, ringShape);
        addImage(ringImage);
        setGravityScale(0);
        getFixtureList().get(0).destroy();
        ringSensor = new Sensor(this, ringShape);
        ringSensor.setDensity(0);
    }

    public Shape getRingShape() {
        return ringShape;
    }

    public Sensor getRingSensor() {return ringSensor;}

    public void destroyRing() {
        this.destroy();
    }
}
