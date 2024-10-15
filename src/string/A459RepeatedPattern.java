package string;

public class A459RepeatedPattern {
  public boolean repeatedSubstringPattern(String s) {
      for (int i = 1; i < s.length() / 2 + 1; i++) {
        if(s.length() % i != 0) {
          continue;
        }
        String prod = scale(s.substring(0, i), s.length() / i);
        System.err.println(prod);

        if(prod.equals(s)) {
          return true;
        }
      }
      return false;
  }

  private String scale(String s, int factor) {
    var sb = new StringBuilder(s.length() * factor);
    for (int i = 0; i < factor; i++) {
      sb.append(s);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.err.println(
      new A459RepeatedPattern().repeatedSubstringPattern("abcabcabcabc")
    );
  }
}
