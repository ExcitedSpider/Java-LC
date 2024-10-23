package greedy;

import java.util.Arrays;

public class A452MinNumOfArrows {
  int minShots;

  public int findMinArrowShots(int[][] points) {
    if (points.length == 0)
      return 0;

    minShots = 1;
    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // good! no need to consider overflow

    // this works but java no TRO
    iterate(points, points[0][0], points[0][1], 1);

    return minShots;
  }

  // left & right: previous arrow shotting range
  private void iterate(int[][] points, int left, int right, int pos) {
    if (pos == points.length)
      return;

    var point = points[pos];

    // can be shot with the previous ballon
    if (point[0] <= right) {
      iterate(points, point[0], Math.min(right, point[1]), pos + 1);
    } else {
      // cannot
      minShots++;
      iterate(points, points[pos][0], points[pos][1], pos + 1);
    }
  };

  public static void main(String[] args) {
    int[][] testcase = { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 },
        { 2, 8 } };
    var ins = new A452MinNumOfArrows();
    ins.findMinArrowShots(testcase);
  }
}
