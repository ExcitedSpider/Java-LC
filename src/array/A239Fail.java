package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Fail to understand the meaning of the question
// I thought it was: finding the window which max the sum of the window.
public class A239Fail {
  int max;
  int[] maxWindow;

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length < k)
      return null;
    // try benchmark linked list
    Deque<Integer> window = new ArrayDeque<>(k);

    var sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
      window.addLast(nums[i]);
    }

    maxSlidingWindow(nums, k, k, window, sum);
    return maxWindow;
  }

  public void maxSlidingWindow(int[] nums, int k, int nextPos, Deque<Integer> window, int sum) {
    if (nextPos == nums.length)
      return;

    if (sum > max) {
      max = sum;
      maxWindow = Arrays.copyOfRange(nums, nextPos - k, nextPos);
    }

    var removed = window.removeFirst();
    var added = nums[nextPos];
    window.addLast(added);

    maxSlidingWindow(nums, k, nextPos + 1, window, sum - removed + added);
  }
}
