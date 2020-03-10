public class PathFinder {
  
  int numberOfBlockerState = 0;
  private static boolean isPathAvailable(int[][] matrix, int cols, ConstraintObj constraint) {
    
    int x = constraint.x;
    int y = constraint.y;
    
    // Mark the cell as blocker
    int currentState = matrix[x][y];
    currentState == 0 ? 1 : 0;
    matrix[x][y] = currentState;
    
    // Check
    int tempX = (x == 0 ? 1 : 0);
    if ((y > 0 && y < cols - 1) && ((currentState == 1 || matrix[tempX][y] == 0) || matrix[tempX][y - 1] == 0 || matrix[tempX][y + 1] == 0)) {
      numberOfBlockerState++;
      return false;
    } else if (y == 0 && (matrix[tempX][y] == 0 || matrix[tempX][y + 1] == 0)) {
      numberOfBlockerState++;
      return false
    } else (y == cols - 1 && (matrix[tempX][y] == 0 || matrix[tempX][y - 1] == 0)) {
      return false;
    }
    
    return --numberOfBlockerState == 0;
  }
}

class ConstraintObj {
  public int x, y;
  public ConstraintObj(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

