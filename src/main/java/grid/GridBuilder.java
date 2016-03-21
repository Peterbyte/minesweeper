package grid;

import java.util.Random;

public class GridBuilder {

    public static Tile[][] build(int width, int height, int mines){
        Tile[][] grid = buildGrid(width, height);
        placeMines(grid, mines);

        return grid;
    }

    private static void placeMines(Tile[][] grid, int qty){
        int minesPlaced = 0;
        Random rand = new Random();

        int width = grid.length;
        int height = grid[0].length;

        int tileQty = width * height;

        if(tileQty < qty){
            for(Tile[] row : grid){
                for(Tile t : row){
                    t.mine();
                }
            }
            return;
        }

        while(minesPlaced < qty) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);

            Tile tile = grid[x][y];
            if(!tile.mined){
                tile.mine();

                minesPlaced++;
            }
        }
    }

    private static Tile[][] buildGrid(int w, int h){
        Tile[][] grid = new Tile[w][h];

        for(Tile[] row : grid){
            for (int i = 0; i < row.length; i++) {
                row[i] = new Tile();
            }
        }
        for (int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                Tile tile = grid[x][y];
                tile.setPosition(x, y, grid);
            }
        }

        return grid;
    }

}
