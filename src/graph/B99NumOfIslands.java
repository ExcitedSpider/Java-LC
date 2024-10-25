// https://kamacoder.com/problempage.php?pid=1171
package graph;

import java.util.LinkedList;
import java.util.Queue;

public class B99NumOfIslands {
  // graph is a int[m][n]
  public int numOfIsland(int[][] graph, int m, int n) {
    boolean[][] visited = new boolean[m][n];

    Queue<Pair> queue = new LinkedList<>();

    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 1 && !visited[i][j]) {
          ans++;
          queue.offer(new Pair(i, j));
          visited[i][j] = true;
          bfs(graph, visited, queue);
        }
      }
    }
    return ans;
  }

  /**
   * Pair
   */
  public record Pair(int x, int y) {
  }

  public static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  private void bfs(int[][] graph, boolean[][] visited, Queue<Pair> queue) {
    for (; queue.size() != 0;) {
      var coord = queue.poll();
      for (int[] dir : dirs) {
        int newX = dir[0] + coord.x;
        int newY = dir[1] + coord.y;
        if (newX < 0 || newX >= graph.length || newY < 0 || newY >= graph[0].length) {
          continue;
        }
        if (!visited[newX][newY] && graph[newX][newY] == 1) {
          visited[newX][newY] = true;
          queue.offer(new Pair(newX, newY));
        }
      }
    }
  }

  public static void main(String[] args) {
    var solver = new B99NumOfIslands();
    var res = solver.numOfIsland(new int[][] {
      {1,1,0,0,0},
      {1,1,0,0,0},
      {0,0,1,0,0},
      {0,0,0,1,1},
    }, 4, 5);
    System.err.println(res);
  }
}
