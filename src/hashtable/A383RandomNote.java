package hashtable;

import java.util.Hashtable;
import java.util.Map;

public class A383RandomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Integer, Integer> magazineCounts = new Hashtable<>();

    magazine.chars().forEach(charcode -> {
      magazineCounts.merge(charcode, 1, Integer::sum);
    });

    Map<Integer, Integer> noteCounts = new Hashtable<>();

    ransomNote.chars().forEach(charcode -> {
      noteCounts.merge(charcode, 1, Integer::sum);
    });

    for (var entry : noteCounts.entrySet()) {
      if (!magazineCounts.containsKey(entry.getKey())) {
        return false;
      } else if (magazineCounts.get(entry.getKey()) < entry.getValue()) {
        return false;
      }
    }
    return true;
  }
}
