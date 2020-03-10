/*
Given a 2x2 grid with location of mines as M and non-mines as 0. Return grid by marking sum of nearby mines for all non-mines.

0 0 0 0
0 0 0 0
0 0 0 0

1 1 0 0
M 1 0 0
1 1 0 0

1 1 0 0
M 2 1 0
2 M 1 0
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        int[][] minesGrid = new int[][] {
            {0, 0,  0,  0}, 
            {-1,0,  0,  0}, 
            {0, -1, 0,  0}
        };
        int[][] returnedMinesGrid = getMinesGrid(minesGrid);
        
        for (int i = 0; i < returnedMinesGrid.length; i++) {
            for (int j = 0; j < returnedMinesGrid[0].length; j++) {
                System.out.print(returnedMinesGrid[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
    
    private static int[][] getMinesGrid(int[][] minesGrid) {
        // Check for emptyness
        
        for (int i = 0; i < minesGrid.length; i++) {
            for (int j = 0; j < minesGrid[0].length; j++) {
                if (minesGrid[i][j] == -1) {
                    int tempI = i - 1;
                    int tempJ = j - 1;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);
                    
                    tempI = i;
                    tempJ = j - 1;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);

                    tempI = i + 1;
                    tempJ = j - 1;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);

                    tempI = i - 1;
                    tempJ = j;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);

                    tempI = i + 1;
                    tempJ = j;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);

                    tempI = i - 1;
                    tempJ = j + 1;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);

                    tempI = i;
                    tempJ = j + 1;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);
        
                    tempI = i + 1;
                    tempJ = j + 1;
                    markNearby(minesGrid, tempI, tempJ, minesGrid.length, minesGrid[0].length);
                }
            }
        }
        
        return minesGrid;
    }
    
    private static void markNearby(int[][] minesGrid, int i, int j, int rows, int cols) {
        boolean isAllowed = isInTheBoundry(i, j, rows, cols);
        if (isAllowed && minesGrid[i][j] != -1) {
            minesGrid[i][j] = minesGrid[i][j] + 1;
        }
    }
    
    private static boolean isInTheBoundry(int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows) {
            return false;
        }
        
        if (j < 0 || j >= cols) {
            return false;
        }
        
        return true;
    }
}
