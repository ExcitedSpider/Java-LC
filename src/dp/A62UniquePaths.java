package dp;

import java.util.Arrays;

public class A62UniquePaths {
  public int uniquePaths(int m, int n) {
    int [][] memo = new int[m][n];
    for(var row: memo) {
      Arrays.fill(row, -1);
    }

    return uniquePaths(m - 1, n - 1, memo);
  }

  // λ(m, n) = λ(m, n-1) + λ(m-1, n)
  public int uniquePaths(int m, int n, int [][] memo) {
    if(m == 0 && n == 0) return 1;
    if(m < 0 || n < 0) return 0;

    if(memo[m][n] != -1) return memo[m][n];

    memo[m][n] = uniquePaths(m-1, n, memo) + uniquePaths(m, n -1, memo);
    
    return memo[m][n];
  }


  public static void main(String[] args) {
    System.err.println(new A62UniquePaths().uniquePaths(2, 6));
  }
}
