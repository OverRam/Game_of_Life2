package life;

public class WorldController {
    WorldView worldView;
    WorldModel worldModel;

    public WorldController(WorldView worldView, WorldModel worldModel) {
        this.worldView = worldView;
        this.worldModel = worldModel;
    }


    void updateView(){
        worldView.printModel(worldModel);
    }
}
