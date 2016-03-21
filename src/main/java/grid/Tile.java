package grid;

public class Tile {

    public boolean mined;
    public int hint;

    private Tile topLeft, top, topRight, right, bottomRight, bottom, bottomLeft, left;

    void setPosition(int x, int y, Tile[][] grid){
        int w = grid.length;
        int h = grid[0].length;

        if(x > 0){
            left = grid[x-1][y];
            if(y > 0){
                topLeft = grid[x-1][y-1];
            }
            if(y < h-1){
                bottomLeft = grid[x-1][y+1];
            }
        }
        if(x < w-1){
            right = grid[x+1][y];
            if(y > 0){
                topRight = grid[x+1][y-1];
            }
            if(y < h-1){
                bottomRight = grid[x+1][y+1];
            }
        }
        if(y > 0){
            top = grid[x][y-1];
        }
        if(y < h-1){
            bottom = grid[x][y+1];
        }
    }

    void mine(){
        mined = true;
        hint = -1;

        if(left != null){
            left.hint++;
            if(topLeft != null){
                topLeft.hint++;
            }
            if(bottomLeft != null){
                bottomLeft.hint++;
            }
        }
        if(right != null){
            right.hint++;
            if(topRight != null){
                topRight.hint++;
            }
            if(bottomRight != null){
                bottomRight.hint++;
            }
        }
        if(top != null){
            top.hint++;
        }
        if(bottom != null){
            bottom.hint++;
        }
    }

}
