package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A40CombimationSum2 {
  private List<List<Integer>> solution;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    solution = new ArrayList<>();
    var used = new boolean[candidates.length];
    Arrays.fill(used, false);
    Arrays.sort(candidates);

    combinationSum2(candidates, target, 0, new LinkedList<>(), 0, used);

    return solution;
  }


  public void combinationSum2(
      int[] candidates, int target, int start,
      List<Integer> path, int sum, boolean[] used) {
    if (sum == target) {
      solution.add(new ArrayList<>(path));
    } else {
      for (int i = start; i < candidates.length; i++) {
        if (sum + candidates[i] > target) {
          break;
        }
        // used[i -1] == false ensures that we only skip when a same element is used
        if (i > 0 && candidates[i] == candidates[i - 1] && used[i -1] == false) {
          continue;
        }

        path.addLast(candidates[i]);
        used[i] = true;
        combinationSum2(candidates, target, i + 1, path, sum + candidates[i], used);
        used[i] = false;
        path.removeLast();
      }
    }
  }
}
