package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A763PartitionLabels {
  public List<Integer> partitionLabels(String s) {
    if(s.length() == 0) return new ArrayList<>();

    Map<Character, Integer> lastOccurrenceMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      lastOccurrenceMap.merge(s.charAt(i), i, (a, b) -> Math.max(a, b));
    }

    // 𝜋[i] := the last occurrence of letter 𝜋[i] in the string
    int[] 𝜋 = new int[s.length()];
    for (int i = 0; i < 𝜋.length; i++) {
      𝜋[i] = lastOccurrenceMap.get(s.charAt(i));
    }

    List<Integer> partitions = new ArrayList<>();
    iterate(𝜋, partitions, 0, 𝜋[0], 1);
    return partitions;
  }

  // accumulate a record of range [left, right) in acc, in which that each letter appears in at most one
  // part.
  private void iterate(int[] 𝜋, List<Integer> acc, int left, int right, int pos) {
    if (pos == 𝜋.length)
      return;
    else if (pos == right) {
      acc.add(right - left + 1);
      if(pos < 𝜋.length - 1) iterate(𝜋, acc, pos + 1, 𝜋[pos + 1], pos + 1);
    } else {
      iterate(𝜋, acc, left, Math.max(right, 𝜋[pos]), pos + 1);
    }
  }
}
