package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 5 of the game - Final Boss
 */
public class Level5 extends GameLevel {

    private static final int NUM_RING = 0;
    private Eggbeam beam = new Eggbeam(this);
    private Eggbomb bomb = new Eggbomb(this);

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        getPlayer().setRingcount(3);

        //Invisible wall

        invisibleWall(-13, 10);
        invisibleWall(13, 10);



        //FIRST BLOCK

        //Platform
        smoothTop(20, 0, 2.01f);

//        platformTop(0, 0);

        for (int i = -10; i < 20; i++) {
            platformTop(i * 4, 0);
        }

        //EGGMAN

        eggbeam(9, 6);
        eggbomb(0, 6);
        eggman(9, 30);

    }

    /** METHODS **/

    public void eggbeam(float xPos, float yPos) {
        beam.setPosition(new Vec2 (xPos, yPos));
    }

    public void eggbomb(float xPos, float yPos) {
        bomb.setPosition(new Vec2 (xPos, yPos));
    }

    public void eggman(float xPos, float yPos) {
        Eggman eggman = new Eggman(this);
        eggman.setPosition(new Vec2 (xPos, yPos));
        EggListner eggListner = new EggListner(eggman, beam, bomb, getPlayer());
        this.addStepListener(eggListner);
        eggman.setStartPos(new Vec2(xPos, yPos));

        //Projectile Collision
        EggProjectileCollisions projectileCollisions = new EggProjectileCollisions(beam,bomb ,getPlayer());
        beam.getBeamSensor().addSensorListener(projectileCollisions);
        bomb.getBombsensor().addSensorListener(projectileCollisions);


        //Eggman Collision
        EggmanCollision eggCollision = new EggmanCollision(eggman, getPlayer());
        eggman.addCollisionListener(eggCollision);
    }

    public void smoothTop(float width, float xPos, float yPos) {
        Shape smoothTopShape = new BoxShape(width, 0.01f);
        Body smoothTop = new StaticBody(this, smoothTopShape);
        smoothTop.setPosition(new Vec2(xPos, yPos));
        smoothTop.setFillColor(Color.black);
        SolidFixture smoothTopFixture = new SolidFixture(smoothTop, smoothTopShape);
        smoothTopFixture.setFriction(20);
    }

    public void platformTop(float xPos, float yPos) {
        Level5Floor floor = new Level5Floor(this);
        floor.setPosition(new Vec2 (xPos, yPos));
        Level5ScrollFloor floormover = new Level5ScrollFloor(floor);
        this.addStepListener(floormover);

    }


    public void invisibleWall (float xPos, float yPos) {
        Color c = new Color(1f, 0f, 0f, 0f);
        Shape invisibleWallShape = new BoxShape(1, 7);
        Body invisibleWall = new StaticBody(this, invisibleWallShape);
        SolidFixture smoothTopFixture = new SolidFixture(invisibleWall, invisibleWallShape);
        smoothTopFixture.setFriction(0);
        invisibleWall.setFillColor(c);
        invisibleWall.setLineColor(c);
        invisibleWall.setPosition(new Vec2(xPos, yPos));
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, 6);
    }

    //106, 56

    @Override
    public Vec2 doorPosition() {
        return new Vec2(148, 73.5f);
    }

    @Override
    public String setLevelMusic() {
        return "data/Sounds/MetalMadness.wav";
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getRingCount() >= NUM_RING;
    }

}
