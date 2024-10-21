package linkedlist;

public class A24SwapNodes {
  private ListNode swapPairs0(ListNode pre) {
    if(pre == null || pre.next == null || pre.next.next == null) {
      return pre;
    }

    var cur = pre.next;
    var next = cur.next;
    var nn = next.next;

    pre.next = next;
    next.next = cur;
    cur.next = nn;
    
    return swapPairs0(cur);
  }

  public ListNode swapPairs(ListNode head) {
    var nhead = new ListNode();
    nhead.next = head;
    swapPairs0(nhead);
    return nhead.next;
  }
}
