package greedy;

public class A55JumpGame {
  public boolean canJump(int[] nums) {
    if(nums.length <= 1) return true;

    var maxRange = getMaxCover(nums, 0, nums[0]);
    return maxRange >= nums.length - 1;
  }

  private int getMaxCover(int[] nums, int pos, int rangeCover) {
    if(rangeCover >= nums.length -1 || pos > rangeCover) return rangeCover;

    var nextRange = pos + nums[pos];
    if(nextRange > rangeCover) return getMaxCover(nums, pos + 1, nextRange);
    else return getMaxCover(nums, pos + 1, rangeCover);
  }
}
