package greedy;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class A55JumpGame {
  public boolean canJump(int[] nums) {
    if(nums.length <= 1) return true;

    AtomicInteger index = new AtomicInteger(0);
    
    var canJumpTos = IntStream.of(nums).map(jumpLength -> {
      int idx = index.getAndIncrement();
      return jumpLength + idx;
    }).toArray();    

    return canJump(canJumpTos, 0, nums.length -1 );
  }

  private boolean canJump(int[] canJumpTos, int pos, int target) {
    if(pos >= target) return true;
    var next = maxNextJump(canJumpTos, pos, canJumpTos[pos]);
    if(next == -1) return false;
    return canJump(canJumpTos, next, target);
    
  }

  private int maxNextJump(int[] canJumpTos, int start, int end) {
    if(start >= end) return -1;
    var res = 0;
    var nextPos = -1;
    for (int i = start; i <= Math.min(end, canJumpTos.length  -1); i++) {
      if(canJumpTos[i] > res && i != start) {
        res = canJumpTos[i];
        nextPos = i;
      }
    }
    return nextPos;
  }

  public static void main(String[] args) {
    int[] testcase = {3,2,1,0,4};
    var res = new A55JumpGame().canJump(testcase);
    System.err.println(res);
  }
}
