package string;

public record A28FirstOccurence() {
  public int strStr(String haystack, String needle) {
    var conc = needle + "#" + haystack;

    int[] pi = prefixFunction(conc);

    for (int i = needle.length() + 1; i < pi.length; i++) {
      if (pi[i] == needle.length()) {
        return i - 2 * needle.length();
      }
    }

    return -1;
  }

  private int[] prefixFunction(String needle) {
    int[] pi = new int[needle.length()];

    int j = 0;
    for (int i = 1; i < pi.length; i++) {
      while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
        j = pi[j - 1];
      }
      if (needle.charAt(i) == needle.charAt(j)) {
        j++;
      }
      pi[i] = j;
    }

    return pi;
  }

  public static void main(String[] args) {
    var res = new A28FirstOccurence().strStr("sadbutsad", "sad");
    System.err.println(res);
  }
}
