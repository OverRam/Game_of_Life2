package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int sizeWorld = sc.nextInt();


        WorldController worldController = new WorldController(new GameOfLife(), new WorldModel(10));

        worldController.worldsGenerations(10);
    }
}
