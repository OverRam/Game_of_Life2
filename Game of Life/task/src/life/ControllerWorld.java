package life;

import javax.swing.*;
import java.awt.*;

public class ControllerWorld {
    private final GameOfLife gameOfLifeView;
    private final ViewWorld worldMap;
    private ModelWorld originalWorld;
    private ModelWorld worldModel;
    private int actualGeneration = 0;
    private int waitMilliSec;
    private boolean isPlay = false;
    private int numberOFGenerations = 100;
    private boolean isReset = false;
    private boolean isNotEndGeneration = true;

    ControllerWorld(GameOfLife gameOfLifeView, ModelWorld worldModel) {
        originalWorld = new ModelWorld(worldModel);
        this.gameOfLifeView = gameOfLifeView;
        this.worldModel = worldModel;
        waitMilliSec = gameOfLifeView.getsSpeedEvolutionSlide().getValue();
        worldMap = gameOfLifeView.getViewWorld();
        updateView();
        initListener();
    }

    void initListener() {
        gameOfLifeView.getsSpeedEvolutionSlide().addChangeListener(e -> setMilliSec(gameOfLifeView
                .getsSpeedEvolutionSlide().getValue()));
        gameOfLifeView.getBPauseButton().addActionListener(e -> isPlay = false);
        gameOfLifeView.getBPlayButton().addActionListener(e -> isPlay = true);
        gameOfLifeView.getBResetButton().addActionListener(e -> resetGame());
        gameOfLifeView.getBAcceptParamNewWorld().addActionListener(e -> {
            isPlay = false;
            gameOfLifeView.getBPlayButton().setSelected(false);

            try {
                long seed = Long.parseLong(gameOfLifeView.getTSeedWorld().getText());
                int size = Integer.parseInt(gameOfLifeView.getTSizeWorld().getText());
                int generations = Integer.parseInt(gameOfLifeView.getTNumberOfGenerations().getText());
                checkParamsNewWorld(seed, size, generations);
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(gameOfLifeView, "All params must be integers!!");
            }
        });

        gameOfLifeView.getBChoseColor().addActionListener(e -> {
            isPlay = false;
            gameOfLifeView.getBPlayButton().setSelected(false);
            worldMap.setCellColor(JColorChooser.
                    showDialog(gameOfLifeView, "Choose", Color.CYAN));
            worldMap.repaint();
        });
    }

    void checkParamsNewWorld(long seed, int size, int generations) {
        if (size > 50 || size < 5 || generations < 1) {
            JOptionPane.showMessageDialog(gameOfLifeView, "Size must be between 5 and 50.\n" +
                    "Generations must be grater 0.\nSeed max value is " + Long.MAX_VALUE + " and min is " +
                    Long.MIN_VALUE);
        } else {
            setParamsNewWorld(size, seed, generations);
            JOptionPane.showMessageDialog(gameOfLifeView, "All params correct :)");
        }
    }

    void run() {
        while (gameOfLifeView.isVisible()) {  //problem
            while (actualGeneration < numberOFGenerations && isNotEndGeneration && worldModel.getLiveCells() > 0) {
                if (isPlay) {
                    ++actualGeneration;
                    updateView();
                    NextGenerationsWorld.nextGenerationWorld(worldModel);
                    sleepMode();
                } else if (isReset) {
                    isReset = false;
                    worldModel = originalWorld;
                    actualGeneration = 0;
                    updateView();
                } else {
                    sleepMode();
                }
            }
            isNotEndGeneration = false;
            actualGeneration = 0;
            gameOfLifeView.getsSpeedEvolutionSlide().setValue(500);
            sleepMode();
        }
    }

    void setParamsNewWorld(int sizeWorld, long seedWorld, int numberOFGenerations) {
        originalWorld = new ModelWorld(sizeWorld, seedWorld);
        worldModel = new ModelWorld(sizeWorld, seedWorld);
        this.numberOFGenerations = numberOFGenerations;
        isNotEndGeneration = true;
        actualGeneration = 0;
        updateView();
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

    void updateView() {
        gameOfLifeView.setNumGenerationLabel(actualGeneration);
        gameOfLifeView.setNumAliveCells(worldModel.getLiveCells());
        worldMap.setWorldModel(worldModel);
        worldMap.repaint();
    }

    void resetGame() {
        isPlay = false;
        isNotEndGeneration = true;
        actualGeneration = 0;
        gameOfLifeView.getsSpeedEvolutionSlide().setValue(50);
        worldModel.setMatrixWorldModel(originalWorld.getMatrix());
        updateView();
    }
}
