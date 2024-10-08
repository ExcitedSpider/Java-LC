package hashtable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class A15SumofThree {
  

  // This can ac and understandable
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    Set<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      // it is impossible to find a solution if the first num is positive
      if(nums[i] > 0) {
        return new ArrayList<>(result);
      }

      int left = i + 1;
      int right = nums.length - 1;

      while (right > left) {
        var sum = nums[i] + nums[left] + nums[right];
        if(sum == 0) {
          var solution = Arrays.asList(nums[i], nums[left], nums[right]);
          if(result.contains(solution)) {
            right --;
            left ++;
          }else {
            result.add(solution);
            right --;
            left ++;
          }
          
        } else if(sum < 0) {
          left ++;
        } else {
          right --;
        }
      }
    }
    return new ArrayList<>(result);
  }
}
