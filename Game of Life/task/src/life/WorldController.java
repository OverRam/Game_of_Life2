package life;

public class WorldController {
    private final GameOfLife gameOfLifeView;
    private ModelWorld worldModel;
    private int actualGeneration = 0;
    private int waitMilliSec = 500;
    private boolean isPlay = false;
    private int numberOFGenerations = 100;
    private boolean isReset = false;
    private ModelWorld originalWorld;

    WorldController(GameOfLife gameOfLifeView, ModelWorld worldModel) {
        originalWorld = worldModel;
        this.gameOfLifeView = gameOfLifeView;
        this.worldModel = worldModel;
        gameOfLifeView.setWorldController(this);
        updateView();
    }

    void run() {
        while (actualGeneration < numberOFGenerations) {
            if (isPlay) {
                updateView();
                generateNextWorld();
                sleepMode();
                actualGeneration++;
            } else if (isReset) {
                isReset = false;
                worldModel = originalWorld;
                actualGeneration = 0;
                updateView();

            } else {
                sleepMode();
            }
        }
        actualGeneration = 0;
    }

    void setParamsNewWorld(int sizeWorld, long seedWorld, int numberOFGenerations) {
        originalWorld = new ModelWorld(sizeWorld, seedWorld);
        worldModel = new ModelWorld(sizeWorld, seedWorld);
        this.numberOFGenerations = numberOFGenerations;
    }

    void setMilliSec(int waitMilliSec) {
        this.waitMilliSec = waitMilliSec;
    }

    private void sleepMode() {
        try {
            Thread.sleep(waitMilliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void generateNextWorld() {
        NextGenerationsWorld.nextGenerationWorld(worldModel);
    }

    void updateView() {
        gameOfLifeView.setNumGenerationLabel(actualGeneration);
        gameOfLifeView.setNumAliveCells(worldModel.getLiveCells());

        ViewWorld worldMap = gameOfLifeView.getDrawWorld();
        worldMap.setWorldModel(worldModel);
        worldMap.repaint();
        gameOfLifeView.setDrawWorld(worldMap);
    }

    void setPlay(boolean play) {
        isPlay = play;
    }

    public void setReset(boolean reset) {
        isReset = reset;
    }
}
