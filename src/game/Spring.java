package game;

import city.cs.engine.*;

/**Spring - the Spring that takes Sonic upwards when he hits it*/

public class Spring extends StaticBody {

    private static final Shape springShape = new BoxShape(1.5f, 0.75f);
    private static final BodyImage sprigImage = new BodyImage("data/LevelObjects/Spring.png", 1.5f);

    public Spring(World world) {
        super(world, springShape);
        addImage(sprigImage);
    }

    public void makePush() {
        removeAllImages();
        addImage(new BodyImage("data/LevelObjects/SpringActive.gif", 1.5f));
    }
}
