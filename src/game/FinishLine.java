package game;

import city.cs.engine.*;

/**The Finish Line*/

public class FinishLine extends StaticBody {

    int countdown = 80;
    boolean sonicColided = false;
    
    /**
     * Initialise a new door.
     * @param world The world.
     */

    public FinishLine(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/LevelObjects/FinishlineEggman.png", 2.8f));
    }

    public void makeSpin() {
        removeAllImages();
        addImage(new BodyImage("data/LevelObjects/FinishlineSpin.gif", 2.8f));
    }

    public void makeStop() {
        removeAllImages();
        addImage(new BodyImage("data/LevelObjects/FinishlineSonic.png", 2.8f));
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public void decrementCountdown() {
        countdown--;
    }

    public boolean getSonicColided() {
        return sonicColided;
    }

    public void setSonicColided(boolean sonicColided) {
        this.sonicColided = sonicColided;
    }
}
