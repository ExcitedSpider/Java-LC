package string;

public class A541ReverseStringK {
  public String reverseStr(String s, int k) {
    return new String(reverseFirstK(s.toCharArray(), 0, k));
  }

  private char[] reverseFirstK(char[] charArray, int start, int k) {
    if(start >= charArray.length) return charArray;

    var startPtr = start;
    var endPtr = Math.min(start + k - 1, charArray.length - 1);
    while (startPtr < endPtr) {
      var it = charArray[startPtr];
      charArray[startPtr] =charArray[endPtr];
      charArray[endPtr] = it; 
      startPtr ++;
      endPtr --;
    }

    return reverseFirstK(charArray, start + 2*k, k);
  }

  public static void main(String[] args) {
    System.err.println(new A541ReverseStringK().reverseStr("abcdefg", 2));
  }
}
