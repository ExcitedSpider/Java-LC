package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * BDFS
 */
public class A797DFS {

  List<List<Integer>> paths;

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(0);

    dfs(graph, 0, path);

    return paths;
  }

  private void dfs(int[][] graph, int cur, List<Integer> path) {
    if (cur == graph.length - 1)
      paths.addLast(new ArrayList<>(path));
    else {
      for (var next : graph[cur]) {
        path.addLast(next);
        dfs(graph, next, path);
        path.removeLast();
      }
    }
  }
}