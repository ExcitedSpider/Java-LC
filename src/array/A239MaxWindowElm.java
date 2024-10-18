package array;

import java.util.Deque;
import java.util.LinkedList;

public class A239MaxWindowElm {
  MonotonicQueue q;
  int[] maxs;

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k > nums.length)
      return null;

    q = new MonotonicQueue();
    maxs = new int[nums.length - k];

    for (int i = 0; i < k; i++) {
      q.add(nums[i]);
    }

    maxSlidingWindow(nums, k, k);
    maxs[maxs.length - 1] = q.peek();

    return maxs;
  }

  public void maxSlidingWindow(int[] nums, int k, int nextPos) {
    if (nextPos >= nums.length)
      return;

    maxs[nextPos - k] = q.peek();
    if (nums[nextPos - k] == q.peek())
      q.poll();

    q.add(nums[nextPos]);

    maxSlidingWindow(nums, k, nextPos + 1);
  }

  static A239MaxWindowElm ins = new A239MaxWindowElm();

  public static void main(String[] args) {
    int[] nums = { 1, 3, 1, 2, 0, 5 };
    ins.maxSlidingWindow(nums, 3);

  }
}

// Keep monotonic
// forall i < q.len, q[i] > q[i+1]
// to keep the property,
// we will remove all elements that smaller than the added one
class MonotonicQueue {
  Deque<Integer> deque = new LinkedList<>();

  Integer poll() {
    if (!deque.isEmpty()) {
      return deque.poll();
    }
    return null;
  }

  Integer peek() {
    return deque.peek();
  }

  void add(Integer val) {
    while (!deque.isEmpty() && val > deque.peekLast()) {
      deque.removeLast();
    }
    deque.add(val);
  }
}