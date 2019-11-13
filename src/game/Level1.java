package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/*** Level 1 of the game*/

public class Level1 extends GameLevel {

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
        smoothTop(31, 29, 2.01f);

        for(int i=0; i<30; i++) {
            platformTop(i*2, 0);
        }

        for(int i=0; i<30; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(i * 2, y* -4);
            }
        }

        //Rings
        for (int i = 0; i < 5; i++) {
            ring((i*2)+8, 5);
        }

        //Enemy
        crabmeat(27, 2);

        //Spring
        spring(57, 2.8f);

        //SECOND BLOCK

        smoothTop(3, 63, 22.01f);

        for (int i=0; i<2; i++) {
            platformTop(62+(i*2), 20);
        }

        for(int i=0; i<2; i++) {
            for(int y=0; y<8; y++) {
                platformBottom(62 + (i * 2), 16 + (y* -4));
            }
        }

        //THIRD BLOCK

        //Platform

        for(int i=0; i<20; i++) {
            platformTop(66+(i*2), 0);
        }

        for(int i=0; i<20; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(66+(i * 2), y* -4);
            }
        }

        //Spikes
        for(int i=0; i<20; i++) {
            spikes(66+(i*2), 2);
        }

        //Moving Platform
        movingPlatform(71, 18);
        movingPlatform(85, 13);
        movingPlatform(95, 17);

        //Batnick
        batnick(73, 26);
        batnick(83, 16);


        //FOURTH BLOCK

        //Platform

        smoothTop(4, 110, 19.01f);

        for(int i=0; i<3; i++) {
            platformTop(108+(i*2), 17);
        }

        for(int i=0; i<3; i++) {
            for(int y=0; y<8; y++) {
                platformBottom(108+(i * 2), 13 + (y* -4));
            }
        }

        //Spring
        spring(112.5f, 19.8f);



        //FIFTH BLOCK

        smoothTop(6, 120, 35.01f);

        for(int i=0; i<5; i++) {
            platformTop(116+(i*2), 33);
        }

        for(int i=0; i<5; i++) {
            for(int y=0; y<10; y++) {
                platformBottom(116+(i * 2), 29 + (y* -4));
            }
        }

        //Rings
        for (int i = 0; i < 4; i++) {
            ring((i*2)+117, 40);
        }


        //SIXTH BLOCK

        //Platform

        for(int i=0; i<4; i++) {
            platformTop(128+(i*2), 28);
        }

        for(int i=0; i<4; i++) {
            for(int y=0; y<10; y++) {
                platformBottom(128+(i * 2), 24 + (y* -4));
            }
        }

        //Spikes
        for(int i=0; i<4; i++) {
            spikes(128+(i*2), 30);
        }


        //Batnik
        batnick(130, 40);



        //SEVENTH BLOCK

        //Platform
        smoothTop(6, 142, 35.01f);

        for(int i=0; i<5; i++) {
            platformTop(138+(i*2), 33);
        }

        for(int i=0; i<5; i++) {
            for(int y=0; y<10; y++) {
                platformBottom(138+(i * 2), 29 + (y* -4));
            }
        }


        //EIGHTH BLOCK

        //Platform
        smoothTop(50, 198, 29.01f);

        for(int i=0; i<50; i++) {
            platformTop(148 +(i*2), 27);
        }

        for(int i=0; i<50; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(148 +(i*2), 23 + (y* -4));
            }
        }

        //Ring

        for (int i = 0; i < 5; i++) {
            ring((i*2)+152, 32);
        }

        for (int i = 0; i < 5; i++) {
            ring((i*2)+190, 32);
        }

        //Crabmeat
        crabmeat(173, 29);


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
        platformTop.addImage(new BodyImage("data/GreenHill/GreenTopPlat.png", 4));
        SolidFixture platFormTopFixture = new SolidFixture(platformTop, platformTopShape);
        platFormTopFixture.setFriction(20);
    }

    public void platformBottom (float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/GreenHill/GreenBotPlat1.png", 4));
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

    public void crabmeat (float xPos, float yPos) {
        Crabmeat crabmeat = new Crabmeat(this);
        crabmeat.setPosition(new Vec2(xPos, yPos));
        crabmeat.setStartXPos(xPos);
        crabmeat.addCollisionListener(new DefeatBadnick(getPlayer()));
        CrabPatrol cpatrol = new CrabPatrol(crabmeat);
        this.addStepListener(cpatrol);
    }

    public void batnick (float xPos, float yPos) {
        Batnik batnik = new Batnik(this);
        batnik.setPosition(new Vec2(xPos, yPos));
        batnik.setStartXPos(xPos);
        batnik.addCollisionListener(new DefeatBadnick(getPlayer()));
        BatPatrol bpatrol = new BatPatrol(batnik);
        this.addStepListener(bpatrol);
    }

    public void movingPlatform (float xPos, float yPos) {
        GreenHillSmallPlatform greenHillSmallPlatform = new GreenHillSmallPlatform(this);
        greenHillSmallPlatform.setPosition(new Vec2(xPos, yPos));
        SolidFixture movingPlatformFixture = new SolidFixture(greenHillSmallPlatform, greenHillSmallPlatform.getShape());
        movingPlatformFixture.setFriction(20);
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
        return new Vec2(220, 30.5f);
    }

    @Override
    public String setLevelMusic() {
        return "data/Sounds/GreenHill.wav";
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getRingCount() >= NUM_RING;
    }

}
