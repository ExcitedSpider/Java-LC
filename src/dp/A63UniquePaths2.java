package dp;

import java.util.HashMap;
import java.util.Map;

public class A63UniquePaths2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    return uniquePaths(new Coord(m-1, n-1), obstacleGrid, new HashMap<>());     
  }

  private int uniquePaths(Coord coord, int[][] obstacleGrid, Map<Coord, Integer> memo) {
    int m = coord.m, n = coord.n;

    if (m == 0 && n == 0)
      return 1 - obstacleGrid[0][0];
    if (m < 0 || n < 0)
      return 0;
    if (obstacleGrid[m][n] == 1)
      return 0;
    if(m > 0 && n > 0 && obstacleGrid[m][n - 1] == 1 && obstacleGrid[m - 1][n] == 1)
      return 0;
    if (memo.containsKey(coord))
      return memo.get(coord);

    int res;
    if (obstacleGrid[m][n - 1] == 1) {
      res = uniquePaths(new Coord(m - 1, n), obstacleGrid, memo);
    } else if (obstacleGrid[m - 1][n] == 1) {
      res = uniquePaths(new Coord(m, n - 1), obstacleGrid, memo);
    } else {
      res = uniquePaths(new Coord(m, n - 1), obstacleGrid, memo) +
          uniquePaths(new Coord(m - 1, n), obstacleGrid, memo);
    }

    memo.put(coord, res);

    return res;
  }

  record Coord(int m, int n) {}
}
