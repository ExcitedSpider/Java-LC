package linkedlist;

class ListNode {
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
}

public class A206ReversedList {
  private ListNode reverseList0(ListNode cur, ListNode next) {
    if(next == null || cur == null) {
      return cur;
    } 

    var nn = next.next;
    next.next = cur;
    return reverseList0(next, nn);
  }

  public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    } else {
      var next = head.next;
      head.next = null;
      return reverseList0(head, next);
    }
  }
}
