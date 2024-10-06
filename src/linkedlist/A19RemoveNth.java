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

public class A19RemoveNth {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      var nhead = new ListNode(-1, head);
      var cur = nhead;
      var fastPtr = cur;
      var slowPtr = cur;
      // lack of safety guard
      while (n!=0) {
        if(fastPtr.next == null) {return head;}
        fastPtr = fastPtr.next;
        n--;
      }
      while(fastPtr.next != null) {
        fastPtr = fastPtr.next;
        slowPtr = slowPtr.next;
      }

      slowPtr.next = slowPtr.next.next;

      return nhead.next;
  }
}
