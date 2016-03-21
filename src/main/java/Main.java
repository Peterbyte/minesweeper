import grid.GridBuilder;
import grid.Tile;

public class Main {

    public static void main(String... args){
        Tile[][] grid = GridBuilder.build(10, 10, 20);

        for(Tile[] col : grid){
            for(Tile cell : col){
                System.out.printf(" %s ", cell.mined?"*":cell.hint);
            }
            System.out.println();
        }
    }

}
