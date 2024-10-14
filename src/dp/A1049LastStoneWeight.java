package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class A1049LastStoneWeight {
  public int lastStoneWeightII(int[] stones) {
    var sum = IntStream.of(stones).sum();
    var targetCap = sum / 2;

    int[][] memo = new int[stones.length][targetCap + 1];
    for (int[] is : memo) {
      Arrays.fill(is, -1);
    }

    return sum - 2 * maxWeight(stones, stones.length - 1, targetCap, memo);
  }

  // λ pos cap : the max weight using a bag with capacity `cap` to pick from [0, pos] elements
  // λ pos cap := max (weight[pos] + λ(pos - 1, cap - weight[pos]), λ(pos - 1, cap)) 
  public int maxWeight(int[] stones, int pos, int cap, int[][] memo) {
    if(pos < 0 || cap <= 0) return 0; 
    else if(memo[pos][cap] != -1) return memo[pos][cap];
    else if(cap - stones[pos] >= 0) {
      memo[pos][cap]= Math.max(
        stones[pos] + maxWeight(stones, pos - 1, cap - stones[pos], memo),
        maxWeight(stones, pos -1, cap, memo));
    }else {
      memo[pos][cap] = maxWeight(stones, pos -1, cap, memo);
    }
    return memo[pos][cap];
  }
}
