package dp;

import java.util.HashMap;
import java.util.Map;

public class A343IntegerBreak {
  public int integerBreak(int n) {
    return integerBreak(n, new HashMap<>());
  }

  // λ(n) = max { max (i * (n-i)) (i * λ(n-i)) | forall i in [1, n-1]}
  public int integerBreak(int n, Map<Integer, Integer> memo) {
      if(n <= 2) return 1;
      if(memo.containsKey(n)) return memo.get(n);
      
      var res = 0;
      for(var i = 1; i < n; i ++) {
        res = Math.max(res, 
            Math.max(i * (n - i), i * integerBreak(n - i, memo)));
      }
      memo.put(n, res);

      return res;
  }
}
