package life;

public class WorldView {

    void printModel(WorldModel worldModel) {
        boolean[][] model = worldModel.getWordMatrix();
        for (boolean[] row : model) {
            for (boolean column : row) {
                System.out.print(column ? 'O' : ' ');
            }
            System.out.println();
        }
    }
}
