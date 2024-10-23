package greedy;

public class A860Lemonade {
  class Nat {
    int value;

    public int getValue() {
      return this.value;
    }

    public void inc(int diff) {
      value = value + diff;
    }

    // false for cannot decrease
    public boolean dec(int diff) {
      if (value - diff < 0) {
        return false;
      } else {
        value = value - diff;
        return true;
      }
    }
  }

  public boolean lemonadeChange(int[] bills) {
    Nat nums5Bill = new Nat();
    Nat nums10Bill = new Nat();

    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        nums5Bill.inc(1);
        ;
      } else if (bills[i] == 10) {
        if (!nums5Bill.dec(1))
          return false;
        nums10Bill.inc(1);
      } else {
        if (!nums5Bill.dec(1))
          return false;
        if (nums10Bill.dec(1)) {
          continue;
        } else {
          if (!nums5Bill.dec(2))
            return false;
        }
      }
    }

    return true;
  }
}
