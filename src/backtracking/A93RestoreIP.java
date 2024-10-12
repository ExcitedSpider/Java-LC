package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class A93RestoreIP {
  private List<List<char[]>> ans;

  public List<String> restoreIpAddresses(String s) {
    ans = new ArrayList<>(); 

    restoreIpAddresses(s.toCharArray(), 0, new LinkedList<>());
    
    List<String> result = new ArrayList<>(ans.size());
    for (var listOfChars: ans) {
      result.add(
        listOfChars.stream().map(String::valueOf).collect(Collectors.joining("."))
      );
    }
    return result;
  }

  private void restoreIpAddresses(char[] chars, int start, List<char[]> segments) {
    if(segments.size() > 4) {
      return;
    } else if(start == chars.length) {
      // optimize this later
      if(segments.size() == 4) ans.add(new ArrayList<>(segments));
    } else {
      for (int i = start; i < chars.length - (4 - segments.size()); i++) {
        if(isValidIP(chars, start, i)) {
          segments.addLast(Arrays.copyOfRange(chars, start, i + 1));
          restoreIpAddresses(chars, i + 1, segments);
          segments.removeLast();
        }
      }
    }
  }

  private boolean isValidIP(char[] chars, int start, int end) {
    var length = end - start + 1;
    if(length <= 0) return false;
    else if(length == 1) return true;
    else if(chars[start] == '0') return false;
    else {
      int num = 0;
      for(int i = start; i <= end; i++) {
        num = num *10 + (chars[i] - '0');
        if(num > 255) return false;
      }
      return num <= 255;
    }

  }
}
