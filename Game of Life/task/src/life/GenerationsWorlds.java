package life;

public class GenerationsWorlds {

    static WorldModel nextGeneration(WorldModel world) {
        boolean[][] newMatrix = new boolean[world.getSize()][world.getSize()];
        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                newMatrix[i][j] = setStatusCell(world.getWordMatrix(), i, j);
            }
        }

        return new WorldModel(world.getSize(), newMatrix);
    }

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
}