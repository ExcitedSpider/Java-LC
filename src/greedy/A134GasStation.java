package greedy;

import java.util.Arrays;
import java.util.function.Function;

/**
 * A134GasStation
 */
public class A134GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    Function<int[], Integer> getSum = nums -> Arrays.stream(nums).sum();
    if (getSum.apply(gas) < getSum.apply(cost)) {
      return -1;
    }

    return canCompleteCircuit(gas, cost, 0, 0, 0);
  }

  // starts at `startPos`, currently at `curpos` with gas `sum`
  private int canCompleteCircuit(int[] gas, int[] cost, int startPos, int curPos, int sum) {
    if (sum < 0)
      return canCompleteCircuit(gas, cost, curPos, curPos, 0);
    else if (curPos == gas.length)
      return startPos;
    else
      return canCompleteCircuit(gas, cost, startPos, curPos + 1, sum + gas[curPos] - cost[curPos]);
  }
}