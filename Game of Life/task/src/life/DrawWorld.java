package life;

import javax.swing.*;
import java.awt.*;

public class DrawWorld extends JPanel {
    private WorldModel wolWorldModel;

    DrawWorld() {
        setPreferredSize(new Dimension(260, 260));
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);

        if (wolWorldModel != null) {
            boolean[][] matrix = wolWorldModel.getWordMatrix();
            int sizeCell = 10;

            for (int i = 0, r = 0; i < matrix.length * sizeCell; i += sizeCell, r++) {
                //draw grid
                g.drawLine(sizeCell + i, 0, sizeCell + i, matrix.length * sizeCell);
                g.drawLine(0, sizeCell + i, matrix.length * sizeCell, sizeCell + i);

                for (int k = 0, c = 0; k < matrix.length * sizeCell; k += 10, c++) {
                    //draw live cells
                    if (matrix[r][c]) {
                        g.fillRect(k, i, sizeCell, sizeCell);
                    }
                }
            }
        }
    }

    void setWorldModel(WorldModel wolWorldModel) {
        this.wolWorldModel = wolWorldModel;
    }
}
