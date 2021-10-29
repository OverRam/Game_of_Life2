package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private final JLabel lGenerationLabel;
    private final JLabel lAliveCellsLabel;
    private final JSlider sSpeedEvolutionSlide;
    private final JTextField tSizeWorld;
    private final JTextField tSeedWorld;
    private final JTextField tNumberOfGenerations;
    private final JToggleButton bPlayButton;
    private final JToggleButton bPauseButton;
    private final JButton bChoseColor;
    private final JButton bResetButton;
    private final JButton bAcceptParamNewWorld;
    private final ViewWorld viewWorld = new ViewWorld(new ModelWorld(50));

    public GameOfLife() {
        super("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

        //Minor panels
        JPanel pButtonPanel = new JPanel();
        pButtonPanel.setLayout(new GridLayout(3, 2));
        pButtonPanel.setMaximumSize(new Dimension(300, 100));

        JPanel pLabelPanel = new JPanel();
        pLabelPanel.setLayout(new GridLayout(2, 1));
        pLabelPanel.setMaximumSize(new Dimension(150, 30));

        JPanel pToolsPanel = new JPanel();
        pToolsPanel.setLayout(new BoxLayout(pToolsPanel, BoxLayout.Y_AXIS));

        //Add to west panel section
        westPanel.add(pButtonPanel);
        westPanel.add(pLabelPanel);
        westPanel.add(pToolsPanel);

        //Label section
        lGenerationLabel = new JLabel("Generation #0");
        lGenerationLabel.setName("GenerationLabel");

        lAliveCellsLabel = new JLabel("Alive: 0");
        lAliveCellsLabel.setName("AliveLabel");

        //button panel Section
        bPlayButton = new JToggleButton("Play");

        bPauseButton = new JToggleButton("Pause");

        bPlayButton.setName("PlayToggleButton");
        bPlayButton.addActionListener(e -> {
            bPlayButton.setSelected(true);
            bPauseButton.setSelected(false);
        });

        bPauseButton.addActionListener(e -> {
            bPlayButton.setSelected(false);
            bPauseButton.setSelected(true);
        });

        bResetButton = new JButton("Reset");
        bResetButton.setName("ResetButton");
        bResetButton.addActionListener(e -> {
            bPlayButton.setSelected(false);
            bPauseButton.setSelected(true);
        });

        bChoseColor = new JButton("Chose color");

        //Tools button section
        JLabel lSpeedModeLabel = new JLabel("Speed mode");

        sSpeedEvolutionSlide = new JSlider(0, 2000, 50);
        sSpeedEvolutionSlide.setName("Speed mode");
        sSpeedEvolutionSlide.setFont(new Font("Monospaced", Font.PLAIN, 10));
        sSpeedEvolutionSlide.setMajorTickSpacing(500);
        sSpeedEvolutionSlide.setMinorTickSpacing(100);
        sSpeedEvolutionSlide.setPaintTrack(true);
        sSpeedEvolutionSlide.setPaintTicks(true);
        sSpeedEvolutionSlide.setPaintLabels(true);

        JPanel pInputPanel = new JPanel();
        pInputPanel.setLayout(new GridLayout(4, 2));
        pInputPanel.setMaximumSize(new Dimension(200, 110));

        //pInputPanel in tool
        tSizeWorld = new JTextField("Numbers only");
        tSizeWorld.setSize(new Dimension(50, 30));
        tSizeWorld.setMaximumSize(new Dimension(50, 30));

        tSeedWorld = new JTextField("Numbers only");
        tSeedWorld.setMaximumSize(new Dimension(50, 30));

        tNumberOfGenerations = new JTextField("Numbers only");
        tNumberOfGenerations.setSize(new Dimension(50, 30));

        bAcceptParamNewWorld = new JButton("Set world");

        JLabel lSizeWorldLabel = new JLabel("Size world");
        JLabel lSeedRandom = new JLabel("Seed random");
        JLabel lGenerationSetLabel = new JLabel("Generations");

        //Add to minor panels
        pButtonPanel.add(bPlayButton);
        pButtonPanel.add(bPauseButton);
        pButtonPanel.add(bResetButton);
        pButtonPanel.add(bChoseColor);

        pLabelPanel.add(lGenerationLabel);
        pLabelPanel.add(lAliveCellsLabel);

        pInputPanel.add(lSizeWorldLabel);
        pInputPanel.add(tSizeWorld);
        pInputPanel.add(lSeedRandom);
        pInputPanel.add(tSeedWorld);
        pInputPanel.add(lGenerationSetLabel);
        pInputPanel.add(tNumberOfGenerations);
        pInputPanel.add(bAcceptParamNewWorld);

        pToolsPanel.add(lSpeedModeLabel);
        pToolsPanel.add(sSpeedEvolutionSlide);
        pToolsPanel.add(pInputPanel);

        //Add to main Layout
        add(westPanel, BorderLayout.WEST);
        add(viewWorld, BorderLayout.CENTER);
        pack();
    }

    JButton getBChoseColor() {
        return bChoseColor;
    }

    JSlider getsSpeedEvolutionSlide() {
        return sSpeedEvolutionSlide;
    }

    JTextField getTSizeWorld() {
        return tSizeWorld;
    }

    JTextField getTSeedWorld() {
        return tSeedWorld;
    }

    JTextField getTNumberOfGenerations() {
        return tNumberOfGenerations;
    }

    JButton getBAcceptParamNewWorld() {
        return bAcceptParamNewWorld;
    }

    JToggleButton getBPlayButton() {
        return bPlayButton;
    }

    JToggleButton getBPauseButton() {
        return bPauseButton;
    }

    JButton getBResetButton() {
        return bResetButton;
    }

    void setNumGenerationLabel(long generation) {
        lGenerationLabel.setText("Generation # " + generation);
    }

    void setNumAliveCells(long cells) {
        lAliveCellsLabel.setText("Alive:" + cells);
    }

    ViewWorld getViewWorld() {
        return viewWorld;
    }
}