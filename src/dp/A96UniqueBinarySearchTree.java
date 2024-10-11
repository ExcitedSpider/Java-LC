package dp;
import java.util.HashMap;
import java.util.Map;

public class A96UniqueBinarySearchTree {
  public int numTrees(int n) {
    return numTrees(n, new HashMap<>());
  }

  // Enumerate by which element is put on the root: 
  // λ(n) = sum { λ(i-1) * λ(n-i) | i in [1, n] }
  // where λ(i-1) is the num of possible left trees
  public int numTrees(int n, Map<Integer, Integer> memo) {
    if(n <= 1) return 1;
    if(memo.containsKey(n)) return memo.get(n);

    var res = 0;
    for (int i = 1; i <= n; i++) {
      res += numTrees(i - 1, memo) * numTrees(n - i, memo);
    }
    memo.put(n, res);

    return res;
  }
}
