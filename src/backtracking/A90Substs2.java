package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A90Substs2
 */
public class A90Substs2 {
  List<List<Integer>> ans;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    ans = new ArrayList<>();
    subsetsWithDup(nums, 0, new ArrayList<>());

    return ans;
  }

  private void subsetsWithDup(int[] nums, int start, List<Integer> path) {
    ans.add(new ArrayList<>(path));
    if(start > nums.length) return;

    boolean[] used = new boolean[nums.length];

    for (int i = start; i < nums.length; i++) {
      if(i > 0 && nums[i] == nums[i-1] && used[i -1]) {
        used[i] = true;
        continue;
      }
      path.addLast(nums[i]);
      subsetsWithDup(nums, i + 1, path);
      path.removeLast();
      used[i] = true;
    }
  }
}