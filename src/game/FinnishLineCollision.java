package game;

import city.cs.engine.*;

/** FinnishLineCollision - Hanldes Sonic's collision with the Finnish Line*/

public class FinnishLineCollision implements CollisionListener {
    private Game game;
    private FinishLine finishLine;

    public FinnishLineCollision(Game game, FinishLine finishLine) {
        this.game = game;
        this.finishLine = finishLine;
    }

    @Override
    public void collide(CollisionEvent e) {
        e.getReportingBody(); //the FinishLine
        e.getOtherBody(); //Sonic

        Sonic player = game.getPlayer();

        if (e.getOtherBody() instanceof Sonic && e.getReportingBody() instanceof FinishLine) {
            ((FinishLine) e.getReportingBody()).setSonicColided(true);
        }
//
//        if (e.getOtherBody() == player && game.isCurrentLevelCompleted() && finishLine.getCountdown() <= 0) {
//            System.out.println("Going to next level...");
//
//            game.setExtraLives(game.getPlayer().getLiveCount() - 3);
//
//            System.out.println("Extra Lives = " + game.getExtraLives());
//
//            game.removeSonicTracker();
//            game.goNextLevel();
//        }
    }
}
