package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A56MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0)
      return intervals;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> intervalList = new ArrayList<>();

    iterator(intervals, intervalList, intervals[0][0], intervals[0][1], 0);

    return intervalList.toArray(new int[0][0]);
  }

  private void iterator(int[][] intervals, List<int[]> acc, int left, int right, int pos) {
    if (pos == intervals.length)
      acc.add(new int[] { left, right });
    else if (intervals[pos][0] <= right) {
      // need to merge with previous one
      iterator(intervals, acc, left, Math.max(right, intervals[pos][1]), pos + 1);
    } else {
      // out of previous range
      acc.add(new int[] { left, right });
      iterator(intervals, acc, intervals[pos][0], intervals[pos][1], pos + 1);
    }
  }
}
