package dp;
import java.util.Arrays;

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class AKnapsack {
  public int knapsack(int n, int w, int[] profit, int[] weight) {
    var memo = new int[n][w + 1];
    // initialization
    for(var row: memo) {
      Arrays.fill(row, -1);
    }
    for(var i = 0; i < w; i++){
      memo[0][i] = i >= weight[0] ? profit[0] : 0;
    }
    for(var i = 0; i < n; i++){
      memo[i][0] = 0;
    }

    return knapsack(n - 1, w, profit, weight, memo);
  }

  // λ(i, j) = max λ(i-1, j) (profit[i] + λ(j - w[i]))
  private int knapsack(int n, int w, int[] profit, int[] weight, int[][] memo) {
    if(n < 0 || w < 0) return 0;
    if(memo[n][w] != -1) return memo[n][w];

    int res;
    if(w >= weight[n]) {
      res = Math.max(
        knapsack(n-1, w, profit, weight, memo),
        profit[n] + knapsack(n-1, w - weight[n], profit, weight, memo)
      );
    }else {
      res = knapsack(n-1, w, profit, weight, memo);
    }

    memo[n][w] = res;
    return res;
  }

  public static void main(String[] args) {
    AKnapsack.case1();
    AKnapsack.case2();
    AKnapsack.case3();
    AKnapsack.case4();
    AKnapsack.case5();
    AKnapsack.case6();
  }

  static void case1() {
    int[] profit = {60, 100, 120};
    int[] weight = {10, 20, 30};
    int capacity = 50; // Maximum weight capacity

    AKnapsack knapsack = new AKnapsack();
    int maxProfit = knapsack.knapsack(profit.length, capacity, profit, weight);
    System.out.println("Max profit: " + maxProfit + ". Expected output: 220");
  }

  static void case2() {
    int[] profit = {10, 20, 30};
    int[] weight = {5, 10, 15};
    int capacity = 0; // No capacity
    
    AKnapsack knapsack = new AKnapsack();
    int maxProfit = knapsack.knapsack(profit.length, capacity, profit, weight);
    System.out.println("Max profit: " + maxProfit + ". Expected output: 0");
    
  }

  static void case3() {
    int[] profit = {100, 200, 150};
    int[] weight = {1, 2, 3};
    int capacity = 6; // Larger capacity than total weights
    
    AKnapsack knapsack = new AKnapsack();
    int maxProfit = knapsack.knapsack(profit.length, capacity, profit, weight);
    System.out.println("Max profit: " + maxProfit + ". Expected output: 450");   
  
  }

  static void case4() {
    int[] profit = {50, 100, 150};
    int[] weight = {10, 20, 30};
    int capacity = 10; // Can only select one item
    
    AKnapsack knapsack = new AKnapsack();
    int maxProfit = knapsack.knapsack(profit.length, capacity, profit, weight);
    System.out.println("Max profit: " + maxProfit + ". Expected output: 50");
    
  }

  static void case5() {
    int[] profit = {10, 20, 30};
    int[] weight = {10, 20, 30};
    int capacity = 40; // Can select only two items
    
    AKnapsack knapsack = new AKnapsack();
    int maxProfit = knapsack.knapsack(profit.length, capacity, profit, weight);
    System.out.println("Max profit: " + maxProfit + ". Expected output: 40");
  }

  static void case6() {
    int[] profit = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int[] weight = {1, 2, 3, 8, 7, 4, 5, 6, 9, 10};
    int capacity = 30; // Maximum weight capacity

    AKnapsack knapsack = new AKnapsack();
    int maxProfit = knapsack.knapsack(profit.length, capacity, profit, weight);
    System.out.println("Max profit: " + maxProfit + ". Expected output: 360");  
  }
}
