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
