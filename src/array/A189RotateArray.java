package array;

public class A189RotateArray {
  public void rotate(int[] nums, int k) {
    if(nums.length <= 1) return;
    if(k >= nums.length) k = k % nums.length;

    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int from, int to) {
    if(from >= to) return;
    for(; from < to; from ++, to --) {
      var it = nums[from];
      nums[from] = nums[to];
      nums[to] = it;
    }
  }
}
