import grid.GridBuilder;
import grid.Tile;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridBuilderTest {

    @Test
    public void buildGridWidth(){
        int width = 10;
        Tile[][] tiles = GridBuilder.build(width, 1, 0);

        assertNotNull(tiles);
        assertEquals(width, tiles.length);
    }

    @Test
    public void buildGridHeight(){
        int height = 10;
        Tile[][] tiles = GridBuilder.build(1, height, 0);

        assertNotNull(tiles);
        assertTrue(tiles.length > 0);
        assertNotNull(tiles[0]);
        assertEquals(height, tiles[0].length);
    }

    @Test
    public void minesTiles(){
        int expectedMines = 5;
        Tile[][] tiles = GridBuilder.build(4, 5, expectedMines);

        int mines = 0;

        for(Tile[] col : tiles){
            for(Tile cell : col){
                mines += cell.mined ? 1 : 0;
            }
        }

        assertEquals(expectedMines, mines);
    }

}
