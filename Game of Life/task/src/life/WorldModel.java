package life;

import java.util.Arrays;
import java.util.Random;

public class WorldModel {
    private int size;
    private boolean[][] world;
    private long seedWorld = 0;

    WorldModel(int size, long seedWorld) {
        this.size = size;
        world = new boolean[size][size];
        this.seedWorld = seedWorld;
    }

    WorldModel(int size, boolean[][] worldMatrix) {
        this.size = size;
        world = worldMatrix;
    }

    void setWorldModel(boolean[][] world, int sizeWorld) {
        this.size = sizeWorld;
        this.world = world;
    }

    void initialFillWorld() {
        Random rnd = new Random(seedWorld);
        for (int i = 0; i < size; i++) {
            Arrays.fill(world[i], false);
            for (int j = 0; j < size; j++) {
                world[i][j] = rnd.nextBoolean();
            }
        }
    }

    int getSize() {
        return size;
    }

    boolean[][] getWordMatrix() {
        return world;
    }
}
