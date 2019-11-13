package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    private static final int NUM_RING = 0;
    private MetalTriggerCollision triggerCollision = new MetalTriggerCollision(getPlayer());

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Invisible wall

        invisibleWall(-3, 5);


        //FIRST BLOCK

        //Platform
        smoothTop(10, 8, 2.01f);

        for (int i = 0; i < 5; i++) {
            platformTop(i * 4, 0);
        }

        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 7; y++) {
                platformBottom(i * 4, y * -4);
            }
        }

        //Rings
        for (int i = 0; i < 5; i++) {
            ring((i * 2) + 6, 5);
        }


        //SECOND BLOCK

        //Platform

        for (int i = 0; i < 2; i++) {
            platformTop(20 + (i * 4), -10);
        }

        for (int i = 0; i < 2; i++) {
            for (int y = 0; y < 3; y++) {
                platformBottom(20 + (i * 4), (y * -4) - 14);
            }
        }

        //Spikes
        for (int i = 0; i < 3; i++) {
            spikes(20 + (i * 2), -8);
        }


        //THIRD BLOCK

        //Platform

        for (int i = 0; i < 10; i++) {
            platformTop(28 + (i * 4), 0);
        }

        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 3; y++) {
                platformBottom(28 + (i * 4), y * -4);
            }
        }

        //Enemey

        //Spring
        spring(64.5f, 2.5f);


        //FOURTH BLOCK

        //Platform

        for (int i = 0; i < 2; i++) {
            for (int y = 0; y < 14; y++) {
                platformBottom(68 + (i * 4), (y * -4) + 34);
            }
        }


        //FIFTH BLOCK

        //Platform

        for (int i = 0; i < 20; i++) {
            trigger(-20 + (i * 4), 20);
        }


        //Spring

        platformTop(-18, 25);
        spring(-17.5f, 27.5f);


        //SIXTH BLOCK

        //Platform

        for (int i = 0; i < 2; i++) {
            for (int y = 0; y < 17; y++) {
                platformBottom(-28 + (i * 4), (y * -4) + 65);
            }
        }


        //SEVENTH BLOCK

        //Platform

        for (int i = 0; i < 30; i++) {
            platformTop(-10 + (i * 4), 50);
        }

        for (int i = 0; i < 30; i++) {
            for (int y = 0; y < 3; y++) {
                platformBottom(-10 + (i * 4), (y * -4) + 46);
            }
        }

        //Electricity
        generator(10, 63.8f);
        electric(10, 58, 0);

        generator(35, 63.8f);
        electric(35, 58, 50);

        generator(60, 63.8f);
        electric(60, 58, 160);





        //Enemy

        //Rings

        //Roof

        for (int i = 0; i < 38; i++) {
            platformBottom(-28 + (i*4), + 67);
        }

        //Falling Ceiling

        for (int i = 0; i < 12; i++) {
            metalPillar(-5 + (i*5.2f), 42);
        }

        //EIGHTH BLOCK

        //Platform

        for (int i = 0; i < 2; i++) {
            platformTop(110 + (i * 4), 40);
        }

        for (int i = 0; i < 2; i++) {
            for (int y = 0; y < 3; y++) {
                platformBottom(110 + (i * 4), (y * -4) + 36);
            }
        }

        //Spikes
        for (int i = 0; i < 3; i++) {
            spikes(110 + (i * 2), 42);
        }


        //NINTH BLOCK

        //Platform

        for (int i = 0; i < 2; i++) {
            platformTop(118 + (i * 4), 50);
        }

        for (int i = 0; i < 2; i++) {
            for (int y = 0; y < 20; y++) {
                platformBottom(118 + (i * 4), (y * -4) + 46);
            }
        }

        //Moving Platform

        metalHoverPlatform(129, 70, -10);


        //TENTH BLOCK

        //Platform

        for (int i = 0; i < 9; i++) {
            platformTop(126 + (i * 4), -10);
        }

        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 2; y++) {
                platformBottom(126 + (i * 4), (y * -4) -14);
            }
        }

        //Rings

        //Enemey



        //ELEVENTH BLOCK

        //Platform

        for (int i = 0; i < 6; i++) {
            platformTop(138 + (i * 4), 70);
        }

        for (int i = 0; i < 6; i++) {
            for (int y = 0; y < 15; y++) {
                platformBottom(138 + (i * 4), (y * -4) + 66);
            }
        }


        //TWELFTH BLOCK

        for (int y =0; y < 5; y++) {
            platformBottom(120, (y * -4) + 86);
        }

        //THIRTEENTH BLOCK

        for (int i = 0; i < 10; i ++) {
            platformBottom(120 + (i*4), 90);
        }



    }

    /** METHODS **/

    public void smoothTop(float width, float xPos, float yPos) {
        Shape smoothTopShape = new BoxShape(width, 0.01f);
        Body smoothTop = new StaticBody(this, smoothTopShape);
        smoothTop.setPosition(new Vec2(xPos, yPos));
        smoothTop.setFillColor(Color.black);
        SolidFixture smoothTopFixture = new SolidFixture(smoothTop, smoothTopShape);
        smoothTopFixture.setFriction(20);
    }

    public void platformTop(float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/MetalMadness/MetalTopPlat.png", 4));
        SolidFixture platFormTopFixture = new SolidFixture(platformTop, platformTopShape);
        platFormTopFixture.setFriction(20);
    }

    public void trigger(float xPos, float yPos) {
        Shape triggerShape = new BoxShape(2, 2);
        Body trigger = new StaticBody(this, triggerShape);
        trigger.setPosition(new Vec2(xPos, yPos));
        trigger.addImage(new BodyImage("data/MetalMadness/MetalTopPlat.png", 4));
        trigger.addCollisionListener(triggerCollision);
        SolidFixture triggerFixture = new SolidFixture(trigger, triggerShape);
        triggerFixture.setFriction(20);

    }

    public void platformBottom (float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/MetalMadness/MetalBotPlat.png", 4));
        SolidFixture platFormTopFixture = new SolidFixture(platformTop, platformTopShape);
        platFormTopFixture.setFriction(20);
    }

    public void ring (float xPos, float yPos) {
        Ring ring = new Ring(this);
        ring.setPosition(new Vec2(xPos, yPos));
        ring.getRingSensor().addSensorListener(new RingCollecting(ring, getPlayer()));
    }

    public void spring (float xPos, float yPos) {
        Body spring = new Spring(this);
        spring.setPosition(new Vec2(xPos, yPos));
        spring.addCollisionListener(new SpringListner(getPlayer()));
    }

    public void spikes (float xPos, float yPos) {
        Body spikes = new Spikes(this);
        spikes.setPosition(new Vec2(xPos, yPos));
        spikes.addCollisionListener(new SpikeCollision(getPlayer()));
    }


    public void metalPillar (float xPos, float yPos) {
        MetalPillar metalPillar = new MetalPillar(this);
        metalPillar.setPosition(new Vec2(xPos, yPos));
        metalPillar.setStartyPos(yPos);
        MetalPillarMotion metalPillarMotion = new MetalPillarMotion(metalPillar, triggerCollision, getPlayer());
        this.addStepListener(metalPillarMotion);
        metalPillar.getmetalPillarSensor().addSensorListener(new MetalPillarCollision(metalPillar, getPlayer()));
    }


    public void metalHoverPlatform (float xPos, float yPos, float endPos) {
        MetalHoverPlatform metalHoverPlatform = new MetalHoverPlatform(this);
        metalHoverPlatform.setPosition(new Vec2(xPos, yPos));
        metalHoverPlatform.setStartXPos(xPos);
        SolidFixture movingPlatformFixture = new SolidFixture(metalHoverPlatform, metalHoverPlatform.getShape());
        movingPlatformFixture.setFriction(20);
        MetalHoverPlatformMotion metalHoverPlatformMotion = new MetalHoverPlatformMotion(metalHoverPlatform, yPos, endPos);
        this.addStepListener(metalHoverPlatformMotion);
    }

    public void electric(float xPos, float yPos, int timer) {
        MetalElectric metalElectric = new MetalElectric(this);
        metalElectric.setPosition(new Vec2(xPos, yPos));
        MetalElectricListner metalElectricListner = new MetalElectricListner(metalElectric);
        metalElectric.setTimer(timer);
        this.addStepListener(metalElectricListner);
        metalElectric.getElectricSensor().addSensorListener(new MetalElectricCollision(metalElectric, getPlayer()));
    }

    public void generator(float xPos, float yPos) {
        Shape generatorShape = new BoxShape(1.2f, 1.2f);
        Body generator = new StaticBody(this, generatorShape);
        generator.setPosition(new Vec2(xPos, yPos));
        generator.addImage(new BodyImage("data/MetalMadness/EGeneratorW.png", 2.4f));
    }

    public void invisibleWall (float xPos, float yPos) {
        Color c = new Color(1f, 0f, 0f, 0f);
        Shape invisibleWallShape = new BoxShape(1, 7);
        Body invisibleWall = new StaticBody(this, invisibleWallShape);
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
