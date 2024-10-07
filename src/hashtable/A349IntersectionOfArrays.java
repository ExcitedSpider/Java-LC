package hashtable;

import java.util.Arrays;
import java.util.stream.Collectors;

public class A349IntersectionOfArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    
    var set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    var set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
  
    set1.retainAll(set2);
    return set1.stream().mapToInt(Integer::intValue).toArray() ;
  }
}
