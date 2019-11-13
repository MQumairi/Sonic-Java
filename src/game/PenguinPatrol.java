package game;

import city.cs.engine.*;

/*** PenguinPatrol- Hanldes the Penguin's oscillating motion, from left to right*/

public class PenguinPatrol implements StepListener {

    private Penguin penguin;

    public PenguinPatrol(Penguin penguin) {
        this.penguin = penguin;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if (penguin.getxPos() > penguin.getStartXPos()+6) {
            penguin.setPatrolDirection(-1);
            penguin.makeMoveLeft();
        }

        if (penguin.getxPos() < penguin.getStartXPos()-6) {
            penguin.setPatrolDirection(1);
            penguin.makeMoveRight();
        }

        penguin.getxPos();
        penguin.startWalking(3 * penguin.getPatrolDirection());

    }

}