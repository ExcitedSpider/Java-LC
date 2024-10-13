package greedy;

// G for greedy
public class A45MinJumpG {
  public int jump(int[] nums) {
    if(nums.length == 1) return 0;

    var preRange = 0;
    var curRange = 0;
    var minStep = 0;

    while(curRange < nums.length - 1) {
      var it = nextCoverRange(nums, preRange, curRange);
      preRange = curRange;
      curRange = it;
      minStep ++;
    }

    return minStep;
  }

  // get next cover in [L, R] range 
  private int nextCoverRange(int[] nums, int curRangeL, int curRangeR) {
    var nextRange = curRangeR;
    for(var i = curRangeL; i <= curRangeR; i ++) {
      nextRange = Math.max(nextRange, nums[i] + i);
    }

    return nextRange;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,1,4}; 
    new A45MinJumpG().jump(nums);
  }
}
