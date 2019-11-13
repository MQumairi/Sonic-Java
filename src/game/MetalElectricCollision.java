package game;

import city.cs.engine.*;



/*** MetalElectricCollision- Handles Sonic's collision with MetalEelectric. If the generator is switched on, sonic takes damage on collision.
 * Else, Sonic can pass through normally*/

public class MetalElectricCollision implements SensorListener {
    private MetalElectric metalElectric;
    private Sonic sonic;

    public MetalElectricCollision(MetalElectric metalElectric, Sonic sonic) {
        this.metalElectric = metalElectric;
        this.sonic = sonic;
    }

    @Override
    public void beginContact(SensorEvent e) {
        e.getContactBody(); //Sonic
        e.getSensor(); //Electricity

        if(metalElectric.getSwitchOn()) {

            if (e.getContactBody() instanceof Sonic && e.getSensor().equals(metalElectric.getElectricSensor()) && sonic.getRingCount() > 0) {
                sonic.deccrementRingCount();
                sonic.setTakeDamageCount(1);
            }

            if (e.getContactBody() instanceof Sonic && e.getSensor().equals(metalElectric.getElectricSensor()) && sonic.getRingCount() == 0) {
                sonic.setCheckDead(true);
            }
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
