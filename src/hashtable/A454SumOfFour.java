package hashtable;

import java.util.Hashtable;
import java.util.Map;

public class A454SumOfFour {
  private Map<Integer, Integer> getTwoSumDic(int[] nums1, int[] nums2) {
    Map<Integer, Integer> twoSum = new Hashtable<>();

    for (int i : nums1) {
      for(int j: nums2) {
        twoSum.merge(i+j, 1, Integer::sum);
      }
    }

    return twoSum;
  }

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    var sum12 = getTwoSumDic(nums1, nums2);
    var sum34 = getTwoSumDic(nums3, nums4);
    
    int count = 0;

    for(var entry: sum12.entrySet()) {
      var inv = sum34.get((-1) * entry.getKey());
      if(inv != null) {
        count += entry.getValue() * inv;
      }
    }

    return count;
  }
}
