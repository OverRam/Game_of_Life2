package life;

import javax.swing.*;
import java.awt.*;

public class ViewWorld extends JPanel {
    private static final int sizeCell = 10;
    private ModelWorld wolWorldModel;
    private boolean[][] worldMatrix;
    private Color cellColor = Color.BLACK;

    ViewWorld(ModelWorld wolWorldModel) {
        this.wolWorldModel = wolWorldModel;
        int size = wolWorldModel.getSizeWorld() * 10 + 10;
        this.setPreferredSize(new Dimension(size, size));
    }

    void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
    }

    public void paint(Graphics g) {
        super.paint(g);
        worldMatrix = wolWorldModel.getMatrix();
        drawCells(g);
        drawGrid(g);
    }

    void drawGrid(Graphics g) {
        g.setColor(g.getColor() == Color.BLACK ? Color.gray : Color.BLACK);
        for (int i = 0; i < worldMatrix.length * sizeCell + sizeCell; i += sizeCell) {
            //worldMatrix.length * sizeCell == length draw line
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
