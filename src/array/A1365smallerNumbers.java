package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A1365smallerNumbers {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    var sorted = nums.clone();
    Arrays.sort(sorted);

    Map<Integer, Integer> orderMap = new HashMap<>();
    for (int i = 0; i < sorted.length; i++) {
      if(!orderMap.containsKey(sorted[i])) {
        orderMap.put(sorted[i], i);
      }
    }

    int[] orders = new int[nums.length];
    for (int i = 0; i < orders.length; i++) {
      orders[i] = orderMap.get(nums[i]);
    }
    return orders;
  }
}
