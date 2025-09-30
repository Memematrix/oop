public class TetrisGrid {
    boolean[][] grid;
    boolean[] empty;
    TetrisGrid(boolean[][] grid) {
        this.grid = grid;
        this.empty = new boolean[grid.length];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    private boolean isFull(int col) {
        for(int i = 0; i < grid.length; ++i) {
            if(grid[i][col] == false) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmpty(int col) {
        for(int i = 0; i < grid.length; ++i) {
            if(grid[i][col] == true) {
                return false;
            }
        }
        return true;
    }

    private void makeEmpty(int col) {
        for(int i = 0; i < grid.length; ++i) {
            grid[i][col] = false;
        }
    }

    public void clearRows() {
        for(int i = 0; i < grid[0].length; ++i) {
            if(isFull(i) == true) {
                makeEmpty(i);
            }
        }
        for(int i = 0; i < grid[0].length; ++i) {
            for(int j = i; j > 0; --j) {
                if(isEmpty(j-1) == true) {
                    for(int k = 0; k < grid.length; ++k) {
                        grid[k][j-1] = grid[k][j];
                    }
                    makeEmpty(j);
                }
                if(isFull(j-1) == true) {
                    makeEmpty(j-1);
                }
//                for(int rows = 0; rows < grid.length; ++rows) {
//                    for(int cols = 0; cols < grid[rows].length; ++cols) {
//                        System.out.print(grid[rows][cols] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        boolean[][] before =
                {
                        {true, true, false},
                        {false, true, false,},
                        {true, true, true,},
                        {false, false, false}
                };
        TetrisGrid grid = new TetrisGrid(before);
        grid.clearRows();
        boolean[][] temp = grid.getGrid();
//        for(int i = 0; i < temp.length; ++i) {
//            for(int j = 0; j < temp[i].length; ++j) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
