package greedy;

public class A376WiggleSubsequence {
  public int wiggleMaxLength(int[] nums) {
    return countWiggleLength(nums, 0, 0, 0);
  }

  private int countWiggleLength(int[] nums, int pos, int count, int prediff) {
    if(pos == nums.length) {
      return count;
    } else if(pos == 0){
      return countWiggleLength(nums, pos + 1, count + 1,0);
    } else {
      var diff = nums[pos] - nums[pos - 1];
      if((prediff <= 0 && diff > 0) || (prediff >= 0 && diff < 0)) {
        return countWiggleLength(nums, pos + 1, count + 1,diff);
      }else {
        return countWiggleLength(nums, pos + 1, count, prediff);
      }
    }
  }
}
