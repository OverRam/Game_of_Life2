package life;

import javax.swing.*;
import java.awt.*;

public class ViewWorld extends JPanel {
    private static final int sizeCell = 10;
    private ModelWorld wolWorldModel;
    private boolean[][] worldMatrix;
    private Color cellColor = Color.BLACK;

    ViewWorld() {
        setPreferredSize(new Dimension(300, 300));
    }

    void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (wolWorldModel != null) {
            worldMatrix = wolWorldModel.getWordMatrix();
            drawGrid(g);
            drawCells(g);
        }
    }

    void drawGrid(Graphics g) {
        for (int i = 0; i < worldMatrix.length * sizeCell + sizeCell; i += sizeCell) {
            //worldMatrix.length * sizeCell == length line
            g.drawLine(i, 0, i, worldMatrix.length * sizeCell);
            g.drawLine(0, i, worldMatrix.length * sizeCell, i);
        }
    }

    void drawCells(Graphics g) {
        g.setColor(cellColor);
        for (int i = 0, r = 0; i < worldMatrix.length * sizeCell; i += sizeCell, r++) {
            for (int k = 0, c = 0; k < worldMatrix.length * sizeCell; k += 10, c++) {
                //draw live cells
                if (worldMatrix[r][c]) {
                    g.fillRect(k, i, sizeCell, sizeCell);
                }
            }
        }

    }

    void setWorldModel(ModelWorld wolWorldModel) {
        this.wolWorldModel = wolWorldModel;
    }
}
