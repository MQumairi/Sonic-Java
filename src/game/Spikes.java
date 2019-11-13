package game;

import city.cs.engine.*;

/**Spikes - the spikes obstacle*/

public class Spikes extends StaticBody {

    private static final Shape spikesShape = new BoxShape(2, 2);
    private static final BodyImage spikesImage = new BodyImage("data/LevelObjects/SpikesHD.png", 4);

    public Spikes(World world) {
        super(world, spikesShape);
        addImage(spikesImage);
    }
}
