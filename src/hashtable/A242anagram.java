package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class A242anagram {
  public boolean isAnagram(String s, String t) {
    Function<String, Map<Character, Integer>> getCharFreq = (s0) -> {
      Map<Character, Integer> freqMap = new HashMap<>();
      
      s0.chars()
        .mapToObj(c -> (char) c)
        .forEach(c -> {
          freqMap.merge(c, 1, Integer::sum);
      });

      return freqMap;
    };

    var freqS = getCharFreq.apply(s);
    var freqT = getCharFreq.apply(t);

    return freqS.equals(freqT);
  }
}
