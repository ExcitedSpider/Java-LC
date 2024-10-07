package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class A1SumOfTwo {
  int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> m = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
      m.put(nums[i], i);
    } 

    for (int i = 0; i < nums.length; i++) {
      var diff = target - nums[i];
      var position = m.get(diff);
      if(position != null && position != i) {
        return new int[] {i, position};
      }
    }
    return null;
  }
}
