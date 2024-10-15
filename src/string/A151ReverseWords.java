package string;

import java.util.Arrays;

/**
 * A151ReverseWords
 */
public class A151ReverseWords {
  public String reverseWords(String s) {
    var chars = s.toCharArray();

    chars = removeExtraSpaces(chars);
    reverseString(chars);
    reverseEachWord(chars, 0);

    return new String(chars);
  }

  private void reverseEachWord(char[] s, int pos) {
    if(pos >= s.length) return;
    var wordLength = 0;
    while (wordLength + pos < s.length && s[wordLength + pos] != ' ') {
      wordLength ++;
    }
    if(wordLength < 1) return;

    var start = pos;
    var end = pos + wordLength - 1;
    while(start < end) {
      var it = s[start];
      s[start] = s[end];
      s[end] = it;
      start ++;
      end --;
    }

    reverseEachWord(s, pos + wordLength + 1);
  }

  private void reverseString(char[] s) {
    reverseString(s, 0, s.length - 1);
  }

  private void reverseString(char[] s, int start, int end) {
    if (start >= end)
      return;
    var it = s[start];
    s[start] = s[end];
    s[end] = it;
    reverseString(s, start + 1, end - 1);
  }

  private char[] removeExtraSpaces(char[] chars) {
    if(chars.length == 0) return chars;

    int fastPtr = 0, slowPtr = 0;
    // leading spaces
    while (fastPtr < chars.length && chars[fastPtr] == ' ') {
      fastPtr ++;
    }
    while(fastPtr != chars.length) {
      if (chars[fastPtr] != ' ') {
        chars[slowPtr] = chars[fastPtr];
        slowPtr ++;
        fastPtr ++;
      } else {
        while (fastPtr != chars.length && chars[fastPtr] == ' ') {
          fastPtr ++;
        } 
        if(fastPtr != chars.length) {
          chars[slowPtr] = ' ';
          slowPtr ++;
        }
      } 
    }
    return Arrays.copyOfRange(chars, 0, slowPtr);
  }

  // fancy stream
  public String reverseWords0(String s) {
    return String.join(" ", 
      Arrays.asList(s.split(" ")).reversed().stream().filter(seg -> seg.length() > 0).toList()
    );
  }

  public static void main(String[] args) {
    var that = new A151ReverseWords();
    var res = that.reverseWords("  the sky is  blue "); 
    System.err.println(new String(res));
  }
}