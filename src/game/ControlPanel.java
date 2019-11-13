package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;


public class ControlPanel {
    Icon pauseIcon = new ImageIcon("data/Icons/pause.png");
    private JPanel mainPanel;
    private JButton saveButton;
    private JButton loadButton;
    private JComboBox teleporter;
    private JButton pauseButton;
    private Game game;
    private JFrame menu;
    private String savedLevelString;
    private int savedLevelInt;
    private int savedLivesInt;

    public ControlPanel(JFrame menu, Game game) throws IOException {
        this.game = game;
        this.menu = menu;
        mainPanel = new JPanel();
        Color c = new Color(1f, 0f, 0f, 0f);
        mainPanel.setBackground(c);

        mainPanel.add(saveButton);
        mainPanel.add(loadButton);
        mainPanel.add(teleporter);
        mainPanel.add(pauseButton);
        menu.add(mainPanel);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    //For level position
                    savedLevelInt = game.getLevelNumber();
                    FileWriter fw = new FileWriter("savedata.txt");
                    PrintWriter pw = new PrintWriter("savedata.txt");

                    pw.println(savedLevelInt);
                    pw.close();

                    //For lives
                    savedLivesInt = game.getPlayer().getLiveCount();
                    FileWriter fwl = new FileWriter("savedlives.txt");
                    PrintWriter pwl = new PrintWriter("savedlives.txt");

                    pwl.println(savedLivesInt);
                    pwl.close();

                }

                catch (IOException x) {
                    System.out.println("ERROR - did not save!");
                }

                System.out.println("Saved successfully!");

            }
        });


        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String loadedLevel;
                String loadedLives;



                try {

                    //For level load
                    FileReader fr = new FileReader("savedata.txt");
                    BufferedReader br = new BufferedReader(fr);

                    loadedLevel = br.readLine();


                    br.close();

                    savedLevelInt = Integer.parseInt(loadedLevel);
                    game.getGameLevel().getLevelMusic().stop();
                    game.setLevelNumber(savedLevelInt - 1);
                    game.goNextLevel();

                    //For lives load
                    FileReader frl = new FileReader("savedlives.txt");
                    BufferedReader brl = new BufferedReader(frl);

                    loadedLives = brl.readLine();


                    brl.close();

                    savedLivesInt = Integer.parseInt(loadedLives);
                    game.getPlayer().setLiveCount(savedLivesInt);

                }

                catch (IOException x) {
                    System.out.println("No saved data found!");
                }

                System.out.println("Loading saved data...");

            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(game.getIsPaused()) {
                    game.getGameLevel().start();
                    game.setIsPaused(false);
                    pauseButton.setText("Pause");
                } else {
                    game.getGameLevel().stop();
                    game.setIsPaused(true);
                    pauseButton.setText("Go");
                }

            }
        });

        teleporter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if(e.getStateChange() == ItemEvent.SELECTED) {

                    if (teleporter.getSelectedItem().equals("Green Hill")) {
                        game.getGameLevel().getLevelMusic().stop();
                        game.setLevelNumber(0);
                        game.goNextLevel();
                        System.out.println("Level Jumping to Green Hill Zone");
                    }

                    if (teleporter.getSelectedItem().equals("Ice Cap")) {
                        game.getGameLevel().getLevelMusic().stop();
                        game.setLevelNumber(1);
                        game.goNextLevel();
                        System.out.println("Level Jumping to Ice Cap Zone");
                    }

                    if (teleporter.getSelectedItem().equals("Launch Base")) {
                        game.getGameLevel().getLevelMusic().stop();
                        game.setLevelNumber(2);
                        game.goNextLevel();
                        System.out.println("Level Jumping to Launch Base");
                    }

                    if (teleporter.getSelectedItem().equals("Metal Madness")) {
                        game.getGameLevel().getLevelMusic().stop();
                        game.setLevelNumber(3);
                        game.goNextLevel();
                        System.out.println("Level Jumping to Metal Madness");
                    }

                    if (teleporter.getSelectedItem().equals("Dr.Robotnik")) {
                        game.getGameLevel().getLevelMusic().stop();
                        game.setLevelNumber(4);
                        game.goNextLevel();
                        System.out.println("Level Jumping to Final Boss Fight");
                    }
                }

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
