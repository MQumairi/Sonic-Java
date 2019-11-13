package game;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.text.View;

import city.cs.engine.*;

/** View for Background and Foreground*/

public class BackgroundView extends UserView {

    private Image background;
    private Game game;


    /** Background Constructor*/


    public BackgroundView(World world, int width, int height, Game game) {
        super(world, width, height);
        this.game = game;

        if (game.getLevelNumber() == 1) {
            this.background = new ImageIcon("data/GreenHill/GreenHillBG.png").getImage();
        }

        if (game.getLevelNumber() == 2) {
            this.background = new ImageIcon("data/IceCap/SnowBG.png").getImage();
        }

        if (game.getLevelNumber() == 3) {
            this.background = new ImageIcon("data/LaunchBase/LaunchBaseBG.png").getImage();
        }

        if (game.getLevelNumber() == 4) {
            background = new ImageIcon("data/MetalMadness/MetalMadnessDBG.png").getImage();
        }

        if (game.getLevelNumber() == 5) {
            background = new ImageIcon("data/MetalMadness/MetalMadnessDBG.png").getImage();
        }
    }

    public void makeGreen() {background = new ImageIcon("data/GreenHill/GreenHillBG.png").getImage();}

    public void makeSnow() {
        background = new ImageIcon("data/IceCap/SnowBG.png").getImage();
    }

    public void makeLaunch() {
        background = new ImageIcon("data/LaunchBase/LaunchBaseBG.png").getImage();
    }

    public void makeMetal() {
        background = new ImageIcon("data/MetalMadness/MetalMadnessDBG.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    /** Foreground - Statistics for Sonic's Life, and Rings*/

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.WHITE);

        Image lifeIcon = new ImageIcon("data/Icons/LivesIconSmall.gif").getImage();
        Image ringIcon = new ImageIcon("data/Icons/RingIconSmall.png").getImage();


        g.drawImage(lifeIcon, 5, 25, null);

        g.drawString("Rings: " + game.getPlayer().getRingCount(), 10, 18);
        g.drawString("X" + game.getPlayer().getLiveCount(), 40, 40);

    }
}
