package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// efficient remove duplicates
// not involve sets
public class A491NonDecSecE {
  List<List<Integer>> ans;

  public List<List<Integer>> findSubsequences(int[] nums) {
    ans = new ArrayList<>();
    findSubsequences0(nums, 0, -1, new ArrayList<>());

    // this trick to remove duplicates works, but not so efficient
    return ans;
  }

  private void findSubsequences0(int[] nums, int start, int last, List<Integer> path) {
    if(start > nums.length) return;
    if(path.size() > 1) ans.addLast(new ArrayList<>(path));

    Set<Integer> used = new HashSet<>();

    for (int i = start; i < nums.length; i++) {
      if(!used.contains(nums[i]) && (last < 0 || nums[i] >= nums[last])) {
        used.add(nums[i]);
        path.addLast(nums[i]);

        findSubsequences0(nums, i + 1, i, path);

        path.removeLast();
      }
    }
  }
}
