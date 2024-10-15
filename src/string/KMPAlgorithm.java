package string;

import java.util.Arrays;

public class KMPAlgorithm {
  // get the prefix function pi[i] := the longest prefix suffix at position i.
  // https://cp-algorithms.com/string/prefix-function.html
  public int[] prefixFunction(String s) {
    var chars = s.toCharArray();
    int[] pi = new int[chars.length];

    for (int i = 1; i < chars.length; i++) {
      var j = pi[i - 1]; // previous longest prefix suffix 
      while (j > 0 && chars[i] != chars[j]) {
        j = pi[j - 1];
      }
      if (chars[i] == chars[j]) j++;
      pi[i] = j;
    }

    return pi;
  }

  public int contains(String haystack, String needle) {
    var pattern = needle.toCharArray();
    var patternLPS = prefixFunction(needle);
    var text = haystack.toCharArray();

    for (int j = 0 , i = 0; i < text.length; i++) {
      while(j > 0 && text[i] != pattern[j]) {
        j = patternLPS[j - 1];
      }
      if(text[i] == pattern[j]) {
        j ++;
      }
      if(j == needle.length()) {
        return (i - needle.length() + 1);
      }
    }
    return -1;
  }

  public static void testCase1() {
    var s = "aabaaf";
    int[] pi = { 0, 1, 0, 1, 2, 0 };

    var that = new KMPAlgorithm();
    assert Arrays.equals(that.prefixFunction(s), pi);
  }

  public static void testCase2() {
    var s = "abcdef";
    int[] pi = { 0, 0, 0, 0, 0, 0 };

    var that = new KMPAlgorithm();
    assert Arrays.equals(that.prefixFunction(s), pi);
  }

  public static void testCase3() {
    var s = "aaaaaa";
    int[] pi = { 0, 1, 2, 3, 4, 5 };

    var that = new KMPAlgorithm();
    assert Arrays.equals(that.prefixFunction(s), pi);
  }

  public static void testCase4() {
    var s = "ababa";
    int[] pi = { 0, 0, 1, 2, 3 };

    var that = new KMPAlgorithm();
    assert Arrays.equals(that.prefixFunction(s), pi);
  }

  public static void testCase6() {
    var s = "";
    int[] pi = {};

    var that = new KMPAlgorithm();
    assert Arrays.equals(that.prefixFunction(s), pi);
  }

  public static void testCase9() {
    var s = "abcababc";
    int[] pi = { 0, 0, 0, 1, 2, 1, 2, 3 };

    var that = new KMPAlgorithm();
    assert Arrays.equals(that.prefixFunction(s), pi);
  }

  public static void testCase10() {
    String text = "hello world";
    String pattern = "world";

    var that = new KMPAlgorithm();
    assert that.contains(text, pattern) == 6;
  }


  public static void main(String[] args) {
    testCase1();
    testCase2();
    testCase3();
    testCase4();
    testCase6();
    testCase9();
    testCase10();
  }
}
