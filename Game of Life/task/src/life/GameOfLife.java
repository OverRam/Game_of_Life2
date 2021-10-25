package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private final JLabel lGenerationLabel;
    private final JLabel lAliveCellsLabel;
    private int sizeNewWorld;
    private int generationsNewWorld;
    private ViewWorld drawWorld;
    private WorldController worldController;
    private int seedNewWorld;

    public GameOfLife() {
        super("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        drawWorld = new ViewWorld();

        JPanel centerPanel = drawWorld;

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
        JToggleButton bPlayButton = new JToggleButton("Play");

        JToggleButton bPauseButton = new JToggleButton("Pause");

        bPlayButton.setName("PlayToggleButton");
        bPlayButton.addActionListener(e -> {
            bPlayButton.setSelected(true);
            bPauseButton.setSelected(false);
            worldController.setPlay(true);
        });

        bPauseButton.addActionListener(e -> {
            bPlayButton.setSelected(false);
            bPauseButton.setSelected(true);
            worldController.setPlay(false);
        });

        JFileChooser fSaveWorld = new JFileChooser();
        JButton bSaveWorld = new JButton("Save world");

        JButton bOpenWorld = new JButton("Open world");

        JButton bResetButton = new JButton("Reset");
        bResetButton.setName("ResetButton");
        bResetButton.addActionListener(e -> {
            bPlayButton.setSelected(false);
            bPauseButton.setSelected(true);
            worldController.setPlay(false);
            worldController.setReset(true);
        });

        JButton bChoseColor = new JButton("Chose color");
        bChoseColor.addActionListener(e -> {
            worldController.setPlay(false);
            drawWorld.setCellColor(JColorChooser.
                    showDialog(this, "Choose", Color.CYAN));
            worldController.setPlay(true);
        });

        //Tools button section
        JLabel lSpeedModeLabel = new JLabel("Speed mode");

        JSlider sSpeedEvolutionSlide = new JSlider(0, 2000, 10);
        sSpeedEvolutionSlide.setName("Speed mode");
        sSpeedEvolutionSlide.setFont(new Font("Monospaced", Font.PLAIN, 10));
        sSpeedEvolutionSlide.setMajorTickSpacing(500);
        sSpeedEvolutionSlide.setMinorTickSpacing(100);
        sSpeedEvolutionSlide.setPaintTrack(true);
        sSpeedEvolutionSlide.setPaintTicks(true);
        sSpeedEvolutionSlide.setPaintLabels(true);
        sSpeedEvolutionSlide.addChangeListener(e -> worldController.setMilliSec(sSpeedEvolutionSlide.getValue()));

        JPanel pInputPanel = new JPanel();
        pInputPanel.setLayout(new GridLayout(4, 2));
        pInputPanel.setMaximumSize(new Dimension(200, 110));

        //pInputPanel in tool
        JTextField tSizeWorld = new JTextField();
        tSizeWorld.setSize(new Dimension(50, 30));
        tSizeWorld.setMaximumSize(new Dimension(50, 30));

        JTextField tSeedRandom = new JTextField();
        tSeedRandom.setMaximumSize(new Dimension(50, 30));

        JTextField tNumberOfGenerations = new JTextField();
        tNumberOfGenerations.setSize(new Dimension(50, 30));

        JButton bAcceptParamNewWorld = new JButton("Set world");

        JLabel lSizeWorldLabel = new JLabel("Size world");
        JLabel lSeedRandom = new JLabel("Seed random");
        JLabel lGenerationSetLabel = new JLabel("Generations");

        //Add to minor panels
        pButtonPanel.add(bPlayButton);
        pButtonPanel.add(bPauseButton);
        pButtonPanel.add(bResetButton);
        pButtonPanel.add(bChoseColor);
        pButtonPanel.add(bSaveWorld);
        pButtonPanel.add(bOpenWorld);

        pLabelPanel.add(lGenerationLabel);
        pLabelPanel.add(lAliveCellsLabel);

        pInputPanel.add(lSizeWorldLabel);
        pInputPanel.add(tSizeWorld);
        pInputPanel.add(lSeedRandom);
        pInputPanel.add(tSeedRandom);
        pInputPanel.add(lGenerationSetLabel);
        pInputPanel.add(tNumberOfGenerations);
        pInputPanel.add(bAcceptParamNewWorld);

        pToolsPanel.add(lSpeedModeLabel);
        pToolsPanel.add(sSpeedEvolutionSlide);
        pToolsPanel.add(pInputPanel);

        //Add to main Layout
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        pack();
    }

    void setNumGenerationLabel(long generation) {
        lGenerationLabel.setText("Generation # " + generation);
    }

    void setNumAliveCells(long cells) {
        lAliveCellsLabel.setText("Alive:" + cells);
    }

    ViewWorld getDrawWorld() {
        return drawWorld;
    }

    void setDrawWorld(ViewWorld drawWorld) {
        this.drawWorld = drawWorld;
    }

    void setWorldController(WorldController worldController) {
        this.worldController = worldController;
    }

}