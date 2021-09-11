package life;

import java.util.Arrays;
import java.util.Random;

public class World {
    int size;
    boolean[][] wordMap;
    int aliveCells;

    public World(int size, int aliveCells) {
        this.size = size;
        wordMap = new boolean[size][size];
        this.aliveCells = aliveCells;
        fillWorld();
    }

    private void fillWorld() {
        Random rnd = new Random(aliveCells);

        for (int i = 0; i < size; i++) {
            Arrays.fill(wordMap[i], false);
            for (int j = 0; j < size; j++) {
                wordMap[i][j] = rnd.nextBoolean();
            }
        }
    }

    void showWorld() {
        for (boolean[] e : wordMap) {
            for (boolean w : e) {
                System.out.print(w ? 'O' : ' ');
            }
            System.out.println();
        }
    }

}
