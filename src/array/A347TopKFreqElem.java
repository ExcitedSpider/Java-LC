package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/**
 * A347TopKFreqElem
 */
public class A347TopKFreqElem {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numFreqDict = new HashMap<>();

    for (int i : nums) {
      numFreqDict.compute(i, ($_, v) -> v == null ? 1 : v + 1);
    }

    PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    for (var entry : numFreqDict.entrySet()) {
      pq.add(entry);
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll().getKey();
    }
    return res;
  }
}