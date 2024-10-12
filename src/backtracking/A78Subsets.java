package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A78Subsets
 */
public class A78Subsets {
  List<List<Integer>> ans;

  public List<List<Integer>> subsets(int[] nums) {
      ans = new ArrayList<>();

      subsets(nums, 0, new LinkedList<>());

      return ans;
  }

  private void subsets(int[] nums, int start, List<Integer> path) {
    ans.add(new ArrayList<>(path));
    if(start > nums.length) return;

    for (int i = start; i < nums.length; i++) {
      path.addLast(nums[i]);
      subsets(nums, i+1, path);
      path.removeLast();
    }
  }
  
}