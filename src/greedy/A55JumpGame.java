package greedy;

public class A55JumpGame {
  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;
    var maxCover = 0;

    for (int i = 0; i <= maxCover; i++) {
      maxCover = Math.max(maxCover, nums[i] + i);
      if(maxCover >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }
}
