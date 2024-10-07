package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A202HappyNumber {
  private int[] getDigits(int n) {
    return String.valueOf(n).chars().map(c -> c - '0').toArray();
  }

  public boolean isHappy(int n) {
    Set<Integer> hashtable = new HashSet<>();
    hashtable.add(n);

    while(true) {
      var digits = getDigits(n);
      var sum = Arrays.stream(digits).map(d -> d*d).sum();

      if(sum == 1) {
        return true;
      }else {
        if(hashtable.contains(sum)) {
          return false;
        }else {
          hashtable.add(sum);
          n = sum;
        }
      }
    }
  }

  public static void main(String[] args) {
    var solution = new A202HappyNumber();
    var res = solution.isHappy(19);
    System.err.println(res);
  }
}
