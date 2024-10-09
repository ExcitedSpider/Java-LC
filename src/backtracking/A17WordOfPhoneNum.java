package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A17WordOfPhoneNum {
  private List<String> solution;
  static Map<Integer, char[]> numCharRel;

  public List<String> letterCombinations(String digits) {
    initNumCharRel();
    solution = new ArrayList<>();
    int[] digitNums = digits.chars().map(code -> code - '0').toArray();

    if(digits.length() != 0) {
      letterCombinations(
        digitNums,
        0,
        new LinkedList<>()
      );
    }
    return solution;
  }

  private void initNumCharRel() {
    numCharRel = new HashMap<>();
    numCharRel.put(2, new char[]{'a', 'b', 'c'});
    numCharRel.put(3, new char[]{'d', 'e', 'f'});
    numCharRel.put(4, new char[]{'g', 'h', 'i'});
    numCharRel.put(5, new char[]{'j', 'k', 'l'});
    numCharRel.put(6, new char[]{'m', 'n', 'o'});
    numCharRel.put(7, new char[]{'p', 'q', 'r', 's'});
    numCharRel.put(8, new char[]{'t', 'u', 'v'});
    numCharRel.put(9, new char[]{'w', 'x', 'y', 'z'});
  }

  public void letterCombinations(int[] digits, int pos, LinkedList<Character> path) {
    if(pos == digits.length) {
      String word = path.reversed().stream().map(String::valueOf).collect(Collectors.joining());
      solution.add(word);
    }else {
      var candicates = numCharRel.get(digits[pos]);
      for (var c: candicates) {
        path.push(c);
        letterCombinations(digits, pos + 1, path);
        path.pop();
      }
    }
  }
}
