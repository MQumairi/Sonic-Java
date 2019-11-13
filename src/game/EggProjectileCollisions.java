package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

/** EggProjectileCollisions - Handles what happens when Sonic collides with one of Eggman's beams or bombs*/

public class EggProjectileCollisions implements SensorListener {
    private Eggbeam beam;
    private Eggbomb bomb;
    private Sonic sonic;

    public EggProjectileCollisions(Eggbeam beam, Eggbomb bomb, Sonic sonic) {
        this.beam = beam;
        this.bomb = bomb;
        this.sonic = sonic;
    }

    @Override
    public void beginContact(SensorEvent e) {
        e.getContactBody(); //Sonic
        e.getSensor(); //the Beam or Bomb


        //Collisions with Beam

        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(beam.getBeamSensor()) && sonic.getRingCount() > 0 && beam.isHarmful()) {
            sonic.deccrementRingCount();
            sonic.setTakeDamageCount(1);
        }

        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(beam.getBeamSensor()) && sonic.getRingCount() == 0 && beam.isHarmful()) {
            sonic.setCheckDead(true);
        }

        //Collisions with Bomb
        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(bomb.getBombsensor()) && sonic.getRingCount() > 0 && bomb.isHarmful()) {
            sonic.deccrementRingCount();
            sonic.setTakeDamageCount(1);
        }

        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(bomb.getBombsensor()) && sonic.getRingCount() == 0 && bomb.isHarmful()) {
            sonic.setCheckDead(true);
        }

    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
