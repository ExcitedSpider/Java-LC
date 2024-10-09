package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A77Combinations {
  public List<List<Integer>> combine(int n, int k) {
    solution = new ArrayList<>();
    combine(n, k, 1, new LinkedList<>());
    return solution;
  } 

  private List<List<Integer>> solution;

  private void combine(int n, int k, int least, LinkedList<Integer> path) {
    if(path.size() == k) {
      solution.add(new ArrayList<>(path));
    } else {
      for(var i = least; i <= n; i++) {
        path.push(i);
        combine(n, k, i + 1, path);
        path.pop();
      }
    }
  }

  public static void main(String[] args) {
    var res = new A77Combinations().combine(4, 2);
    System.err.println(res.toString());
  }
}
