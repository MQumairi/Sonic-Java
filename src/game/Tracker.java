package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Sonic sonic;

    private Game game;


    public Tracker(WorldView view, Sonic sonic, Game game) {
        this.view = view;
        this.sonic = sonic;
        this.game = game;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if(game.getLevelNumber() != 5) {

            view.setCentre(new Vec2(sonic.getPosition()));
        } else {
            view.setCentre(new Vec2(0, 10));

        }
    }

}