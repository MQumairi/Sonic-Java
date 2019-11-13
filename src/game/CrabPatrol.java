package game;

import city.cs.engine.*;

/** Crabmeat's Steplistner - Handles crabmeats left to right motion*/

public class CrabPatrol implements StepListener {

    private Crabmeat crabmeat;

    public CrabPatrol(Crabmeat crabmeat) {
        this.crabmeat = crabmeat;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if (crabmeat.getxPos() > crabmeat.getStartXPos()+8) {
            crabmeat.setPatrolDirection(-1);
        }

        if (crabmeat.getxPos() < crabmeat.getStartXPos()-8) {
            crabmeat.setPatrolDirection(1);
        }

        crabmeat.getxPos();
        crabmeat.startWalking(3 * crabmeat.getPatrolDirection());

        //System.out.println("Patrol Speed = " + crabmeat.getPatrolSpeed());
        //System.out.println("X Postion = " + crabmeat.getxPos() + " and Patrol direction = " + crabmeat.getPatrolDirection());

    }

    public void setCrabmeat(Crabmeat crabmeat) {
        this.crabmeat = crabmeat;
    }


}