package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeWorld = sc.nextInt();
        long seed = sc.nextLong();
        int generations = sc.nextInt();

        WorldModel worldModel = new WorldModel(sizeWorld, seed);
        worldModel.initialFillWorld();
        WorldView worldView = new WorldView();
        WorldController worldController = new WorldController(worldView, worldModel);

        for (int i = 0; i < generations; i++) {
            worldModel.setWorldModel(GenerationsWorlds.nextGeneration(worldModel).getWordMatrix(), worldModel.getSize());
        }
        worldController.updateView();
    }
}
