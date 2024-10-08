package hashtable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class A15SumofThree {
  

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>(); 
    // solution strings, use to avoid duplicated
    // can ac but terrible performance
    Set<String> sStrings = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if(nums[i] > 0) {
        return result;
      }

      int left = i + 1;
      int right = nums.length - 1;

      while (right > left) {
        var sum = nums[i] + nums[left] + nums[right];
        if(sum == 0) {
          var solution = Arrays.asList(nums[i], nums[left], nums[right]);
          if(sStrings.contains(solution.toString())) {
            right --;
            left ++;
          }else {
            result.add(solution);
            sStrings.add(solution.toString());
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
    return result;
  }
}
