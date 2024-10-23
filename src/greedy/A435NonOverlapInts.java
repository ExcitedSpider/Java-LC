package greedy;

import java.util.Arrays;

/**
 * A435NonOverlapInts
 */
public class A435NonOverlapInts {
  int minRemoval = 0;

  public int eraseOverlapIntervals(int[][] intervals) {
    if(intervals.length == 0) return 0;

    minRemoval = 0;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    iterate(intervals, intervals[0][1], 1);
    return minRemoval;
  }

  // right := the right bound of previous interval 
  private void iterate(int[][] intervals, int right, int pos) {
    if(pos == intervals.length) return;

    var interval = intervals[pos];

    if(right <= interval[0]) {
      iterate(intervals, interval[1], pos + 1);
    } else {
      minRemoval ++;
      // greedy: just remove the element with max right bound  
      iterate(intervals, Math.min(right, interval[1]), pos + 1); 
    }
  }
}