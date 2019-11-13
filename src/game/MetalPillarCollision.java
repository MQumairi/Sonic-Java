package game;

import city.cs.engine.*;


/*** MetalPillarCollision- Hanldes Sonic's collision with the falling ceiling from level4. If it hits Sonic, sonic instantly dies*/

public class MetalPillarCollision implements SensorListener {
    private MetalPillar metalPillar;
    private Sonic sonic;

    public MetalPillarCollision(MetalPillar metalPillar, Sonic sonic) {
        this.metalPillar = metalPillar;
        this.sonic = sonic;
    }

    @Override
    public void beginContact(SensorEvent e) {
        e.getContactBody(); //Sonic
        e.getSensor(); //Pillar

        if (e.getContactBody() instanceof Sonic && e.getSensor().equals(metalPillar.getmetalPillarSensor())) {
            sonic.setCheckDead(true);
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
