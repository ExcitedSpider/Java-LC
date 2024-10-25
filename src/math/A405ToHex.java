package math;

public class A405ToHex {
  private static char[] hexas = "0123456789abcdef".toCharArray(); 

  public String toHex(int num) {
    if(num == 0) return "0";
    
    // java does not have unsigned int
    // so we need to do it by adding a 2^32
    // because java use two's complement to represent signed int
    long unsigned_num = num;
    if(num <0) unsigned_num = num + (1L << 32);

    var sb = new StringBuilder();
    while (unsigned_num != 0) {
      var remainder = (int) (unsigned_num % 16);
      sb.append(hexas[remainder]);
      unsigned_num /= 16;
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    var solver = new A405ToHex();
    System.err.println(solver.toHex(38));
  }
}
