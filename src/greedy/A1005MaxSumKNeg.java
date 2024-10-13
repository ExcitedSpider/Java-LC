package greedy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class A1005MaxSumKNeg {
  public int largestSumAfterKNegations(int[] nums, int k) {
    // by the constraints, (int) is safe
    Function<int[], Integer> getNumOfNeg = nums0 -> (int) Arrays.stream(nums0).filter(num -> num < 0).count();

    var numOfNeg = getNumOfNeg.apply(nums);
    if(k >= numOfNeg) {
      if((k - numOfNeg) % 2 == 0) {
        return Arrays.stream(nums).map(Math::abs).sum();
      } else {
        var absArr = Arrays.stream(nums).map(Math::abs).toArray();
        Arrays.sort(absArr);
        absArr[0] = -1 * absArr[0];
        return Arrays.stream(absArr).sum();
      }
    } else {
      Arrays.sort(nums);
      AtomicInteger count = new AtomicInteger(0);

      return Arrays.stream(nums).map(num -> {
        var numOfApplied = count.getAndIncrement();
        if(numOfApplied < k) {
          return (-1) * num;
        } else {
          return num;
        }
      }).sum();
    }
  }
}
