package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_RING = 0;

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

        for(int i=0; i<5; i++) {
            platformTop(i*4, 0);
        }

        for(int i=0; i<5; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(i *4, y* -4);
            }
        }

        //Rings
        for (int i = 0; i < 5; i++) {
            ring((i*2)+6, 5);
        }


        //SECOND BLOCK

        //Platform

        for(int i=0; i<5; i++) {
            platformTop(20+(i*4), -10);
        }

        for(int i=0; i<5; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(20+(i *4), (y* -4) -14);
            }
        }

        //Moving Platform

        hoverPlatform(21, 0, 35, false);


        //Spikes
        for(int i=0; i<10; i++) {
            spikes(20+(i*2), -8);
        }


        //THIRD BLOCK

        for(int i=0; i<10; i++) {
            platformTop(40+(i*4), 0);
        }

        for(int i=0; i<10; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(40 + (i *4), y* -4);
            }
        }


        //FOURTH BLOCK

        //Platform

        for(int i=0; i<2; i++) {
            platformTop(80+(i*4), -10);
        }

        for(int i=0; i<2; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(80+(i *4), (y* -4) -14);
            }
        }

        //Spikes

        for(int i=0; i<3; i++) {
            spikes(80+(i*2), -8);
        }

        //Hover Platform
        hoverPlatform(81, -1, 20, true);


        //FIFTH BLOCK

        //Platform

        for(int i=0; i<2; i++) {
            platformTop(88+(i*4), 20);
        }

        for(int i=0; i<2; i++) {
            for(int y=0; y<10; y++) {
                platformBottom(88+(i *4), (y* -4) + 16);
            }
        }

        //Spring
        spring(92, 22.8f);


        //SIXTH BLOCK

        for(int i=0; i<3; i++) {
            platformTop(96+(i*4), 40);
        }

        for(int i=0; i<3; i++) {
            for(int y=0; y<10; y++) {
                platformBottom(96+(i *4), (y* -4) + 36);
            }
        }

        //Spring
        spring(103.5f, 42.8f);



        //SEVENTH BLOCK

        for(int i=0; i<2; i++) {
            platformTop(108+(i*4), 65);
        }

        for(int i=0; i<2; i++) {
            for(int y=0; y<10; y++) {
                platformBottom(108+(i *4), (y* -4) + 61);
            }
        }


        //EIGHTH BLOCK

        //Right Platform
        for(int i=0; i<8; i++) {
            platformTop(58+(i*4), 40);
        }


        //Left Platform
        for(int i=0; i<8; i++) {
            platformTop(-10 +(i*4), 40);
        }

        //Hover Platform
        hoverPlatform(23, 40, 55, false);

        hoverPlatform(-14, 40, 65, true);

        //Rings




        //NINTH BLOCK

        //Bridge
        for(int i=0; i<20; i++) {
            bridge(20+(i*4), 65);
        }


        //Platform
        for(int i=0; i<6; i++) {
            platformTop(-10 +(i*4), 65);
        }


        //Rings
        for (int i = 0; i < 30; i++) {
            ring((i*2)+30, 70);
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
        platformTop.addImage(new BodyImage("data/LaunchBase/BaseTopPlat1.png", 4));
        SolidFixture platFormTopFixture = new SolidFixture(platformTop, platformTopShape);
        platFormTopFixture.setFriction(20);
    }

    public void bridge(float xPos, float yPos) {
        Bridge bridge = new Bridge(this);
        bridge.setPosition(new Vec2(xPos, yPos));
        SolidFixture platFormTopFixture = new SolidFixture(bridge, bridge.getShape());
        platFormTopFixture.setFriction(20);


////        //Timer
//        BridgeFall tc = new BridgeFall();
//        Timer t = new Timer(2000, tc);
//        t.setInitialDelay(5000);
//        t.start();
    }



    public void platformBottom (float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/LaunchBase/BaseBotPlat.png", 4));
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


    public void hoverPlatform (float xPos, float yPos, float endPos, boolean isVertical) {
        HoverPlatform hoverPlatform = new HoverPlatform(this);
        hoverPlatform.setPosition(new Vec2(xPos, yPos));
        hoverPlatform.setStartXPos(xPos);
        SolidFixture movingPlatformFixture = new SolidFixture(hoverPlatform, hoverPlatform.getShape());
        movingPlatformFixture.setFriction(20);

        if(isVertical) {
            HoverPlatformMotion hoverPlatformMotion = new HoverPlatformMotion(hoverPlatform, yPos, endPos, isVertical);
            this.addStepListener(hoverPlatformMotion);

        } else {

            HoverPlatformMotion hoverPlatformMotion = new HoverPlatformMotion(hoverPlatform, xPos, endPos, isVertical);
            this.addStepListener(hoverPlatformMotion);
        }
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

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-5, 68.5f);
    }

    @Override
    public String setLevelMusic() {
        return "data/Sounds/LaunchBase.wav";
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getRingCount() >= NUM_RING;
    }

}
