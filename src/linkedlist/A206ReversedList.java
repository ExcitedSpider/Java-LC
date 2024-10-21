package linkedlist;

public class A206ReversedList {
  private ListNode reverseList(ListNode pre, ListNode cur) {
    if(cur == null) {
      return pre;
    } 

    var next = cur.next;
    cur.next = pre;
    return reverseList(cur, next);
  }

  public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    } else {
      return reverseList(null, head);
    }
  }
}
