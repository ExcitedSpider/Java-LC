package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A131Palindrome {
  private List<List<String>> ans;

  public List<List<String>> partition(String s) {
    isPalindromeMemo = new int[s.length()][s.length()];
    for(var row: isPalindromeMemo) {
      Arrays.fill(row, -1);
    }

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

  // 1 for true, 0 for false, -1 for uncomputed
  private int[][] isPalindromeMemo;

  private boolean isPalindrome(char[] chars, int start, int end) {
    if(start > end) return true;
    else if(isPalindromeMemo[start][end] != -1) {
      return isPalindromeMemo[start][end] == 1 ? true: false;
    } else if(chars[start] != chars[end]) {
      isPalindromeMemo[start][end] = 0;
      return false;
    } else {
      var res = isPalindrome(chars, start + 1, end - 1);
      isPalindromeMemo[start][end] = res ? 1 : 0;
      return res;
    }
  }
}