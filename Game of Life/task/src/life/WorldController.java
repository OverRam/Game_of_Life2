package life;

import java.io.IOException;

public class WorldController {
    private final GameOfLife gameOfLifeView;
    private final WorldModel worldModel;
    private int generation = 0;

    WorldController(GameOfLife gameOfLifeView, WorldModel worldModel) {
        this.gameOfLifeView = gameOfLifeView;
        this.worldModel = worldModel;
    }

    private static void waitMilliSec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clearScr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }

    void worldsGenerations(int NumberOfGenerations) {
        for (int i = 0; i < NumberOfGenerations + 1; i++) {
            NextGenerationsWorld.nextGenerationWorld(worldModel);
            updateView();
            waitMilliSec();
            generation++;
        }
        generation = 0;
    }

    void updateView() {
        gameOfLifeView.setNumGenerationLabel(generation);
        gameOfLifeView.setNumAliveCells(worldModel.getLiveCells());

        DrawWorld worldMap = gameOfLifeView.getDrawWorld();
        worldMap.setWorldModel(worldModel);
        worldMap.repaint();
        gameOfLifeView.setDrawWorld(worldMap);
    }
}
