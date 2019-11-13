package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_RING = 0;
//    private SoundClip IceCapMusic;


    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

//        try {
//            IceCapMusic = new SoundClip("data/Sounds/IceCap.wav");   // Open an audio input stream
//            IceCapMusic.loop();  // Set it to continous playback (looping)
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            System.out.println(e);
//        }

        //Invisible wall

        invisibleWall(-3, 5);

        //FIRST BLOCK

        //Platform
        smoothTop(21, 19, 2.01f);

        for(int i=0; i<20; i++) {
            platformTop(i*2, 0);
        }

        for(int i=0; i<20; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(i * 2, y* -4);
            }
        }

        //Rings
        for (int i = 0; i < 5; i++) {
            ring(5+(i*2), 5);
        }

        //PENGUIN
        penguin(24,2);



        //SECOND BLOCK

        //Platform
        IcesmoothTop(21, 49, -7.99f);

        for(int i=0; i<15; i++) {
            platformIceTop(40+(i*2), -10);
        }

        for(int i=0; i<15; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(40+ (i*2), (y* -4) - 14);
            }
        }

        //Rings
        for (int i = 0; i < 5; i++) {
            ring(45+(i*2), -5);
        }



        //THIRD BLOCK

        //Platform

        for(int i=0; i<6; i++) {
            platformTop(70+(i*2), -18);
        }

        for(int i=0; i<6; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(70+ (i*2), (y* -4) - 22);
            }
        }

        //Spikes

        for(int i=0; i<6; i++) {
            spikes(70+(i*2), -16);
        }



        //FOURTH BLOCK

        //Platform
        smoothTop(11, 93, -7.99f);


        for(int i=0; i<10; i++) {
            platformTop(84+(i*2), -10);
        }

        for(int i=0; i<10; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(84+ (i*2), (y* -4) - 14);
            }
        }

        //PENGUIN
        penguin(90,-8);



        //FIFTH BLOCK

        //Platform
        smoothTop(60, 113, -17.99f);

        for(int i=0; i<35; i++) {
            platformTop(104+(i*2), -20);
        }

        for(int i=0; i<35; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(104+ (i*2), (y* -4) - 24);
            }
        }

        //Rings
        for (int i = 0; i < 4; i++) {
            ring(108+(i*2), -15);
        }

        //Cave Top

        for(int i=0; i<30; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(124+ (i*2), (y* -4) + 5);
            }
        }

        //Ice Pillar

        icePillar(130, -10, 1);

        icePillar(145, -10, 2);

        icePillar(160, -10, 1.5f);



        //SIXTH BLOCK

        //Platform
        for(int i=0; i<15; i++) {
            platformTop(174+(i*2), -40);
        }

        for(int i=0; i<15; i++) {
            for(int y=0; y<3; y++) {
                platformBottom(174+ (i*2), (y* -4) - 44);
            }
        }

        //Spikes
        for(int i=0; i<15; i++) {
            spikes(174+(i*2), -38);
        }

        //GreenHillSmallPlatform
        movingPlatform(182, -20);

        movingPlatform(194, -20);



        //SEVENTH BLOCK

        //Platform

        smoothTop(16, 218, -17.99f);

        for(int i=0; i<15; i++) {
            platformTop(204+(i*2), -20);
        }

        for(int i=0; i<15; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(204+ (i*2), (y* -4) - 24);
            }
        }



        //EIGHTH BLOCK

        //Platform
        smoothTop(6, 238, -13.99f);

        for(int i=0; i<5; i++) {
            platformTop(234+(i*2), -16);
        }

        for(int i=0; i<5; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(234+ (i*2), (y* -4) - 20);
            }
        }

        //Spring
        spring(240, -13.20f);




        //NINTH BLOCK

        //Platform
        smoothTop(11, 253, 7.01f);

        for(int i=0; i<10; i++) {
            platformTop(244+(i*2), 5);
        }

        for(int i=0; i<10; i++) {
            for(int y=0; y<7; y++) {
                platformBottom(244+ (i*2), (y* -4) + 1);
            }
        }


        //CAVE BACKDROP
        for(int i=0; i< 150; i++) {
            for (int y = 0; y < 30; y++) {
                caveBackground(124+ (i*2), (y* -4) + 5);
            }
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

    public void IcesmoothTop(float width, float xPos, float yPos) {
        Shape smoothIceTopShape = new BoxShape(width, 0.01f);
        Body smoothIceTop = new StaticBody(this, smoothIceTopShape);
        smoothIceTop.setPosition(new Vec2(xPos, yPos));
        smoothIceTop.setFillColor(Color.black);
        SolidFixture smoothTopFixture = new SolidFixture(smoothIceTop, smoothIceTopShape);
        smoothTopFixture.setFriction(0.1f);
        //0.02
    }

    public void platformTop(float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/IceCap/SnowTopPlat.png", 4));
        SolidFixture platFormTopFixture = new SolidFixture(platformTop, platformTopShape);
        platFormTopFixture.setFriction(20);
    }

    public void platformIceTop(float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/IceCap/IcePlat.png", 4));
        SolidFixture platFormTopFixture = new SolidFixture(platformTop, platformTopShape);
        platFormTopFixture.setFriction(10);
    }

    public void platformBottom (float xPos, float yPos) {
        Shape platformTopShape = new BoxShape(2, 2);
        Body platformTop = new StaticBody(this, platformTopShape);
        platformTop.setPosition(new Vec2(xPos, yPos));
        platformTop.addImage(new BodyImage("data/IceCap/SnowBotPlat.png", 4));
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

    public void penguin (float xPos, float yPos) {
        Penguin penguin = new Penguin(this);
        penguin.setPosition(new Vec2(xPos, yPos));
        penguin.setStartXPos(xPos);
        penguin.addCollisionListener(new DefeatBadnick(getPlayer()));
        PenguinPatrol ppatrol = new PenguinPatrol(penguin);
        this.addStepListener(ppatrol);
    }

    public void caveBackground (float xPos, float yPos) {
        Shape caveBackgroundShape = new BoxShape(2, 2);
        Body caveBackground = new StaticBody(this, caveBackgroundShape);
        caveBackground.setPosition(new Vec2(xPos, yPos));
        caveBackground.addImage(new BodyImage("data/IceCap/SnowCaveBG.png", 4));
        caveBackground.getFixtureList().get(0).destroy();
        GhostlyFixture caveBGfixture = new GhostlyFixture(caveBackground, caveBackgroundShape);
        caveBGfixture.setDensity(0);

    }

    public void movingPlatform (float xPos, float yPos) {
        Shape movingPlatformShape = new BoxShape(2, 0.75f);
        Body movingPlatform = new StaticBody(this, movingPlatformShape);
        movingPlatform.setPosition(new Vec2(xPos, yPos));
        movingPlatform.addImage(new BodyImage("data/IceCap/SnowMovingPlatform.png", 1.5f));
        SolidFixture platFormTopFixture = new SolidFixture(movingPlatform, movingPlatformShape);
        platFormTopFixture.setFriction(20);
    }


    public void icePillar (float xPos, float yPos, float speedMultiplier) {
        IcePillar icePillar = new IcePillar(this);
        icePillar.setPosition(new Vec2(xPos, yPos));
        icePillar.setStartyPos(yPos);
        IcePillarMotion icePillarMotion = new IcePillarMotion(icePillar);
        icePillarMotion.setSpeedMultiplier(speedMultiplier);
        this.addStepListener(icePillarMotion);
        icePillar.getIcePillarSensor().addSensorListener(new IcePillarCollision(icePillar, getPlayer()));
    }

    public void invisibleWall (float xPos, float yPos) {
        Color c = new Color(1f, 0f, 0f, 0f);
        Shape invisibleWallShape = new BoxShape(1, 7);
        Body invisibleWall = new StaticBody(this, invisibleWallShape);
        invisibleWall.setFillColor(c);
        invisibleWall.setLineColor(c);
        invisibleWall.setPosition(new Vec2(xPos, yPos));
    }

    public int getLevelNumber () {
        return 2;
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, 6);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(250, 8.5f);
    }

    @Override
    public String setLevelMusic() {
        return "data/Sounds/IceCap.wav";
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getRingCount() >= NUM_RING;
    }

}