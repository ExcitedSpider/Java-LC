package string;

import java.util.Arrays;

/**
 * A151ReverseWords
 */
public class A151ReverseWords {
  public String reverseWords(String s) {
    return String.join(" ", 
      Arrays.asList(s.split(" ")).reversed().stream().filter(seg -> seg.length() > 0).toList()
    );
  }
}