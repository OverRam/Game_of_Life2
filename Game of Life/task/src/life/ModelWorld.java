package life;

import java.util.Arrays;
import java.util.Random;

public class ModelWorld {
    private int sizeWorld;
    private boolean[][] worldMatrix;
    private long seedWorld;
    private long liveCells;

    ModelWorld(int size) {
        this.sizeWorld = size;
        worldMatrix = new boolean[size][size];
        randomFillWorld();
        liveCells = countLiveCells();
    }

    ModelWorld(ModelWorld model) {
        sizeWorld = model.sizeWorld;
        worldMatrix = model.getMatrix();
        seedWorld = model.getSeedWorld();
        liveCells = model.getLiveCells();
    }

    ModelWorld(int sizeWorld, long seedWorld) {
        this.seedWorld = seedWorld;
        this.sizeWorld = sizeWorld;
        worldMatrix = new boolean[sizeWorld][sizeWorld];
        randomFillWorld();
        liveCells = countLiveCells();
    }

    public long getSeedWorld() {
        return seedWorld;
    }

    private long countLiveCells() {
        int count = 0;
        for (int i = 0; i < sizeWorld; i++) {
            for (int j = 0; j < sizeWorld; j++) {
                count += worldMatrix[i][j] ? 1 : 0;
            }
        }
        return count;
    }

    void setMatrixWorldModel(boolean[][] world) {
        this.worldMatrix = world;
        sizeWorld = world.length;
        liveCells = countLiveCells();
    }

    private void randomFillWorld() {
        Random rnd = new Random(seedWorld);
        for (int i = 0; i < sizeWorld; i++) {
            Arrays.fill(worldMatrix[i], false);
            for (int j = 0; j < sizeWorld; j++) {
                worldMatrix[i][j] = rnd.nextBoolean();
            }
        }
    }

    int getSizeWorld() {
        return sizeWorld;
    }

    boolean[][] getMatrix() {
        return worldMatrix;
    }

    long getLiveCells() {
        return liveCells;
    }
}
