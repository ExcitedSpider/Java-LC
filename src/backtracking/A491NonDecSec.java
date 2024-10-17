package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A491NonDecSec {
  List<List<Integer>> ans;

  public List<List<Integer>> findSubsequences(int[] nums) {
    ans = new ArrayList<>();
    findSubsequences0(nums, 0, -1, new ArrayList<>());

    return new ArrayList<>(new HashSet<>(ans));
  }

  private void findSubsequences0(int[] nums, int start, int last, List<Integer> path) {
    if(start >= nums.length) return;
    if(path.size() > 0) ans.addLast(new ArrayList<>(path));

    for (int i = start; i < nums.length; i++) {
      if(last < 0 || nums[i] >= nums[last]) {
        path.addLast(nums[i]);

        findSubsequences0(nums, i + 1, i, path);

        path.removeLast();
      }
    }
  }
}
