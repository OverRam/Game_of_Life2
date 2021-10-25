package life;

import java.util.Arrays;
import java.util.Random;

public class ModelWorld {
    private final int size;
    private boolean[][] worldMatrix;
    private long seedWorld;
    private long liveCells;

    ModelWorld(int size) {
        this.size = size;
        worldMatrix = new boolean[size][size];
        randomFillWorld();
        liveCells = countLiveCells();
    }

    ModelWorld(int sizeWorld, long seedWorld) {
        this.seedWorld = seedWorld;
        this.size = sizeWorld;
        worldMatrix = new boolean[sizeWorld][sizeWorld];
        randomFillWorld();
        liveCells = countLiveCells();
    }

    private long countLiveCells() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count += worldMatrix[i][j] ? 1 : 0;
            }
        }
        return count;
    }

    void setMatrixWorldModel(boolean[][] world) {
        if (world.length == size) {
            this.worldMatrix = world;
            liveCells = countLiveCells();
        } else {
            System.out.println("Wrong matrix");
        }
    }

    private void randomFillWorld() {
        Random rnd = new Random(seedWorld);
        for (int i = 0; i < size; i++) {
            Arrays.fill(worldMatrix[i], false);
            for (int j = 0; j < size; j++) {
                worldMatrix[i][j] = rnd.nextBoolean();
            }
        }
    }

    int getSize() {
        return size;
    }

    boolean[][] getWordMatrix() {
        return worldMatrix;
    }

    long getLiveCells() {
        return liveCells;
    }
}
