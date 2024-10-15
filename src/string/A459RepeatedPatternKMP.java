package string;

import java.util.Arrays;

public class A459RepeatedPatternKMP {
  public boolean repeatedSubstringPattern(String s) {
    var lps = prefixFunction(s);
    System.err.println(s.length() + "#" + Arrays.toString(lps));
    var len = lps.length;

    return lps[len - 1] == len || lps[len - 1] > 0 && len % (len - lps[len - 1]) == 0; 
  }

  private int[] prefixFunction(String s) {
    int[] pi = new int[s.length()];

    var j = 0;
    for (int i = 1; i < pi.length; i++) {
      while(j > 0 && s.charAt(i) != s.charAt(j) ){
        j = pi[j - 1];
      }
      if(s.charAt(i) == s.charAt(j)) {
        j ++;
      }
      pi[i] = j;
    }
    return pi;
  }

  public static void main(String[] args) {
    System.err.println(
      new A459RepeatedPatternKMP().repeatedSubstringPattern("abcabcabcabc")
    );
    // System.err.println(
    //   new A459RepeatedPatternKMS().repeatedSubstringPattern("ababba")
    // );
    // System.err.println(
    //   new A459RepeatedPatternKMS().repeatedSubstringPattern("abab")
    // );
  }
}
