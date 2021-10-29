package life;

public class NextGenerationsWorld {

    private static boolean setStatusCell(boolean[][] worldToCheck, int actualRow, int actualColumn) {
        int maxNum = worldToCheck.length;
        int liveCell = 0;

        for (int i = 0, row; i < 3; i++) {
            for (int j = 0, col; j < 3; j++) {

                if (!(i - 1 == 0 && j - 1 == 0)) {
                    row = actualRow + i - 1;
                    row = row < 0 ? maxNum - 1 : row >= maxNum ? 0 : row;

                    col = actualColumn + j - 1;
                    col = col < 0 ? maxNum - 1 : col >= maxNum ? 0 : col;

                    liveCell += worldToCheck[row][col] ? 1 : 0;
                }
            }
        }

        if (!worldToCheck[actualRow][actualColumn] && liveCell == 3) {
            return true;
        }
        return worldToCheck[actualRow][actualColumn] && (liveCell == 2 | liveCell == 3);
    }

    static void nextGenerationWorld(ModelWorld worldModel) {
        boolean[][] newMatrix = new boolean[worldModel.getSizeWorld()][worldModel.getSizeWorld()];
        for (int i = 0; i < worldModel.getSizeWorld(); i++) {
            for (int j = 0; j < worldModel.getSizeWorld(); j++) {
                newMatrix[i][j] = setStatusCell(worldModel.getMatrix(), i, j);
            }
        }
        worldModel.setMatrixWorldModel(newMatrix);
    }
}
