package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private final JLabel generationLabel;
    private final JLabel aliveCellsLabel;
    private DrawWorld drawWorld;

    public GameOfLife() {
        super("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

        generationLabel = new JLabel("Generation #0");
        generationLabel.setName("GenerationLabel");

        aliveCellsLabel = new JLabel("Alive: 0");
        aliveCellsLabel.setName("AliveLabel");

        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.GRAY);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(generationLabel);
        northPanel.add(aliveCellsLabel);

        drawWorld = new DrawWorld();
        JPanel centerPanel = drawWorld;

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        pack();
    }

    void setNumGenerationLabel(long generation) {
        generationLabel.setText("   Generation # " + generation);
    }

    void setNumAliveCells(long cells) {
        aliveCellsLabel.setText("   Alive:" + cells);
    }

    DrawWorld getDrawWorld() {
        return drawWorld;
    }

    void setDrawWorld(DrawWorld drawWorld) {
        this.drawWorld = drawWorld;
    }

}