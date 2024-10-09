package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A216Combination3 {
  
  private List<List<Integer>> solution;

  public List<List<Integer>> combinationSum3(int k, int n) {
    solution = new ArrayList<>();
    combinationSum3(k, n, 1, 0, new LinkedList<>());
    return solution;
  }

  private void combinationSum3(int k, int n, int least, int sum, LinkedList<Integer> path) {
    if(path.size() == k && sum == n) {
      solution.add(new ArrayList<>(path));
    } 
    // optional, for performance
    // if we pick all '9' for the rest elements, it is still can't reach n
    // apparently the path is not possible to contain a solution.
    else if((k - path.size()) * 9 < n - sum) {
      return;
    } else {
      for (var i = least; i <= 9; i ++) {
        path.push(i);
        combinationSum3(k, n, i+1, sum + i, path);
        path.pop();
      }
    }
  }
}
