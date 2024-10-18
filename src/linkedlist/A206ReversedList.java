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
  private ListNode reverseList0(ListNode pre, ListNode cur) {
    if(cur == null || pre == null) {
      return pre;
    } 

    var nn = cur.next;
    cur.next = pre;
    return reverseList0(cur, nn);
  }

  public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    } else {
      var next = head.next;
      head.next = null; // pay attention to this!
      return reverseList0(head, next);
    }
  }
}
