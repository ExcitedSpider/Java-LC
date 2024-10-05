package array;

import java.util.Arrays;

public class A59SpiralMatrix {
  public static int[][] generateMatrix(int n) {
    // m for matrix
    int [][] m = new int[n][n];

    var stepLength = n - 1;
    int x = 0, y = 0;
    var fillVal = 1;

    while (stepLength > 0) {
        // it for iteration
        // draw four edge in clockwise: top, right, bottom, left
        for (int i = 0; i < stepLength; i++) {
          m[x][y] = fillVal;
          fillVal ++;
          y ++;
        }

        for (int i = 0; i < stepLength; i++) {
          m[x][y] = fillVal;
          fillVal ++;
          x ++;
        }

        for (int i = 0; i < stepLength; i++) {
          m[x][y] = fillVal;
          fillVal ++;
          y --;
        }

        for (int i = 0; i < stepLength; i++) {
          m[x][y] = fillVal;
          fillVal ++;
          x --;
        }
        x++;
        y++;
        stepLength -= 2;
      }

    if (stepLength == 0) {
      m[x][y] = fillVal;
    } 

    return m;
  }

  public static void main(String[] args) {
    System.err.println(Arrays.deepToString(
      generateMatrix(2)
    ));

    System.err.println(Arrays.deepToString(
      generateMatrix(3)
    ));

    System.err.println(Arrays.deepToString(
      generateMatrix(4)
    ));
  }
}
