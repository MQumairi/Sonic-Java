package game;

import city.cs.engine.*;


/*** MetalTriggerCollision- Handles the trigger for the falling ceiling from Level4. When Sonic connects with the trigger
 * set isTriggered to true, which should cause the ceiling to start falling*/


public class MetalTriggerCollision implements CollisionListener {
    private Sonic sonic;
    private boolean isTriggered;

    public MetalTriggerCollision(Sonic sonic) {
        this.sonic = sonic;
    }

    @Override
    public void collide(CollisionEvent e) {
        e.getReportingBody(); //the trigger
        e.getOtherBody(); //Sonic


        //If Sonic collides with the trigger, set the startmoving for the ceiling to true.

            if (e.getOtherBody() instanceof Sonic) {
                isTriggered = true;
            } else {
                isTriggered = false;
            }
        }

    public boolean getIsTriggered() {
        return  isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }
}