package linkedlist;

public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void printVal() {
    var sb = new StringBuilder();
    var node = this;
    for (;node != null; node = node.next) {
        sb.append("->");
        sb.append(node.val);
    }
    System.err.println(sb.toString());
  }
}
