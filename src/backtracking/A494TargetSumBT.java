package backtracking;

import java.util.stream.IntStream;

public class A494TargetSumBT {
  public int findTargetSumWays(int[] nums, int target) {
    var sum = IntStream.of(nums).sum();
    if ((sum + target) % 2 != 0)
      return 0;

    var targetSubsetSum = (sum + target) / 2;

    return search(nums, 0, targetSubsetSum, 0);

  }

  private int search(int[] nums, int startIndex, int target, int acc) {
    if (acc > target || acc < target && startIndex == nums.length) return 0;

    int sumOfAns = acc == target ? 1 : 0;
    for (var i = startIndex; i < nums.length; i++) {
      sumOfAns += search(nums, i + 1, target, acc + nums[i]);
    }

    return sumOfAns;
  }
}
