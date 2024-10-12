package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A131Palindrome {
  private List<List<String>> ans;

  public List<List<String>> partition(String s) {
    ans = new ArrayList<>();
    partition(s.toCharArray(), 0, new LinkedList<>());

    return ans;
  }

  private void partition(char[] chars, int startIndex, List<String> path) {
    if(startIndex >= chars.length) {
      ans.add(new ArrayList<>(path));
      return;
    } else {
      for (int i = startIndex; i < chars.length; i++) {
        if(isPalindrome(chars, startIndex, i)) {
          path.addLast(String.valueOf(Arrays.copyOfRange(chars, startIndex, i + 1)));
          partition(chars, i + 1, path);
          path.removeLast();
        }
      }
    }
  }

  private boolean isPalindrome(char[] chars, int start, int end) {
    for (int i = start, j = end; i <= j; i++, j--) {
      if(chars[i] != chars[j]) {
        return false;
      }
    }
    return true;
  }
}