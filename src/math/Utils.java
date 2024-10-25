package math;

public class Utils {
  double roundTo1N(double value) {
    return Math.round(value * 10) / 10.0;
  }

  double floorTo1N(double value) {
    return Math.floor(value * 10) / 10.0;
  }

  String to1NString(double value) {
    return String.format("%.1f", value);
  }

  public static void main(String[] args) {
    var ut = new Utils();
    assert ut.roundTo1N(0.15) == 0.2: "RoundTo1N 0.15 = 0.2";
    assert ut.floorTo1N(0.15) == 0.1: "RoundTo1N 0.15 = 0.1";
    assert ut.to1NString(0.15).equals("0.2"): "RoundTo1N 0.15 = 0.2";
  }
}
