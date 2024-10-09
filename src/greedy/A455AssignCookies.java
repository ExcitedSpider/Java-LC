package greedy;

import java.util.Arrays;

public class A455AssignCookies {
  public int findContentChildren(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);

      var child = 0;
      for(var i = 0; i < s.length; i ++) {
        if(child == g.length) {
          return g.length;
        } else if(s[i] >= g[child]) {
          child ++;
        }
      }

      return child;
  }
}
