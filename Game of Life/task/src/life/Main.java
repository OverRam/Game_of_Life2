package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        World world = new World(sc.nextInt(), sc.nextInt());
        world.showWorld();
    }
}
