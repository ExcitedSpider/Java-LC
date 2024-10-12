package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A39CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    solution = new ArrayList<>();
    combinationSum(candidates, target, 0, new LinkedList<>(), 0);
    return solution;
  }

  private List<List<Integer>> solution;

  public void combinationSum(int[] candidates, int target, int sum, LinkedList<Integer> path, int start) {
    if(sum == target) {
      solution.add(new ArrayList<>(path));
    } else if (sum > target) {
      return;
    } else {
      for (int i = start; i < candidates.length; i++) {
        path.push(candidates[i]);
        combinationSum(candidates, target, sum + candidates[i], path, i);
        path.pop();
      }
    }
  }

  public static void main(String[] args) {
    int[] candidates = {2,3,6, 7};
    var res = new A39CombinationSum().combinationSum(candidates, 7);
    System.err.println(res);
  }
}
