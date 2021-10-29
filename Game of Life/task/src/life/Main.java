package life;

public class Main {
    public static void main(String[] args) {
        ControllerWorld controllerWorld = new ControllerWorld(new GameOfLife(), new ModelWorld(50));
        controllerWorld.run();
    }
}
