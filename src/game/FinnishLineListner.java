package game;

import city.cs.engine.*;


/** FinnishLineListner - Handles the spinning of the FinnishLine, and then taking Sonic to next level when it stops spinning*/

public class FinnishLineListner implements StepListener {

    private FinishLine finishLine;
    private Game game;

    public FinnishLineListner(Game game, FinishLine finishLine) {
        this.finishLine = finishLine;
        this.game = game;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if(finishLine.getSonicColided() && finishLine.getCountdown() >= 30) {
            finishLine.makeSpin();
            finishLine.decrementCountdown();
            game.getGameLevel().getLevelMusic().stop();
        }

        if(finishLine.getCountdown() < 30) {
            finishLine.makeStop();
            finishLine.decrementCountdown();
        }

        if(finishLine.getCountdown() <= -10) {
            finishLine.setCountdown(80);
        }


        if (finishLine.getCountdown() <= 0) {
//            System.out.println("Going to next level...");

            game.setExtraLives(game.getPlayer().getLiveCount() - 3);

//            System.out.println("Extra Lives = " + game.getExtraLives());



            game.removeSonicTracker();
            game.goNextLevel();
        }

    }

}