package game;

import city.cs.engine.*;


/** IcePillarCollision - Handles Sonic's collision with the IecPillar from Level2*/

public class IcePillarCollision implements SensorListener {
    private IcePillar icePillar;
    private Sonic sonic;

    public IcePillarCollision(IcePillar icePillar, Sonic sonic) {
        this.icePillar = icePillar;
        this.sonic = sonic;
    }

    @Override
    public void beginContact(SensorEvent e) {
        e.getContactBody(); //Sonic
        e.getSensor(); //Pillar

        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(icePillar.getIcePillarSensor()) && sonic.getRingCount() > 0) {
            sonic.deccrementRingCount();
            sonic.setTakeDamageCount(1);
        }

        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(icePillar.getIcePillarSensor()) && sonic.getRingCount() == 0) {
            sonic.setCheckDead(true);
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
