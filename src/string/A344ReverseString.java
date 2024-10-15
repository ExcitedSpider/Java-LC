package string;

public class A344ReverseString {
  public void reverseString(char[] s) {
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

  public void reverseString0(char[] s) {
    var start = 0;
    var end = s.length - 1;

    while (start < end) {
      var it = s[start];
      s[start] = s[end];
      s[end] = it;
      start++;
      end--;
    }
  }
}
