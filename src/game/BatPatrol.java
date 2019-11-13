package game;

import city.cs.engine.*;

/** Batnik - the Robot bat from level 1*/

public class BatPatrol implements StepListener {

    private Batnik batnik;

    public BatPatrol(Batnik batnik) {
        this.batnik = batnik;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if (batnik.getxPos() > batnik.getStartXPos()+6) {
            batnik.setPatrolDirection(-1);
            batnik.makeMoveLeft();
        }

        if (batnik.getxPos() < batnik.getStartXPos()-6) {
            batnik.setPatrolDirection(1);
            batnik.makeMoveRight();
        }

        batnik.getxPos();
        batnik.startWalking(3 * batnik.getPatrolDirection());

    }

}